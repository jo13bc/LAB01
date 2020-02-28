
package Controller;

import Logic.Instancia;
import java.util.List;

public abstract class Controller<T extends Instancia> {
    
    public abstract void procedure(String opcion, String[] parameters) throws Exception;
    
    public abstract T function(String opcion, String[] parameters) throws Exception;
    
    public abstract List<T> function(String opcion) throws Exception;
}
