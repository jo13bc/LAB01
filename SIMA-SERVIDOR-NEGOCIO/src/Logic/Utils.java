package Logic;

import DAO.DAO_Alumno;
import DAO.DAO_Profesor;
import java.util.Date;
import Parameters.Menssage_Error;
import Parameters.Type_Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;
import java.util.function.Function;

public class Utils {

    public static java.sql.Date toDate(java.util.Date fecha) {
        return (fecha == null) ? null : new java.sql.Date(fecha.getTime());
    }

    private static void verifyEmpty(String parameter_value, String parameter_name) throws Exception {
        if (parameter_value.isEmpty()) {
            throw new Exception(Menssage_Error.MUST_HAVE_INPUT.getValue() + parameter_name);
        }
    }

    public static String verifyString(String parameter_value, String parameter_name) throws Exception {
        verifyEmpty(parameter_value, parameter_name);
        return parameter_value;
    }

    public static int verifyInt(String parameter_value, String parameter_name, String parameter_type) throws Exception {
        //
        verifyEmpty(parameter_value, parameter_name);
        //
        int parameter;
        //
        try {
            parameter = Integer.valueOf(parameter_value);
        } catch (NumberFormatException ex) {
            throw new Exception(Menssage_Error.ERROR_TO_PARSER.getValue() + parameter_type);
        }
        return parameter;
    }

    public static Date verifyDate(String parameter_value, String parameter_name, String parameter_type) throws Exception {
        //
        verifyEmpty(parameter_value, parameter_name);
        //
        Date parameter;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            parameter = formatter.parse(parameter_value);
        } catch (ParseException ex) {
            throw new Exception(Menssage_Error.ERROR_TO_PARSER.getValue() + parameter_type);
        }
        return parameter;
    }

    public static <T> T verifyAll(String parameter_value, String parameter_name, String parameter_type, Function<String, T> funcion, Consumer<Exception> consumidor) {
        T parameter = null;
        try {
            if (parameter_value.isEmpty()) {
                throw new Exception(Menssage_Error.MUST_HAVE_INPUT.getValue() + parameter_name);
            }
            parameter = funcion.apply(parameter_value);
        } catch (Exception ex) {
            consumidor.accept(new Exception(Menssage_Error.ERROR_TO_PARSER.getValue() + parameter_type));
        }
        return parameter;
    }

    public static Persona createPersona(String condicion, int id) throws Exception {
        Persona persona;
        switch (getValue(condicion)) {
            case PROFESOR: {
                persona = new Profesor(id);
            }
            break;
            case ALUMNO: {
                persona = new Alumno(id);
            }
            break;
            default: {
                persona = null;
            }
        }
        return persona;
    }

    public static Persona loadPersona(Persona p_persona) throws Exception {
        Persona persona;
        switch (p_persona.type) {
            case PROFESOR: {
                persona = DAO_Profesor.getDAO().query((Profesor)p_persona);
            }
            break;
            case ALUMNO: {
                persona = DAO_Alumno.getDAO().query((Alumno)p_persona);
            }
            break;
            default: {
                persona = null;
            }
        }
        return persona;
    }

    public static Type_Persona getValue(String condicion) throws Exception {
        Type_Persona type;
        switch (condicion) {
            case "P": {
                type = Type_Persona.PROFESOR;
            }
            break;
            case "A": {
                type = Type_Persona.ALUMNO;
            }
            break;
            default: {
                type = null;
            }
        }
        return type;
    }
    public static float getNum(ResultSet resultSet, int name) {
        float nume = 0;
        try {
            nume = resultSet.getFloat(name);
        } catch (SQLException ex) {

        }
        return nume;
    }

    public static Date getDate(ResultSet resultSet, int name) {
        Date fecha = new Date();
        try {
            fecha = resultSet.getDate(name);
        } catch (SQLException ex) {

        }
        return fecha;
    }
    
    public static void verify_count_of_parameters(String[] parameters, int count) throws Exception{
        if(parameters.length != count){
            throw new Exception("La cantidad de parámetros no corresponde a lo esperado.");
        }
    }
}
