package Model;

import Logic.Carrera;
import Logic.Ciclo;
import Logic.Carrera;
import static Logic.Utils.verifyString;
import static Logic.Utils.verifyInt;
import static Logic.Utils.verify_count_of_parameters;

public class Model_Carrera {

    public Carrera verify_without_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 3);
        //
        Carrera objeto = new Carrera();
        //
        objeto.setCodigo(verifyString(parameters[0], "una código"));
        objeto.setNombre(verifyString(parameters[1], "un nombre"));
        objeto.setTitulo(verifyString(parameters[2], "titulo de la carrera"));
             return objeto;
    }
    
    public Carrera verify_with_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 4);
        //
        Carrera objeto = new Carrera();
        //
        objeto.setId(verifyInt(parameters[0], "un id", "el id"));
        objeto.setCodigo(verifyString(parameters[1], "una código"));
        objeto.setNombre(verifyString(parameters[2], "un nombre"));
        objeto.setTitulo(verifyString(parameters[3], "un titulo de carrera"));
        return objeto;
    }
    
    public Carrera verify_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        return new Carrera(verifyInt(parameters[0], "un id", "el id"));
    }
    public Carrera verify_codigo(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        return new Carrera(verifyString(parameters[0], "un codigo"));
    }

    public Carrera verify_nombre(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        Carrera nueva = new Carrera();
        nueva.setNombre(verifyString(parameters[0], "un codigo"));
        return nueva;
    }
}
