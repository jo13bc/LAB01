
package Logic;

import Parameters.Type_Persona;
import org.json.JSONObject;

public class Profesor extends Persona{
    
    public Profesor(int id, String cedula, String nombre, String ape_1, String ape_2, String tel, String correo) {
        super(Type_Persona.PROFESOR, id, cedula, nombre, ape_1, ape_2, tel, correo);
    }

    public Profesor() {
        this(-1, null, null, null, null, null, null);
    }

    public Profesor(int id) {
        this();
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApe_1() {
        return ape_1;
    }

    @Override
    public void setApe_1(String ape_1) {
        this.ape_1 = ape_1;
    }

    @Override
    public String getApe_2() {
        return ape_2;
    }

    @Override
    public void setApe_2(String ape_2) {
        this.ape_2 = ape_2;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Profesor:\n\tId: " + id + "\n\tCédula: " + cedula + "\n\tNombre: " + nombre + " " + ape_1 + " " + ape_2 + "\n\tTeléfono: " + tel + "\n\tCorreo Electrónico: " + correo;
    }

    @Override
    public JSONObject getJSON() throws Exception{
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("cedula", cedula);
        json.put("nombre", nombre);
        json.put("ape1", ape_1);
        json.put("ape2", ape_2);
        json.put("tel", tel);
        return json;
    }
}
