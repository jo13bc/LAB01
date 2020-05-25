package Controller;

import DAO.DAO_Usuario;
import Logic.Usuario;
import Model.Model_Usuario;
import java.util.ArrayList;
import java.util.List;

public class Controller_Usuario extends Controller<Usuario>{

    private final Model_Usuario model = new Model_Usuario();
    DAO_Usuario dao = DAO_Usuario.getDAO();

    @Override
    public void procedure(String opcion, Usuario object) throws Exception {
        switch (opcion) {
            case "insert": {
                dao.insert(object);
            }
            break;
            case "update": {
                dao.update(object);
            }
            break;
            case "delete": {
                dao.delete(object);
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
    }

    @Override
    public Usuario function(String opcion, Usuario p_object) throws Exception {
        Usuario object = null;
        switch (opcion) {
            case "query": {
                object = dao.query(p_object);
            }
            break;
            case "login": {
                object = dao.login(p_object);
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return object;
    }

    @Override
    public List<Usuario> function(String opcion) throws Exception {
        List<Usuario> list = null;
        switch (opcion) {
            case "list": {
                list = dao.list();
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return list;
    }

    @Override
    public ArrayList<Usuario> functionMultiple(String opcion, Usuario object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
