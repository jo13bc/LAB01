package Controller;

import DAO.DAO_Alumno;
import Logic.Alumno;
import Model.Model_Alumno;
import java.util.ArrayList;
import java.util.List;

public class Controller_Alumno extends Controller<Alumno> {

    private final Model_Alumno model = new Model_Alumno();
    DAO_Alumno dao = DAO_Alumno.getDAO();

    @Override
    public void procedure(String opcion, Alumno object) throws Exception {
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
    public Alumno function(String opcion, Alumno p_object) throws Exception {
        Alumno object = null;
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
    public List<Alumno> function(String opcion) throws Exception {
        List<Alumno> list = null;
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
    public ArrayList<Alumno> functionMultiple(String opcion, Alumno p_object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
