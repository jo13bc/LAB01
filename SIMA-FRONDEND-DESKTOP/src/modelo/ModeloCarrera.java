
package modelo;

import DomRestfull.API.Object.Tabla;
import Logic.Carrera;
import java.util.ArrayList;
import java.util.Observable;


public class ModeloCarrera extends Observable {
    
 private Tabla tabla;
    private ArrayList<Carrera> detalles;

    public ModeloCarrera() {
        this.detalles = new ArrayList<Carrera>();
        this.tabla = new Tabla(detalles);
    }

    public void updateTable(ArrayList<Carrera> aux) {
        this.detalles = aux;
        this.tabla = new Tabla(aux);
        this.setChanged();
        this.notifyObservers(null);
    }

    public void update(Carrera detalle, int pos) {
        detalles.set(pos, detalle);
        this.setChanged();
        this.notifyObservers(null);
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public ArrayList<Carrera> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<Carrera> detalles) {
        this.detalles = detalles;
    }
    
    public void limpiarTabla(){
        this.tabla = null;
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
