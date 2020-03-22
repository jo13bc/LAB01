package DomRestfull.API.Object;

import Logic.Usuario;
import Server.Client;
import Server.Message;
import Server.Packet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
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
                args.add(viewLogin.getContraseña());
                proccess = "function";
            }
            break;
        }
        try {
            user = (Usuario) ((Packet) Client.getClient().ejecutarConexion(new Message("usuario", proccess, opcion, args), 5050)).getResponse();
            viewLogin.setVisible(false);
             new Menu();
        } catch (Exception ex) {
           avisos("Incorrecto");
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
    
    
    public void avisos(String opcion) {
        switch(opcion){
            case "Correcto":{
                
            }
            case "Incorrecto":{
               viewLogin.aviso("Usuario o Contraseña incorrecta");  
            }
        }
                      
    }
    
}
