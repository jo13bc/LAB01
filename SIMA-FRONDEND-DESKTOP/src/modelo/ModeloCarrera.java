
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

//    public Carrera buscar_carrera(int id) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        Carrera aux = null;
//        try {
//            aux = SM.buscar_carrera(id);
//        } catch (GlobalException ex) {
//            Logger.getLogger(ModeloCarrera.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoDataException ex) {
//            Logger.getLogger(ModeloCarrera.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return aux;
//    }
//     public int getMaxDetalle() {
//        ServicesMethods SM = new ServicesMethods();
//        int aux = 0;
//        try {
//            aux = SM.obtenerContradorDetalle();
//
//        } catch (GlobalException ex) {
//            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoDataException ex) {
//            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        return aux;
//    }
//    public void insert(Carrera carrera) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        try {
//            SM.insertar_carrera(carrera);
//        } catch (GlobalException | NoDataException ex) {
//            Logger.getLogger(ModeloCarrera.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public ArrayList<Carrera> search(String codigo) throws GlobalException, NoDataException {
//        ServicesMethods SM = new ServicesMethods();
//        ArrayList<Carrera> aux = null;
//        aux = SM.buscar_carrera(codigo);
//        return aux;
//    }
//
//    public void update(Carrera carrera) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        SM.update(carrera);
//    }
//
//    public void delete(Carrera carrera) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        SM.delete(carrera);
//    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers(null);
    }
}
