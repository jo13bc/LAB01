package DomRestfull.API.Object;

//import Logic.Carrera;
//import Logic.Carrera;
import Logic.Carrera;
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
import modelo.ModeloCarrera;
import views.ViewCarrera.ViewCarreraAgregar;
import views.ViewCarrera.ViewCarreraBuscar;
import views.ViewCarrera.ViewCarreraEditar;
import views.ViewCarrera.ViewCarreraMenu;

public class Carreras implements ActionListener, MouseListener {

    private ModeloCarrera model = new ModeloCarrera();
    private ViewCarreraMenu viewCarreraMenu;
    private ViewCarreraBuscar viewCarreraBuscar;
    private ViewCarreraAgregar viewCarreraAgregar;
    private ViewCarreraEditar viewCarreraEditar;
    private Tabla tabla;
    private ArrayList<Carrera> detalles;

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

    public String verificaOpcion(String opcion) {
        String nueva = opcion;
        if (!(viewCarreraBuscar.getCodigo().getText().isEmpty())) {
            nueva = "queryCodigo";
        }
        if (!(viewCarreraBuscar.getNombre().getText().isEmpty())) {
            nueva = "queryNombre";
        }
        return nueva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        ArrayList<String> args = new ArrayList();
        String proccess = "function";
        ArrayList<Carrera> carreras;
        String result;

        int caso = verificaAccion(opcion);
        if("queryCodigo".equals(opcion)){
            opcion = verificaOpcion(opcion);
        }
        
        if (caso == 0) {
            switch (opcion) {
                case "queryCodigo": {
                    args.add(viewCarreraBuscar.getCodigo().getText());
                    proccess = "functionMult";
                }
                break;
                case "queryNombre": {
                    String fff = viewCarreraBuscar.getNombre().getText();
                    args.add(viewCarreraBuscar.getNombre().getText());
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
            }
            if (opcion.equals("queryCodigo") || opcion.equals("queryNombre")) {
                try {
                    carreras = (ArrayList<Carrera>) Client.getClient().ejecutarConexion(new Message("carrera", proccess, opcion, args), 5050).getResponse();
                    model.updateTable(carreras);

                } catch (Exception ex) {
                    Logger.getLogger(Carreras.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    result = Client.getClient().ejecutarConexion(new Message("carrera", proccess, opcion, args), 5050).getResponse().toString();
                    result = ((ArrayList<Carrera>) Client.getClient()
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
                    Logger.getLogger(Carreras.class.getName()).log(Level.SEVERE, null, ex);
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
