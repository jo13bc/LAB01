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
    public Carrera function(String opcion, String[] parameters) throws Exception {
        Carrera object = null;
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
    public ArrayList<Carrera> functionMultiple(String opcion, String[] parameters) throws Exception {
        ArrayList<Carrera> object = null;
        switch (opcion) {
            case "queryCodigo": {
                object = dao.queryCodigo(
                        model.verify_codigo(parameters)
                );
            }
            break;
            case "queryNombre": {
                System.out.print("FFFFFFFFFFF");
                object = dao.queryNombre(
                        model.verify_nombre(parameters)
                );
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
