
package Logic;

public class Ciclo {
    private int id;

    public Ciclo(int id) {
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
        return "Ciclo{" + "id=" + id + '}';
    }
}
