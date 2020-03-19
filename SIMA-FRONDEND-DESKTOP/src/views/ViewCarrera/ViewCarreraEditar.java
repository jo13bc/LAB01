package views.ViewCarrera;

import DomRestfull.API.Object.Carreras;
import Logic.Carrera;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.ModeloCarrera;

public class ViewCarreraEditar extends javax.swing.JFrame implements Observer {

    private ModeloCarrera model;
    private Carrera actual;

    public ViewCarreraEditar(ModeloCarrera model, Carrera actual) {
        this.model = model;
        this.actual = actual;
        initComponents();

    }

    public void addListeners(Carreras controller) {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        tituloText = new javax.swing.JTextField();
        codigoText = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        query = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Titulo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre");

        tituloText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloTextActionPerformed(evt);
            }
        });

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/save.png"))); // NOI18N
        update.setText("Guardar");
        update.setActionCommand("update");

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/deleteSolicitud.png"))); // NOI18N
        delete.setText("Eliminar");
        delete.setActionCommand("delete");

        query.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/solicitud.png"))); // NOI18N
        query.setText("Cursos");
        query.setActionCommand("query");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Carrera numero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(126, 126, 126))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tituloText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(codigoText, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(nombreText, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(idText)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(query)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(query))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tituloTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloTextActionPerformed
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
    private javax.swing.JTextField codigoText;
    private javax.swing.JButton delete;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
