package Controller;

import DAO.DAO_Profesor;
import Logic.Profesor;
import Model.Model_Profesor;
import java.util.ArrayList;
import java.util.List;

public class Controller_Profesor extends Controller<Profesor>{

    private final Model_Profesor model = new Model_Profesor();
    DAO_Profesor dao = DAO_Profesor.getDAO();

    @Override
    public void procedure(String opcion, Profesor p_profesor) throws Exception {
        switch (opcion) {
            case "insert": {
                dao.insert(p_profesor);
            }
            break;
            case "update": {
                dao.update(p_profesor);
            }
            break;
            case "delete": {
                dao.delete(p_profesor);
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
    }

    @Override
    public Profesor function(String opcion, Profesor p_object) throws Exception {
        Profesor object = null;
        switch (opcion) {
            case "query": {
                object = dao.query(p_object);
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return object;
    }

    @Override
    public List<Profesor> function(String opcion) throws Exception {
        List<Profesor> list = null;
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
    public ArrayList<Profesor> functionMultiple(String opcion, Profesor profesor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
