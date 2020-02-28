
/* global parameters_button, message_btn_primary, message_btn_secondary, LINKS, ajax, confirmation_btn_secondary, confirmation_show, curso_btn_secondary */

function crud_curso_init(event) {
    loadTableHead(['Código', 'Nombre', 'Créditos', 'Horas Semanales', 'Año', 'Ciclo', 'Carrera', 'Acciones']);
    init_table();
    loadTitle();
    loadButton();
    list();
}

function loadTableHead(parameters) {
    var row = document.getElementById("table_head").insertRow(0);
    row.innerHTML = '<th>' + parameters[0] + '</th>' +
            '<th>' + parameters[1] + '</th>' +
            '<th>' + parameters[2] + '</th>' +
            '<th>' + parameters[3] + '</th>' +
            '<th>' + parameters[4] + '</th>' +
            '<th>' + parameters[5] + '</th>' +
            '<th>' + parameters[6] + '</th>' +
            '<th>' + parameters[7] + '</th>';
}

function init_table() {
    var fecha = new Date();
    $('#table_data').DataTable({
        paging: false,
        info: false,
        filter: false,
        language: {
            "paginate": {
                "first": "Primera",
                "last": "Última",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "search": "Buscar:",
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Ningún dato disponible en esta tabla",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "No se encontraron datos",
            "infoFiltered": "(Filtrado de un total de _MAX_ registros)"
        },
        dom: '<"float-left"B> <"float-right"f>t<"row"<"col-sm-5"l><"col-sm-3"i><"col-sm-4"p>>',
        buttons: [
            {
                extend: 'pdf',
                text: '<i class="fa fa-file-pdf-o" title="Exportar a PDF"></i>',
                messageTop: 'Sistema de Matrícula',
                title: 'Reporte de cursos ' + fecha.getDate() + '-' + (1 + fecha.getMonth()) + '-' + fecha.getFullYear(),
                exportOptions: {
                    columns: [0, 1, 2, 3]
                }
            },
            {
                extend: 'excel',
                text: '<i class="fa fa-file-excel-o" title="Exportar a Excel"></i>',
                messageTop: 'Sistema de Matrícula',
                title: 'Reporte de cursos ' + fecha.getDate() + '-' + (1 + fecha.getMonth()) + '-' + fecha.getFullYear(),
                exportOptions: {
                    columns: [0, 1, 2, 3]
                }
            },
            {
                extend: 'print',
                text: '<i class="fa fa-print" title="Imprimir"></i>',
                messageTop: 'Sistema de Matrícula',
                title: 'Reporte de cursos ' + fecha.getDate() + '-' + (1 + fecha.getMonth()) + '-' + fecha.getFullYear(),
                exportOptions: {
                    columns: [0, 1, 2, 3]
                }
            }
        ],
        colReorder: true,
        columnDefs: [
            {
                targets: "_all",
                className: "dt-center"
            }]
    });
}

function loadTitle() {
    document.title = "CRUD CURSOS";
}

let crud_curso_btn_primary;
function loadButton() {
    crud_curso_btn_primary = document.getElementById("button");
    crud_curso_btn_primary.type = 'submit';
    crud_curso_btn_primary.value = parameters_button.SALIR;
    crud_curso_btn_primary.onclick = salir;
    message_btn_primary.innerHTML = parameters_button.GUARDAR;
    message_btn_primary.hidden = 'true';
    message_btn_secondary.innerHTML = parameters_button.CERRAR;
}

function salir(evt) {
    window.location.href = LINKS.PRINCIPAL;
}

function insertar() {
    sessionStorage.setItem('curso_type', 1);
    $('#curso_modal').modal('toggle');
    confirmation_load_message('Confirmacíon de la Acción', '¿Esta seguro(a) que desea insertar este curso?');
    message_btn_primary.onclick = confirmation_show;
    confirmation_btn_secondary.onclick = insert;
}

function actualizar(curso) {
    sessionStorage.setItem('curso_type', 2);
    $('#curso_modal').modal('toggle');
    confirmation_load_message('Confirmacíon de la Acción', '¿Esta seguro(a) que desea guardar los cambios en este curso?');
    curso_btn_secondary.onclick = crud_curso_confirmation_show;
    curso_load(curso.id);
    confirmation_btn_secondary.onclick = function () {
        update(curso.id);
    };
}

function eliminar(curso) {
    confirmation_load_message('Confirmacíon de la Acción', "¿Esta seguro(a) que desea eliminar " +
            "este curso?<br><br><div class='form-control'>" + curso.nombre + '</div>');
    confirmation_show();
    confirmation_btn_secondary.onclick = function () {
        remove(curso.id);
    };
}

function getCurso() {
    return 'id=' + sessionStorage.getItem('curso_id') +
            '&codigo=' + document.getElementById('curso_codigo').value +
            '&nombre=' + document.getElementById('curso_nombre').value +
            '&creditos=' + document.getElementById('curso_creditos').value +
            '&hora_semana=' + document.getElementById('curso_horas').value +
            '&anno=' + document.getElementById('curso_anno').value +
            '&ciclo=' + document.getElementById('curso_ciclo').value +
            '&carrera=' + document.getElementById('curso_carrera').value;
}

const resolve = (f) => {
    return new Promise(resolve => setTimeout(() => resolve(f), 500));
};

const asyncAll = async () => {
    const f = await resolve($('#message_modal').modal('hide'));
};

function insert() {
    $('#confirmation_modal').modal('hide');
    $('#loader').modal('toggle');
    ajax({
        type: "GET",
        url: "curso?opcion=insert&" + getCurso()
    }).then((data) => {
        $('#loader').modal('hide');
        asyncAll().then(() => {
            message('Notificación', 'Se ha guardado el curso con éxito', parameters_button.CERRAR);
        });
        crud_curso_load_cursos(data);
    },
            (status) => {
        $('#loader').modal('hide');
        error_message('Error', status);
    });
}

function update() {
    $('#confirmation_modal').modal('hide');
    $('#loader').modal('toggle');
    ajax({
        type: "GET",
        url: "curso?opcion=update&" + getCurso()
    }).then((data) => {
        $('#loader').modal('hide');
        asyncAll().then(() => {
            message('Notificación', 'Se ha guardado la modificación con éxito', parameters_button.CERRAR);
        });
        sessionStorage.setItem('curso_id', undefined);
        crud_curso_load_cursos(data);
    },
            (status) => {
        $('#loader').modal('hide');
        error_message('Error', status);
    });
}

function remove(id) {
    $('#confirmation_modal').modal('hide');
    $('#loader').modal('toggle');
    ajax({
        type: "GET",
        url: "curso?opcion=delete&id=" + id
    }).then((data) => {
        asyncAll().then(() => {
            message_show('Notificación', 'Se ha eliminado el curso con éxito', parameters_button.CERRAR);
        });
        crud_curso_load_cursos(data);
    },
            (status) => {
        $('#loader').modal('hide');
        error_message('Error', status);
    });
}

function list() {
    $('#loader').modal('toggle');
    ajax({
        type: "GET",
        url: "curso?opcion=list"
    }).then((data) => {
        $('#loader').modal('hide');
        crud_curso_load_cursos(data);
    },
            (status) => {
        $('#loader').modal('hide');
        message('Error', status, parameters_button.CERRAR);
    });
}

function crud_curso_load_cursos(data) {
    var fecha = new Date();
    var table = $('#table_data').DataTable().destroy();
    table = $('#table_data').DataTable({
        language: {
            "paginate": {
                "first": "Primera",
                "last": "Última",
                "next": "Siguiente",
                "previous": "Anterior"
            },
            "search": "Buscar:",
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Ningún dato disponible en esta tabla",
            "info": "Página _PAGE_ de _PAGES_",
            "infoEmpty": "No se encontraron datos",
            "infoFiltered": "(Filtrado de un total de _MAX_ registros)",
            "EmptyTable": "Ningún dato disponible en esta tabla"
        },
        data: data,
        dom: '<"float-left"B> <"float-right"f>t<"row"<"col-sm-5"l><"col-sm-3"i><"col-sm-4"p>>',
        buttons: [
            {
                extend: 'pdf',
                text: '<i class="fa fa-file-pdf-o" title="Exportar a PDF"></i>',
                messageTop: 'Sistema de Matrícula',
                title: 'Reporte de cursos ' + fecha.getDate() + '-' + (1 + fecha.getMonth()) + '-' + fecha.getFullYear(),
                exportOptions: {
                    columns: [0, 1, 2, 3]
                }
            },
            {
                extend: 'excel',
                text: '<i class="fa fa-file-excel-o" title="Exportar a Excel"></i>',
                messageTop: 'Sistema de Matrícula',
                title: 'Reporte de cursos ' + fecha.getDate() + '-' + (1 + fecha.getMonth()) + '-' + fecha.getFullYear(),
                exportOptions: {
                    columns: [0, 1, 2, 3]
                }
            },
            {
                extend: 'print',
                text: '<i class="fa fa-print" title="Imprimir"></i>',
                messageTop: 'Sistema de Matrícula',
                title: 'Reporte de cursos ' + fecha.getDate() + '-' + (1 + fecha.getMonth()) + '-' + fecha.getFullYear(),
                exportOptions: {
                    columns: [0, 1, 2, 3]
                }
            }
        ],
        colReorder: true,
        columnDefs: [
            {
                targets: "_all",
                className: "dt-center"
            }],
        columns: [
            {"data": 'codigo'},
            {"data": 'nombre'},
            {"data": 'creditos'},
            {"data": 'hora_semana'},
            {"data": 'anno'},
            {"data": 'ciclo.id'},
            {"data": 'carrera.id'},
            {"defaultContent":
                        '\
                    <button data-toggle="modal" data-target="#curso_modal" class="btn update" title="Editar">\n\
                        <i class="fa fa-edit"></i>\n\
                    </button>\n\
                    <button class="btn delete" title="Eliminar">\n\
                        <i class="fa fa-trash"></i>\n\
                    </button>'
            }
        ]
    });
    table_acciones(table);
    //Funciones filtro
    nombre_filter(table);
}

function table_acciones(table) {
    $('#table_data tbody').on('click', 'button', function () {
        var action = this.className;
        var data = table.row($(this).parents('tr')).data();
        if (action === 'btn update')
            actualizar(data);
        if (action === 'btn delete')
            eliminar(data);
    });
}

function nombre_filter(table) {
    $('#articuloFilter').on('keyup change', function () {
        table.column(1).search(this.value).draw();
    });
}

function crud_curso_confirmation_show() {
    $('#curso_modal').modal('hide');
    confirmation_show();
}

document.addEventListener("DOMContentLoaded", crud_curso_init);
