package Controller;

import DAO.DAO_Curso;
import Logic.Curso;
import Model.Model_Curso;
import java.util.List;

public class Controller_Curso extends Controller<Curso> {

    private final Model_Curso model = new Model_Curso();
    DAO_Curso dao = DAO_Curso.getDAO();

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
    public Curso function(String opcion, String[] parameters) throws Exception {
        Curso object = null;
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
    public List<Curso> function(String opcion) throws Exception {
        List<Curso> list = null;
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
