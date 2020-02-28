
package Client;

import java.io.Serializable;

public class Packet implements Serializable{
     
    private static final long serialVersionUID = 11112;
    private Object object;

    public Packet(Object object) {
        this.object = object;
    }

    public Packet() {
        this(new Object());
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Packet{" + "object=" + object + '}';
    }
}
