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
    public void procedure(String opcion, String[] parameters) throws Exception {
        switch (opcion) {
            case "insert": {
                dao.insert(
                        model.verify_without_id(parameters)
                );
            }
            break;
            case "update": {
                dao.update(
                        model.verify_with_id(parameters)
                );
            }
            break;
            case "delete": {
                dao.delete(
                        model.verify_id(parameters)
                );
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
    }

    @Override
    public Usuario function(String opcion, String[] parameters) throws Exception {
        Usuario object = null;
        switch (opcion) {
            case "query": {
                object = dao.query(
                        model.verify_id(parameters)
                );
            }
            break;
            case "login": {
                object = dao.login(
                        model.verify_login(parameters)
                );
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
    public ArrayList<Usuario> functionMultiple(String opcion, String[] parameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
