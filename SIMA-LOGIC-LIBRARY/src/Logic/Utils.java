package Logic;

import Parameters.Menssage_Error;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
}
