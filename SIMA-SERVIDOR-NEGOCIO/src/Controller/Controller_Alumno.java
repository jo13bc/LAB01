package Controller;

import DAO.DAO_Alumno;
import Logic.Alumno;
import Model.Model_Alumno;
import java.util.List;

public class Controller_Alumno extends Controller<Alumno> {

    private final Model_Alumno model = new Model_Alumno();
    DAO_Alumno dao = DAO_Alumno.getDAO();

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
    public Alumno function(String opcion, String[] parameters) throws Exception {
        Alumno object = null;
        switch (opcion) {
            case "query": {
                object = dao.query(
                        model.verify_id(parameters)
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
}
