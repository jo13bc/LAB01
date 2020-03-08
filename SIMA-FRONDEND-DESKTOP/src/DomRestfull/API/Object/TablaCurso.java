package DomRestfull.API.Object;

import Logic.Curso;
import Logic.Curso;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TablaCurso extends AbstractTableModel {

    private ArrayList<Curso> detalles;

    public TablaCurso(ArrayList<Curso> detalles) {
        this.detalles = detalles;
    }

    public void setDetalles(ArrayList<Curso> detalles) {
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
        Curso c = detalles.get(rowIndex);
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
                value = c.getCreditos();
                break;
            case 4:
                value = c.getHora_semana();
                break;
            case 5:
                value = c.getAnno();
                break;
            case 6:
                value = c.getCiclo().getNume();
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        String name = "???";
        switch (column) {
            case 0:
                name = "ID Curso";
                break;
            case 1:
                name = "Codigo";
                break;
            case 2:
                name = "Nombre";
                break;
            case 3:
                name = "Creditos";
                break;
            case 4:
                name = "Horas Semanales";
                break;
            case 5:
                name = "Año";
                break;
            case 6:
                name = "Ciclo";
                break;

        }
        return name;
    }

    public Curso getRowAt(int row) {
        return detalles.get(row);
    }
}
