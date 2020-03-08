package DomRestfull.API.Object;

import Logic.Usuario;
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
import views.ViewCarrera.ViewLogin;

public class Login implements ActionListener, MouseListener {

    private ViewLogin viewLogin;

    public Login() {
        this.viewLogin = new ViewLogin();
        viewLogin.addListeners(this);
        viewLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();
        ArrayList<String> args = new ArrayList();
        String proccess = "function";
        Usuario user = null;
        switch (opcion) {
            case "login": {
                args.add(viewLogin.getUsuario().getText());
                args.add(viewLogin.getContraseña().getText());
                proccess = "function";
            }
            break;
        }
        try {
            user = (Usuario) ((Packet) Client.getClient().ejecutarConexion(new Message("usuario", proccess, opcion, args), 5050)).getResponse();
            new Menu();
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
