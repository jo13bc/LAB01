package DomRestfull.API.Object;

//import Logic.Curso;
//import Logic.Curso;
import Logic.Curso;
import Server.Client;
import Server.Message;
import Server.Packet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import modelo.ModeloCurso;
import view.ViewCurso.ViewCursoAgregar;
import view.ViewCurso.ViewCursoBuscar;
import view.ViewCurso.ViewCursoEditar;
import view.ViewCurso.ViewCursoMenu;

public class Cursos implements ActionListener, MouseListener {

    private ModeloCurso model = new ModeloCurso();
    private ViewCursoMenu viewCursoMenu;
    private ViewCursoBuscar viewCursoBuscar;
    private ViewCursoAgregar viewCursoAgregar;
    private ViewCursoEditar viewCursoEditar;
    private Tabla tabla;
    private ArrayList<Curso> detalles;

    public Cursos(String view) {
        switch (view) {
            case "Menu":
                this.viewCursoMenu = new ViewCursoMenu();
                model.addObserver(viewCursoMenu);
                viewCursoMenu.addListeners(this);
                viewCursoMenu.setVisible(true);
                break;

            case "Agregar":
                this.viewCursoAgregar = new ViewCursoAgregar();
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

    public Cursos(String view, Curso actual) {
        switch (view) {
            case "Edicion":
                this.viewCursoEditar = new ViewCursoEditar(model, actual);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        ArrayList<String> args = new ArrayList();
        String proccess = "function";
        ArrayList<Curso> carreras;
        String result;
//        Curso carrera;
        int caso = verificaAccion(opcion);
        if (caso == 0) {
            switch (opcion) {
                case "queryCodigo": {
                    args.add(viewCursoBuscar.getCodigo().getText());
                    proccess = "functionMult";
                }
                break;
                case "insert": {
                    args.add(viewCursoAgregar.getCodigo().getText());
                    args.add(viewCursoAgregar.getNombre().getText());
                    args.add(viewCursoAgregar.getTitulo().getText());
                    proccess = "procedure";
                }
                break;

                case "delete": {
                    args.add(String.valueOf(viewCursoEditar.getCurso().getId()));
                    proccess = "procedure";
                }
                break;
            }
            if (opcion.equals("queryCodigo")) {
                try {
                    carreras = (ArrayList<Curso>) Client.getClient().ejecutarConexion(new Message("carrera", proccess, opcion, args), 5050).getResponse();
                    model.updateTable(carreras);

                } catch (Exception ex) {
                    Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    result = Client.getClient().ejecutarConexion(new Message("carrera", proccess, opcion, args), 5050).getResponse().toString();
                    result = ((ArrayList<Curso>) Client.getClient()
                            .ejecutarConexion(new Message("carrera", proccess, opcion, args), 5000)
                            .getResponse()).stream()
                            .map((x) -> {
                                try {
                                    return x.getJSON().toString();
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex.getMessage());
                                }
                            })
                            .collect(Collectors.toList()).toString();
                } catch (Exception ex) {
                    Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            switch (opcion) {
                case "Agregar": {
                    new Cursos("Agregar");
                }
                break;
                case "Buscar": {
                    new Cursos("Buscar");
                }
                break;
            }
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
