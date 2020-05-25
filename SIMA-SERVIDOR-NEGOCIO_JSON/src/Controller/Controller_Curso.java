package Controller;

import DAO.DAO_Curso;
import Logic.Curso;
import Model.Model_Curso;
import java.util.ArrayList;
import java.util.List;

public class Controller_Curso extends Controller<Curso> {

    private final Model_Curso model = new Model_Curso();
    DAO_Curso dao = DAO_Curso.getDAO();

    @Override
    public void procedure(String opcion, Curso object) throws Exception {
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
    public Curso function(String opcion, Curso p_object) throws Exception {
        Curso object = null;
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

    @Override
    public ArrayList<Curso> functionMultiple(String opcion, Curso p_object) throws Exception {
        ArrayList<Curso> object = null;
        switch (opcion) {
            case "queryCodigo": {
                object = dao.queryCodigo(p_object);
            }
            break;
            case "queryNombre": {
                object = dao.queryNombre(p_object);
            }
            break;
            case "queryCarrera": {
                object = dao.queryCarrera();
            }
            break;
            case "queryCursoCarrera": {
                object = dao.queryCarreraCurso(p_object);
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return object;
    }
}
