/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parameters;

/**
 *
 * @author Jostin
 */
public enum CRUD_Alumno {
    INSERT("{call  insert_alumno(?,?,?,?,?,?,?,?)}"),
    UPDATE("{call  update_alumno(?,?,?,?,?,?,?,?,?)}"),
    DELETE("{call  delete_alumno(?)}"),
    LIST("{?=call  list_alumno()}"),
    QUERY("{?=call  query_alumno(?)}");

    private final String value;

    /**
     * Método para asignar el valor de cada uno de los parámetros
     * @param envUrl 
     */
    CRUD_Alumno(String envUrl) {
        this.value = envUrl;
    }
    
    /**
     * Método para retornar el valor de cada uno de los parámetros
     * @return String 
     */
    public String getValue() {
        return value;
    }
}
