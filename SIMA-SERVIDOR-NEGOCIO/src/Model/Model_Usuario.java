package Model;

import Logic.Usuario;
import static Logic.Utils.verifyString;
import static Logic.Utils.verifyInt;
import static Logic.Utils.verify_count_of_parameters;
import static Logic.Utils.createPersona;

public class Model_Usuario {

    public Usuario verify_without_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 6);
        //
        Usuario object = new Usuario();
        //
        object.setUsuario(verifyString(parameters[0], "un identificador de usuario"));
        object.setContrasenna(verifyString(parameters[1], "una contraseña de seguridad"));
        object.setPersona(createPersona(
                        verifyString(parameters[2], "un tipo de persona asocidada a la cuenta"),
                        verifyInt(parameters[3], "una persona asocidada a la cuenta", "la persona asociada a la cuenta")
                )
        );
        return object;
    }

    public Usuario verify_with_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 7);
        //
        Usuario object = new Usuario();
        //
        object.setId(verifyInt(parameters[0], "un id", "el id"));
        object.setUsuario(verifyString(parameters[1], "un identificador de usuario"));
        object.setContrasenna(verifyString(parameters[2], "una contraseña de seguridad"));
        object.setPersona(createPersona(
                        verifyString(parameters[3], "un tipo de persona asocidada a la cuenta"),
                        verifyInt(parameters[4], "una persona asocidada a la cuenta", "la persona asociada a la cuenta")
                )
        );
        return object;
    }

    public Usuario verify_id(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 1);
        return new Usuario(verifyInt(parameters[0], "un id", "el id"));
    }

    public Usuario verify_login(String[] parameters) throws Exception {
        verify_count_of_parameters(parameters, 2);
        //
        return new Usuario(
                verifyString(parameters[0], "un identificador de usuario"),
                verifyString(parameters[1], "una contraseña de seguridad")
        );
    }
}
