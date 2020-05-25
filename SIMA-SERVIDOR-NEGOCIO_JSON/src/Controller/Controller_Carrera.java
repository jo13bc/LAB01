package Controller;

import DAO.DAO_Carrera;
import Logic.Carrera;
import Model.Model_Carrera;
import java.util.ArrayList;
import java.util.List;

public class Controller_Carrera extends Controller<Carrera> {

    private final Model_Carrera model = new Model_Carrera();
    DAO_Carrera dao = DAO_Carrera.getDAO();

    @Override
    public void procedure(String opcion, Carrera object) throws Exception {
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
    public Carrera function(String opcion, Carrera p_object) throws Exception {
        Carrera object = null;
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
    public List<Carrera> function(String opcion) throws Exception {
        List<Carrera> list = null;
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
    public ArrayList<Carrera> functionMultiple(String opcion, Carrera p_object) throws Exception {
        ArrayList<Carrera> object = null;
        switch (opcion) {
            case "queryCodigo": {
                object = dao.queryCodigo(p_object);
            }
            break;
            case "queryNombre": {
                System.out.print("FFFFFFFFFFF");
                object = dao.queryNombre(p_object);
            }
            break;
            case "queryCarrera": {
                object = dao.queryCarrera();
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return object;
    }

}
