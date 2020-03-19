package DomRestfull.API.Object;

//import Logic.Curso;
//import Logic.Curso;
import Logic.Carrera;
import Logic.Curso;
import Server.Client;
import Server.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloCarrera;
import modelo.ModeloCurso;
import view.ViewCurso.ViewCursoAgregar;
import view.ViewCurso.ViewCursoBuscar;
import view.ViewCurso.ViewCursoEditar;
import view.ViewCurso.ViewCursoMenu;
import view.ViewCurso.ViewListaCursos;

public class Cursos implements ActionListener, MouseListener {

    private ModeloCurso model = new ModeloCurso();
    private ModeloCarrera modelCarrera = new ModeloCarrera();
    private ViewCursoMenu viewCursoMenu;
    private ViewCursoBuscar viewCursoBuscar;
    private ViewCursoAgregar viewCursoAgregar;
    private ViewCursoEditar viewCursoEditar;
    private ViewListaCursos viewListaCursos;
    private ArrayList<Carrera> carreras;
    ArrayList<String> args = new ArrayList<String>();

    public Cursos(String view) throws Exception {
        switch (view) {
            case "Menu":
                this.viewCursoMenu = new ViewCursoMenu();
                model.addObserver(viewCursoMenu);
                viewCursoMenu.addListeners(this);
                viewCursoMenu.setVisible(true);
                break;

            case "Agregar":
                carreras = (ArrayList<Carrera>) Client.getClient().ejecutarConexion(new Message("carrera", "functionMult", "queryCarrera", args), 5050).getResponse();
                modelCarrera.updateTable(carreras);
                this.viewCursoAgregar = new ViewCursoAgregar(modelCarrera);
                model.addObserver(viewCursoAgregar);
                viewCursoAgregar.addListeners(this);
                viewCursoAgregar.setVisible(true);
                break;
            case "Buscar":
                this.viewCursoBuscar = new ViewCursoBuscar(model);
                model.addObserver(viewCursoBuscar);
                viewCursoBuscar.addListeners(this);
                viewCursoBuscar.setVisible(true);
                break;
        }
    }

    public Cursos(String view, Curso actual) throws Exception {
        switch (view) {
            case "Edicion":
                carreras = (ArrayList<Carrera>) Client.getClient().ejecutarConexion(new Message("carrera", "functionMult", "queryCarrera", args), 5050).getResponse();
                modelCarrera.updateTable(carreras);
                this.viewCursoEditar = new ViewCursoEditar(model, modelCarrera, actual);
                this.viewCursoEditar.init();
                model.addObserver(viewCursoEditar);
                viewCursoEditar.addListeners(this);
                viewCursoEditar.setVisible(true);
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
        if ("Código".equals(viewCursoBuscar.ComboBox())) {
            return "queryCodigo";
        } else {
            if ("Nombre".equals(viewCursoBuscar.ComboBox())) {
                return "queryNombre";
            } else {
                return "queryCursoCarrera";
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        ArrayList<String> args = new ArrayList();
        String proccess = "function";
        ArrayList<Curso> cursos;
        String result;

        int caso = verificaAccion(opcion);
        if ("query".equals(opcion)) {
            opcion = verificaOpcion();
        }

        if (caso == 0) {
            switch (opcion) {
                case "queryCodigo": {
                    args.add(viewCursoBuscar.getBusquedaText().getText());
                    proccess = "functionMult";
                }
                break;
                case "queryNombre": {
                    args.add(viewCursoBuscar.getBusquedaText().getText());
                    proccess = "functionMult";
                }
                break;
                case "queryCursoCarrera": {
                    args.add(viewCursoBuscar.getBusquedaText().getText());
                    proccess = "functionMult";
                }
                break;
                case "insert": {
                    args.add(viewCursoAgregar.getCodigo().getText());
                    args.add(viewCursoAgregar.getNombre().getText());
                    args.add(viewCursoAgregar.getCreditos().getText());
                    args.add(viewCursoAgregar.getHorasText().getText());
                    args.add(viewCursoAgregar.getAñoText().getText());
                    args.add(viewCursoAgregar.ComboBox());
                    args.add(String.valueOf(viewCursoAgregar.getCarrera().getId()));
                    proccess = "procedure";
                }
                break;
                case "update": {
                    viewCursoEditar.actualizar();
                    args.add(String.valueOf(viewCursoEditar.getCurso().getId()));
                    args.add(viewCursoEditar.getCurso().getCodigo());
                    args.add(viewCursoEditar.getCurso().getNombre());
                    args.add(String.valueOf(viewCursoEditar.getCurso().getCreditos()));
                    args.add(String.valueOf(viewCursoEditar.getCurso().getHora_semana()));
                    args.add(String.valueOf(viewCursoEditar.getCurso().getAnno()));
                    args.add(String.valueOf(viewCursoEditar.getCurso().getCiclo().getId()));
                    args.add(String.valueOf(viewCursoEditar.getCurso().getCarrera().getId()));
                    proccess = "procedure";
                }
                break;
                case "delete": {
                    args.add(String.valueOf(viewCursoEditar.getCurso().getId()));
                    proccess = "procedure";
                }
                break;
            }
            if (opcion.equals("queryCodigo") || opcion.equals("queryNombre") || opcion.equals("queryCursoCarrera")) {
                try {
                    cursos = (ArrayList<Curso>) Client.getClient().ejecutarConexion(new Message("curso", proccess, opcion, args), 5050).getResponse();
                    model.updateTable(cursos);

                } catch (Exception ex) {
                    avisosFallo(opcion);
                }
            } else {
                try {
                    cursos = (ArrayList<Curso>) Client.getClient().ejecutarConexion(new Message("curso", proccess, opcion, args), 5050).getResponse();
                    actualizar(opcion, cursos);
                } catch (Exception ex) {
                    avisosFallo(opcion);
                }
            }
        } else {
            switch (opcion) {
                case "Agregar": {
                    try {
                        new Cursos("Agregar");
                    } catch (Exception ex) {
                        Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "Buscar": {
                    try {
                        new Cursos("Buscar");
                    } catch (Exception ex) {
                        Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
    }

    public void avisosFallo(String opcion) {
        switch (opcion) {
            case "insert": {
                viewCursoAgregar.aviso("Datos incorrectos");
            }
            break;
            case "delete": {
                viewCursoEditar.aviso("No se puede eliminar");
            }
            break;
            case "update": {
                viewCursoEditar.aviso("Datos incorrectos");
            }
            break;
            default: {
                viewCursoBuscar.aviso("Datos no encontrados");
                viewCursoBuscar.limpiar();
            }
            break;
        }
    }

    public void actualizar(String opcion, ArrayList<Curso> cursos) {
        switch (opcion) {
            case "insert": {
                viewCursoAgregar.aviso("Datos guardados");
                Curso c = new Curso();
                ArrayList<Curso> n = new ArrayList<Curso>();
                n.add(cursos.get(cursos.size() - 1));
                viewCursoAgregar.setVisible(false);
                model.updateTable(n);
                this.viewListaCursos = new ViewListaCursos(model);
                model.addObserver(viewListaCursos);
                viewListaCursos.setVisible(true);
            }
            break;
            case "delete": {
                viewCursoEditar.aviso("Datos eliminados");
                viewCursoEditar.setVisible(false);
            }
            break;
            case "update": {
                Curso c = new Curso();
                ArrayList<Curso> n = new ArrayList<Curso>();
                for (int i = 0; i < cursos.size(); i++) {
                    if (cursos.get(i).getId() == viewCursoEditar.getCurso().getId()) {
                        c = cursos.get(i);
                    }
                }
                n.add(c);
                viewCursoEditar.aviso("Datos editados");
                viewCursoEditar.setVisible(false);
                model.updateTable(n);
                this.viewListaCursos = new ViewListaCursos(model);
                model.addObserver(viewListaCursos);
                viewListaCursos.setVisible(true);
            }
            break;
        }

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
