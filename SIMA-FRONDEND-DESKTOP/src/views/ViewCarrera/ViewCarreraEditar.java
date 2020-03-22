package views.ViewCarrera;

import DomRestfull.API.Object.Carreras;
import Logic.Carrera;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.ModeloCarrera;
import static utils.Utils.ajustarPantalla;

public class ViewCarreraEditar extends javax.swing.JFrame implements Observer {

    private ModeloCarrera model;
    private Carrera actual;

    public ViewCarreraEditar(ModeloCarrera model, Carrera actual) {
        this.model = model;
        this.actual = actual;
        initComponents();

    }

    public void addListeners(Carreras controller) {
        ajustarPantalla(this);
        update.addActionListener(controller);
        delete.addActionListener(controller);
        query.addActionListener(controller);
    }

    public Carrera getCarrera() {
        return actual;
    }

    public void aviso(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jpBody = new javax.swing.JPanel();
        datas = new javax.swing.JPanel();
        cod1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        cod = new javax.swing.JLabel();
        codigoText = new javax.swing.JTextField();
        N = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        tituloText = new javax.swing.JTextField();
        query = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpHeader.setBackground(new java.awt.Color(0, 153, 255));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cursos");

        javax.swing.GroupLayout jpHeaderLayout = new javax.swing.GroupLayout(jpHeader);
        jpHeader.setLayout(jpHeaderLayout);
        jpHeaderLayout.setHorizontalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpHeaderLayout.setVerticalGroup(
            jpHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpBody.setBackground(new java.awt.Color(255, 255, 255));

        datas.setBackground(new java.awt.Color(255, 255, 255));
        datas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingreso de Datos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        cod1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cod1.setText("Código Curso");

        idText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cod.setText("Codigo");

        codigoText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        N.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        N.setText("Nombre");

        nombreText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Titulo.setText("Título");

        tituloText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        query.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        query.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/solicitud.png"))); // NOI18N
        query.setText("Cursos");
        query.setActionCommand("query");

        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/save.png"))); // NOI18N
        update.setText("Guardar");
        update.setActionCommand("update");

        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/deleteSolicitud.png"))); // NOI18N
        delete.setText("Eliminar");
        delete.setActionCommand("delete");

        javax.swing.GroupLayout datasLayout = new javax.swing.GroupLayout(datas);
        datas.setLayout(datasLayout);
        datasLayout.setHorizontalGroup(
            datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cod1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(cod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(N, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(codigoText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(tituloText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(query, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datasLayout.createSequentialGroup()
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update)))
                .addContainerGap())
        );
        datasLayout.setVerticalGroup(
            datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasLayout.createSequentialGroup()
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datasLayout.createSequentialGroup()
                        .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod1)
                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod)
                            .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(query))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo)
                    .addComponent(tituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update)
                    .addComponent(delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpBodyLayout = new javax.swing.GroupLayout(jpBody);
        jpBody.setLayout(jpBodyLayout);
        jpBodyLayout.setHorizontalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpBodyLayout.setVerticalGroup(
            jpBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void init() {
        idText.setText(String.valueOf(actual.getId()));
        idText.setEditable(false);
        codigoText.setText(actual.getCodigo());
        nombreText.setText(actual.getNombre());
        tituloText.setText(actual.getTitulo());
        setVisible(true);

    }

    public void actualizar() {
        if (!"".equals(codigoText.getText())) {
            actual.setCodigo(codigoText.getText());
        }
        if (!"".equals(nombreText.getText())) {
            actual.setNombre(nombreText.getText());
        }
        if (!"".equals(tituloText.getText())) {
            actual.setTitulo(tituloText.getText());
        }

    }

    public void mostrarMensajes(String mensaje) {
//        label.setText(mensaje);
        validate();
    }

    boolean validar() {
        boolean error = false;

//            this.idText.setForeground(COLOR_OK);
//            if (this.idText.getText().isEmpty()) {
//                this.idText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//
//            this.codigoText.setForeground(COLOR_OK);
//            if (this.codigoText.getText().isEmpty()) {
//                this.codigoText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.medidaText.setForeground(COLOR_OK);
//            if (this.medidaText.getText().isEmpty()) {
//                this.medidaText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.unidadText.setForeground(COLOR_OK);
//            if (this.unidadText.getText().isEmpty()) {
//                this.unidadText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.unidadVentaText.setForeground(COLOR_OK);
//            if (this.unidadVentaText.getText().isEmpty()) {
//                this.unidadVentaText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.tituloText.setForeground(COLOR_OK);
//            if (this.tituloText.getText().isEmpty()) {
//                this.tituloText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.nombreText.setForeground(COLOR_OK);
//            if (this.nombreText.getText().isEmpty()) {
//                this.nombreText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.precioUnitarioText.setForeground(COLOR_OK);
//            if (this.precioUnitarioText.getText().isEmpty()) {
//                this.precioUnitarioText.setForeground(COLOR_ERROR);
//                error = true;
//            }
//            this.precioVentaText.setForeground(COLOR_OK);
//            if (this.precioVentaText.getText().isEmpty()) {
//                this.precioVentaText.setForeground(COLOR_ERROR);
//                error = true;
//            }
        return !error;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel N;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel cod;
    private javax.swing.JLabel cod1;
    private javax.swing.JTextField codigoText;
    private javax.swing.JPanel datas;
    private javax.swing.JButton delete;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JTextField nombreText;
    private javax.swing.JButton query;
    private javax.swing.JTextField tituloText;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
//        updateTable();
    }
}
