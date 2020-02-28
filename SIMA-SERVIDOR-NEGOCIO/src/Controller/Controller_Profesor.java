package Controller;

import DAO.DAO_Profesor;
import Logic.Profesor;
import Model.Model_Profesor;
import java.util.List;

public class Controller_Profesor extends Controller<Profesor>{

    private final Model_Profesor model = new Model_Profesor();
    DAO_Profesor dao = DAO_Profesor.getDAO();

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
    public Profesor function(String opcion, String[] parameters) throws Exception {
        Profesor object = null;
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
}
