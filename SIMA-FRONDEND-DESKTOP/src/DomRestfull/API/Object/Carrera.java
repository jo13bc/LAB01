package DomRestfull.API.Object;

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
import views.ViewCarrera.ViewCarreraAgregar;
import views.ViewCarrera.ViewCarreraBuscar;
import views.ViewCarrera.ViewCarreraMenu;

public class Carrera implements ActionListener, MouseListener {

    private ViewCarreraMenu viewCarreraMenu;
    private ViewCarreraBuscar viewCarreraBuscar;
    private ViewCarreraAgregar viewCarreraAgregar;

    public Carrera(String view) {
        switch (view) {
            case "Menu":
                this.viewCarreraMenu = new ViewCarreraMenu();
                viewCarreraMenu.addListeners(this);
                viewCarreraMenu.setVisible(true);
                break;

            case "Agregar":
                this.viewCarreraAgregar = new ViewCarreraAgregar();
                viewCarreraAgregar.addListeners(this);
                viewCarreraAgregar.setVisible(true);
                break;
            case "buscar":
                this.viewCarreraBuscar = new ViewCarreraBuscar();
                viewCarreraBuscar.addListeners(this);
                viewCarreraBuscar.setVisible(true);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        ArrayList<String> args = new ArrayList();
        String proccess = "function";
        switch (opcion) {
            case "Entrar": {
//                args.add(viewCarrera.getUsuario().getText());
//                args.add(viewCarrera.getContraseña().getText());
                proccess = "function";
            }
            break;
            case "Agregar": {
                new Carrera("Agregar");
            }
            break;
            case "Buscar": {
                new Carrera("Buscar");
            }
            break;

        }
//        response.setContentType("text/plain");
//        Packet name = (Usuario)Client.getClient().ejecutarConexion(new Message("usuario", proccess, opcion, args), 5050);
//        try {
//            Packet name = Client.getClient().ejecutarConexion(new Message("usuario", proccess, opcion, args), 5050);
//        } catch (Exception ex) {
//            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
