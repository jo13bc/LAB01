package Logic;

import Parameters.Type_Persona;
import java.io.Serializable;

public abstract class Persona implements Serializable {

    public Type_Persona type;
    protected int id;
    protected String cedula;
    protected String nombre;
    protected String ape_1;
    protected String ape_2;
    protected String tel;
    protected String correo;

    public Persona(Type_Persona type, int id, String cedula, String nombre, String ape_1, String ape_2, String tel, String correo) {
        this.type = type;
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.ape_1 = ape_1;
        this.ape_2 = ape_2;
        this.tel = tel;
        this.correo = correo;
    }

    public Persona(Type_Persona type) {
        this(type, -1, null, null, null, null, null, null);
    }

    public Persona(Type_Persona type, int id) {
        this(type);
        this.id = id;
    }

    public abstract int getId();
    
    public abstract void setId(int id);
    
    public abstract String getCedula();
    
    public abstract void setCedula(String cedula);
    
    public abstract String getNombre();
    
    public abstract void setNombre(String nombre);
    
    public abstract String getApe_1();
    
    public abstract void setApe_1(String ape_1);
    
    public abstract String getApe_2();
    
    public abstract void setApe_2(String ape_2);
    
    public abstract String getTel();
    
    public abstract void setTel(String tel);
    
    public abstract String getCorreo();
    
    public abstract void setCorreo(String correo);

    @Override
    public abstract String toString();
}
