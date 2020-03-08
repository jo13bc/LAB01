
package modelo;

import DomRestfull.API.Object.Tabla;
import DomRestfull.API.Object.TablaCurso;
import Logic.Curso;
import java.util.ArrayList;
import java.util.Observable;


public class ModeloCurso extends Observable {
    
 private TablaCurso tabla;
    private ArrayList<Curso> detalles;

    public ModeloCurso() {
        this.detalles = new ArrayList<Curso>();
        this.tabla = new TablaCurso(detalles);
    }

    public void updateTable(ArrayList<Curso> aux) {
        this.detalles = aux;
        this.tabla = new TablaCurso(aux);
        this.setChanged();
        this.notifyObservers(null);
    }

    public void update(Curso detalle, int pos) {
        detalles.set(pos, detalle);
        this.setChanged();
        this.notifyObservers(null);
    }

    public TablaCurso getTabla() {
        return tabla;
    }

    public void setTabla(TablaCurso tabla) {
        this.tabla = tabla;
    }

    public ArrayList<Curso> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<Curso> detalles) {
        this.detalles = detalles;
    }

//    public Curso buscar_carrera(int id) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        Curso aux = null;
//        try {
//            aux = SM.buscar_carrera(id);
//        } catch (GlobalException ex) {
//            Logger.getLogger(ModeloCurso.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoDataException ex) {
//            Logger.getLogger(ModeloCurso.class.getName()).log(Level.SEVERE, null, ex);
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
//    public void insert(Curso carrera) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        try {
//            SM.insertar_carrera(carrera);
//        } catch (GlobalException | NoDataException ex) {
//            Logger.getLogger(ModeloCurso.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public ArrayList<Curso> search(String codigo) throws GlobalException, NoDataException {
//        ServicesMethods SM = new ServicesMethods();
//        ArrayList<Curso> aux = null;
//        aux = SM.buscar_carrera(codigo);
//        return aux;
//    }
//
//    public void update(Curso carrera) throws SQLException {
//        ServicesMethods SM = new ServicesMethods();
//        SM.update(carrera);
//    }
//
//    public void delete(Curso carrera) throws SQLException {
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
