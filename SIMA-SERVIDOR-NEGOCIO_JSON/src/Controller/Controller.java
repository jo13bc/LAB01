
package Controller;

import Logic.Instancia;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller<T extends Instancia> {
    
    public abstract void procedure(String opcion, T object) throws Exception;
    
    public abstract T function(String opcion, T p_object) throws Exception;
    
    public abstract List<T> function(String opcion) throws Exception;
    
    public abstract ArrayList<T> functionMultiple(String opcion, T p_object) throws Exception;
}
