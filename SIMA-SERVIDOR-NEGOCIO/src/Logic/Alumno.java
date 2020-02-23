
package Logic;

import static Logic.Utils.toDate;
import Parameters.Type_Persona;

public class Alumno extends Persona{
    private java.sql.Date fecha_nacimiento;
    private Carrera carrera;
    
    public Alumno(int id, String cedula, String nombre, String ape_1, String ape_2, String tel, String correo, java.util.Date fecha_nacimiento, Carrera carrera) {
        super(Type_Persona.ALUMNO, id, cedula, nombre, ape_1, ape_2, tel, correo);
        this.fecha_nacimiento = toDate(fecha_nacimiento);
        this.carrera = carrera;
    }

    public Alumno() {
        this(-1, null, null, null, null, null, null, null, null);
    }

    public Alumno(int id) {
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

    public  java.sql.Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(java.util.Date fecha_nacimiento) {
        this.fecha_nacimiento = toDate(fecha_nacimiento);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno:\n\tId: " + id + "\n\tCédula: " + cedula + "\n\tNombre: " + nombre + " " + ape_1 + " " + ape_2 + "\n\tTeléfono: " + tel + "\n\tCorreo Electrónico: " + correo + "\n\tFecha de Nacimiento : " + fecha_nacimiento + "\n\tCarrera: " + carrera;
    }
}
