
package Logic;

public class Curso {
    private int id;
    private String codigo;
    private String nombre;
    private int creditos;
    private int hora_semana;
    private int anno;
    private Ciclo ciclo;
    private Carrera carrera;

    public Curso(int id, String codigo, String nombre, int creditos, int hora_semana, int anno, Ciclo ciclo, Carrera carrera) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.hora_semana = hora_semana;
        this.anno = anno;
        this.ciclo = ciclo;
        this.carrera = carrera;
    }
    
    public Curso(){
        this(-1, null, null, -1, -1, -1, null, null);
    }
    
    public Curso(int id){
        this();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHora_semana() {
        return hora_semana;
    }

    public void setHora_semana(int hora_semana) {
        this.hora_semana = hora_semana;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Curso:\n\tId: " + id + "\n\tCódigo: " + codigo + "\n\tNombre: " + nombre + "\n\tCreditos: " + creditos + "\n\tHoras Semanales: " + hora_semana + "\n\tAño: " + anno + "\n\tCiclo: " + ciclo + "\n\tCarrera: " + carrera;
    }
}
