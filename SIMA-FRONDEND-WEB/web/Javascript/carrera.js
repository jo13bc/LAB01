/* global parameters_classes, parameters_button, ajax */
let carrera_type = sessionStorage.getItem('carrera_type');

const carrera_parameters = {
    TITLE: (carrera_type === 1) ? 'Ingreso de Carrera' : 'Mantenimiento de Carrera',
    SECONDARY_BUTTON: (carrera_type === 1) ? parameters_button.INGRESAR : parameters_button.GUARDAR
};

function carrera_init() {
    carrera_classes_init();
    carrera_label_init();
    carrera_button_init();
    carrera_body_init();
}

function carrera_classes_init() {
    document.getElementById('carrera_header').className = parameters_classes.CLASS_HEADER;
    document.getElementById('carrera_content').className = parameters_classes.CLASS_CONTENT;
    document.getElementById('carrera_footer').className = parameters_classes.CLASS_FOOTER;
}

let carrera_title;
function carrera_label_init() {
    carrera_title = document.getElementById('carrera_title');
    carrera_title.className = parameters_classes.CLASS_TITLE;
    carrera_title.innerHTML = carrera_parameters.TITLE;
}

let carrera_btn_primary;
let carrera_btn_secondary;
function carrera_button_init() {
    carrera_btn_primary = document.getElementById("carrera_btn_primary");
    carrera_btn_secondary = document.getElementById("carrera_btn_secondary");
    carrera_btn_primary.className = parameters_classes.CLASS_BUTTON_PRIMARY;
    carrera_btn_secondary.className = parameters_classes.CLASS_BUTTON_SECONDARY;
    carrera_btn_primary.innerHTML = parameters_button.CERRAR;
    carrera_btn_secondary.innerHTML = carrera_parameters.SECONDARY_BUTTON;
}

let carrera_body;
function carrera_body_init() {
    carrera_body = document.getElementById("carrera_body");
    carrera_body.className = parameters_classes.CLASS_BODY;
}

function carrera_load(id) {
    $('#confirmation_modal').modal('hide');
    $('#loader').modal('toggle');
    ajax({
        type: "GET",
        url: "carrera?opcion=query&id=" + id
    }).then((carrera) => {
        $('#loader').modal('hide');
        document.getElementById("carrera_codigo").value = carrera.codigo;
        document.getElementById("carrera_nombre").value = carrera.nombre;
        document.getElementById("carrera_titulo").value = carrera.titulo;
    },
            (status) => {
        $('#loader').modal('hide');
        error_message('Error', status);
    });
}

function carrera_reset() {
    document.getElementById("carrera_codigo").value = '';
    document.getElementById("carrera_nombre").value = '';
    document.getElementById("carrera_titulo").value = '';
}

document.addEventListener("DOMContentLoaded", carrera_init);