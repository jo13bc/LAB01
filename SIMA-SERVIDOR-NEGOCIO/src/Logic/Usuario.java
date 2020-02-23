package Logic;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String usuario;
    private String contrasenna;
    private Persona persona;

    public Usuario(int id, String usuario, String contrasenna, Persona funcionario) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.persona = funcionario;
    }
    
    public Usuario() {
        this(-1, null, null,null);
    }
    
    public Usuario(int id) {
        this();
        this.id = id;
    }
    
    public Usuario(String usuario, String contrasenna) {
        this();
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", contrasenna=" + contrasenna + ", persona=" + persona + '}';
    }
}
