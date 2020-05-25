package Model;

import Logic.Alumno;
import Logic.Carrera;
import static Logic.Utils.verifyDate;
import static Logic.Utils.verifyString;
import static Logic.Utils.verifyInt;
import static Logic.Utils.verify_count_of_parameters;

public class Model_Alumno {

    public Alumno verify_without_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 8);
        //
        Alumno object = new Alumno();
        //
        object.setCedula(verifyString(parameters[0], "una cedula"));
        object.setNombre(verifyString(parameters[1], "una nombre"));
        object.setApe_1(verifyString(parameters[2], "un primer apellido"));
        object.setApe_2(verifyString(parameters[3], "un segundo apellido"));
        object.setTel(verifyString(parameters[4], "un telefono"));
        object.setCorreo(verifyString(parameters[5], "un correo"));
        object.setFecha_nacimiento(verifyDate(parameters[6], "una fecha de nacimiento","la fecha de nacimiento"));
        object.setCarrera(
                new Carrera(verifyInt(parameters[7], "un id", "el id"))
        );
        return object;
    }
    
    public Alumno verify_with_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 9);
        //
        Alumno object = new Alumno();
        //
        object.setId(verifyInt(parameters[0], "un id", "el id"));
        object.setCedula(verifyString(parameters[1], "una cedula"));
        object.setNombre(verifyString(parameters[2], "una nombre"));
        object.setApe_1(verifyString(parameters[3], "un primer apellido"));
        object.setApe_2(verifyString(parameters[4], "un segundo apellido"));
        object.setTel(verifyString(parameters[5], "un telefono"));
        object.setCorreo(verifyString(parameters[6], "un correo"));
        object.setFecha_nacimiento(verifyDate(parameters[7], "una fecha de nacimiento","la fecha de nacimiento"));
        object.setCarrera(
                new Carrera(verifyInt(parameters[8], "un id", "el id"))
        );
        return object;
    }
    
    public Alumno verify_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        return new Alumno(verifyInt(parameters[0], "un id", "el id"));
    }
}
