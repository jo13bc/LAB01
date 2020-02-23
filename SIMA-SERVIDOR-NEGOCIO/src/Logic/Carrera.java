
package Logic;

public class Carrera {
    private int id;

    public Carrera(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id=" + id + '}';
    }
}
