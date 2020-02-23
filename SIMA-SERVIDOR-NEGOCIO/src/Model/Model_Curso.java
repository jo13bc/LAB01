package Model;

import Logic.Carrera;
import Logic.Ciclo;
import Logic.Curso;
import static Logic.Utils.verifyString;
import static Logic.Utils.verifyInt;
import static Logic.Utils.verify_count_of_parameters;

public class Model_Curso {

    public Curso verify_without_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 7);
        //
        Curso objeto = new Curso();
        //
        objeto.setCodigo(verifyString(parameters[0], "una cédula"));
        objeto.setNombre(verifyString(parameters[1], "un nombre"));
        objeto.setCreditos(verifyInt(parameters[2], "una cantidad de creditos", "la cantidad de creditos"));
        objeto.setHora_semana(verifyInt(parameters[3], "una cantidad de horas a la semana", "la cantidad de horas a la semana"));
        objeto.setAnno(verifyInt(parameters[4], "un año", "el año"));
        objeto.setCiclo(new Ciclo(verifyInt(parameters[5], "un ciclo", "el ciclo")));
        objeto.setCarrera(new Carrera(verifyInt(parameters[6], "una carrera", "la carrera")));
        return objeto;
    }
    
    public Curso verify_with_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 8);
        //
        Curso objeto = new Curso();
        //
        objeto.setId(verifyInt(parameters[0], "un id", "el id"));
        objeto.setCodigo(verifyString(parameters[1], "una cédula"));
        objeto.setNombre(verifyString(parameters[2], "un nombre"));
        objeto.setCreditos(verifyInt(parameters[3], "una cantidad de creditos", "la cantidad de creditos"));
        objeto.setHora_semana(verifyInt(parameters[4], "una cantidad de horas a la semana", "la cantidad de horas a la semana"));
        objeto.setAnno(verifyInt(parameters[5], "un año", "el año"));
        objeto.setCiclo(new Ciclo(verifyInt(parameters[6], "un ciclo", "el ciclo")));
        objeto.setCarrera(new Carrera(verifyInt(parameters[7], "una carrera", "la carrera")));
        return objeto;
    }
    
    public Curso verify_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        return new Curso(verifyInt(parameters[0], "un id", "el id"));
    }
}
