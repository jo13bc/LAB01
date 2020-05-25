package Model;

import Logic.Profesor;
import static Logic.Utils.verifyString;
import static Logic.Utils.verifyInt;
import static Logic.Utils.verify_count_of_parameters;

public class Model_Profesor {

    public Profesor verify_without_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 6);
        //
        Profesor object = new Profesor();
        //
        object.setCedula(verifyString(parameters[0], "una cedula"));
        object.setNombre(verifyString(parameters[1], "una nombre"));
        object.setApe_1(verifyString(parameters[2], "un apellido"));
        object.setApe_2(verifyString(parameters[3], "un apellido"));
        object.setTel(verifyString(parameters[4], "un telefono"));
        object.setCorreo(verifyString(parameters[5], "un correo"));
        return object;
    }
    
    public Profesor verify_with_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 7);
        //
        Profesor object = new Profesor();
        //
        object.setId(verifyInt(parameters[0], "un id", "el id"));
        object.setCedula(verifyString(parameters[1], "una cedula"));
        object.setNombre(verifyString(parameters[2], "una nombre"));
        object.setApe_1(verifyString(parameters[3], "un apellido"));
        object.setApe_2(verifyString(parameters[4], "un apellido"));
        object.setTel(verifyString(parameters[5], "un telefono"));
        object.setCorreo(verifyString(parameters[6], "un correo"));
        return object;
    }
    
    public Profesor verify_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        return new Profesor(verifyInt(parameters[0], "un id", "el id"));
    }
}
