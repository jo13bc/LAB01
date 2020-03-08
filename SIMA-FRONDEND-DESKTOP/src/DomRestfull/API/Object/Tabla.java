
package DomRestfull.API.Object;
        
import Logic.Carrera;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class Tabla extends AbstractTableModel {

    private ArrayList<Carrera> detalles;

    public Tabla(ArrayList<Carrera> detalles) {
        this.detalles = detalles;
    }

    public void setDetalles(ArrayList<Carrera> detalles) {
        this.detalles = detalles;
    }

    @Override
    public int getRowCount() {
        return detalles.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Carrera c = detalles.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = c.getId();
                break;
            case 1:
                value = c.getCodigo();
                break;
            case 2:
                value = c.getNombre();
                break;
            case 3:
                value = c.getTitulo();
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        String name = "???";
        switch (column) {
            case 0:
                name = "ID Carrera";
                break;
            case 1:
                name = "Codigo";
                break;
            case 2:
                name = "Nombre";
                break;
            case 3:
                name = "Titulo";
                break;
        }
        return name;
    }

    public Carrera getRowAt(int row) {
        return detalles.get(row);
    }
}
