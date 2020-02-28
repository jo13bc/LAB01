package Client;

import java.io.Serializable;
import java.util.ArrayList;
public class Message implements Serializable{
     
    private static final long serialVersionUID = 11111;

    private String instance;
    private String type_process;
    private String opcion;
    private ArrayList<String> args;

    public Message(String instance, String type_process, String opcion) {
        this.instance = instance;
        this.type_process = type_process;
        this.opcion = opcion;
        this.args = new ArrayList();
    }

    public Message() {
        this(null, null, null);
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getType_process() {
        return type_process;
    }

    public void setType_process(String type_process) {
        this.type_process = type_process;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<String> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "Message{" + "instance=" + instance + ", type_process=" + type_process + ", opcion=" + opcion + ", args=" + args + '}';
    }
}
