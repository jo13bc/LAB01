package DomRestfull.API.Object;


import Logic.Carrera;
import Logic.Curso;
import Server.Client;
import Server.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import modelo.ModeloCarrera;
import modelo.ModeloCurso;
import views.ViewCarrera.ViewCarreraAgregar;
import views.ViewCarrera.ViewCarreraBuscar;
import views.ViewCarrera.ViewCarreraCurso;
import views.ViewCarrera.ViewCarreraEditar;
import views.ViewCarrera.ViewCarreraMenu;
import views.ViewCarrera.ViewListaCarreras;

public class Carreras implements ActionListener, MouseListener {

    private ModeloCarrera model = new ModeloCarrera();
    private ModeloCurso modelCurso = new ModeloCurso();
    private ViewCarreraMenu viewCarreraMenu;
    private ViewCarreraBuscar viewCarreraBuscar;
    private ViewCarreraAgregar viewCarreraAgregar;
    private ViewCarreraEditar viewCarreraEditar;
    private ViewCarreraCurso viewCarreraCurso;
    private ViewListaCarreras viewListaCarreras;
    private ArrayList<Curso> cursos;

    public Carreras(String view) {
        switch (view) {
            case "Menu":
                this.viewCarreraMenu = new ViewCarreraMenu();
                model.addObserver(viewCarreraMenu);
                viewCarreraMenu.addListeners(this);
                viewCarreraMenu.setVisible(true);
                break;

            case "Agregar":
                this.viewCarreraAgregar = new ViewCarreraAgregar();
                viewCarreraAgregar.addListeners(this);
                viewCarreraAgregar.setVisible(true);
                break;
            case "Buscar":
                this.viewCarreraBuscar = new ViewCarreraBuscar(model);
                model.addObserver(viewCarreraBuscar);
                viewCarreraBuscar.addListeners(this);
                viewCarreraBuscar.setVisible(true);
                break;
        }
    }

    public Carreras(String view, Carrera actual) {
        switch (view) {
            case "Edicion":
                this.viewCarreraEditar = new ViewCarreraEditar(model, actual);
                this.viewCarreraEditar.init();
                model.addObserver(viewCarreraEditar);
                viewCarreraEditar.addListeners(this);
                viewCarreraEditar.setVisible(true);
                break;
        }
    }

    public int verificaAccion(String opcion) {
        int var = 0;
        switch (opcion) {
            case "Agregar": {
                var = 1;
            }
            break;
            case "Buscar": {
                var = 1;
            }
            break;
            case "query": {
                var = 0;
            }
            break;
            case "insert": {
                var = 0;
            }
            break;
        }
        return var;
    }

    public String verificaOpcion() {
        if ("Código".equals(viewCarreraBuscar.ComboBox())) {
            return "queryCodigo";
        } else {
            return "queryNombre";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        ArrayList<String> args = new ArrayList();
        String proccess = "function";
        ArrayList<Carrera> carreras;
        String result;

        int caso = verificaAccion(opcion);
        if ("queryCodigo".equals(opcion)) {
            opcion = verificaOpcion();
        }

        if (caso == 0) {
            switch (opcion) {
                case "queryCodigo": {
                    args.add(viewCarreraBuscar.getBusquedaText().getText());
                    proccess = "functionMult";
                }
                break;
                case "queryNombre": {
                    args.add(viewCarreraBuscar.getBusquedaText().getText());
                    proccess = "functionMult";
                }
                break;
                case "insert": {
                    args.add(viewCarreraAgregar.getCodigo().getText());
                    args.add(viewCarreraAgregar.getNombre().getText());
                    args.add(viewCarreraAgregar.getTitulo().getText());
                    proccess = "procedure";
                }
                break;

                case "delete": {
                    args.add(String.valueOf(viewCarreraEditar.getCarrera().getId()));
                    proccess = "procedure";
                }
                break;
                case "update": {
                    viewCarreraEditar.actualizar();
                    args.add(String.valueOf(viewCarreraEditar.getCarrera().getId()));
                    args.add(viewCarreraEditar.getCarrera().getCodigo());
                    args.add(viewCarreraEditar.getCarrera().getNombre());
                    args.add(viewCarreraEditar.getCarrera().getTitulo());
                    proccess = "procedure";
                }
                break;
                case "query": {
                    viewCarreraEditar.actualizar();
                    args.add(String.valueOf(viewCarreraEditar.getCarrera().getId()));
                    proccess = "procedure";
                }
                break;
            }
            if (opcion.equals("query")) {
                try {
                    cursos = (ArrayList<Curso>) Client.getClient().ejecutarConexion(new Message("curso", "functionMult", "queryCarrera", args), 5050).getResponse();
                    ArrayList<Curso> cursos_carrera = verificaCarrera(cursos, viewCarreraEditar.getCarrera());
                    modelCurso.updateTable(cursos_carrera);
                    this.viewCarreraCurso = new ViewCarreraCurso(modelCurso);
                    model.addObserver(viewCarreraCurso);
                    viewCarreraCurso.setVisible(true);
                } catch (Exception ex) {
                    avisosFallo(opcion);
                }

            } else {
                if (opcion.equals("queryCodigo") || opcion.equals("queryNombre")) {
                    try {
                        carreras = (ArrayList<Carrera>) Client.getClient().ejecutarConexion(new Message("carrera", proccess, opcion, args), 5050).getResponse();
                        model.updateTable(carreras);

                    } catch (Exception ex) {
                        avisosFallo(opcion);
                    }
                } else {
                    try {
                        carreras = (ArrayList<Carrera>) Client.getClient().ejecutarConexion(new Message("carrera", proccess, opcion, args), 5050).getResponse();
                        actualizar(opcion, carreras);
                    } catch (Exception ex) {
                        avisosFallo(opcion);
                    }
                }
            }
        } else {
            switch (opcion) {
                case "Agregar": {
                    new Carreras("Agregar");
                }
                break;
                case "Buscar": {
                    new Carreras("Buscar");
                }
                break;
            }
        }
    }

    public void actualizar(String opcion, ArrayList<Carrera> carreras) {
        switch (opcion) {
            case "insert": {
                viewCarreraAgregar.aviso("Datos guardados");

                ArrayList<Carrera> n = new ArrayList<Carrera>();
                n.add(carreras.get(carreras.size() - 1));
                viewCarreraAgregar.setVisible(false);
                model.updateTable(n);
                VistaListaCarreras(model);
                        
            }
            break;
            case "delete": {
                viewCarreraEditar.aviso("Datos eliminados");
                viewCarreraEditar.setVisible(false);
            }
            break;
            case "update": {
                Carrera c = new Carrera();
                ArrayList<Carrera> n = new ArrayList<Carrera>();
                for (int i = 0; i < carreras.size(); i++) {
                    if (carreras.get(i).getId() == viewCarreraEditar.getCarrera().getId()) {
                        c = carreras.get(i);
                    }
                }
                n.add(c);
                viewCarreraEditar.aviso("Datos editados");
                viewCarreraEditar.setVisible(false);
                model.updateTable(n);
                VistaListaCarreras(model);
            }
            break;
        }

    }

    public void avisosFallo(String opcion) {
        switch (opcion) {
            case "insert": {
                viewCarreraAgregar.aviso("Datos incorrectos");
            }
            break;
            case "delete": {
                viewCarreraEditar.aviso("No se puede eliminar");
            }
            break;
            case "update": {
                viewCarreraEditar.aviso("Datos incorrectos");
            }
            break;
            case "query": {
                viewCarreraEditar.aviso("No tiene Cursos Asignados");
            }
            break;
            default: {
                viewCarreraBuscar.aviso("Datos no encontrados");
                viewCarreraBuscar.limpiar();
            }
            break;
        }
    }

    public ArrayList<Curso> verificaCarrera(ArrayList<Curso> cursos, Carrera actual) {
        ArrayList<Curso> cursos_carrera = new ArrayList<Curso>();

        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCarrera().getId() == actual.getId()) {
                cursos_carrera.add(cursos.get(i));
            }
        }

        return cursos_carrera;
    }

    public void VistaListaCarreras(ModeloCarrera model) {
        this.viewListaCarreras = new ViewListaCarreras(model);
        model.addObserver(viewListaCarreras);
        viewListaCarreras.setVisible(true);
    }

    @Override

    public void mouseClicked(MouseEvent arg0
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent arg0
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
