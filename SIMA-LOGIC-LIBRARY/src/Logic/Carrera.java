
package Logic;

import org.json.JSONObject;

public class Carrera extends Instancia{
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

    @Override
    public JSONObject getJSON() throws Exception{
        JSONObject json = new JSONObject();
        json.put("id", id);
        return json;
    }
}
