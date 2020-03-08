package view.ViewCurso;

import DomRestfull.API.Object.Cursos;
import Logic.Curso;

import java.util.Observable;
import java.util.Observer;
import modelo.ModeloCurso;


public class ViewCursoEditar extends javax.swing.JFrame implements Observer {

    private ModeloCurso model;
    private Curso actual;

    public ViewCursoEditar(ModeloCurso model, Curso actual) {
        this.model = model;
        this.actual = actual;
        initComponents();
    }

    public void addListeners(Cursos controller) {
        guardar.addActionListener(controller);
        delete.addActionListener(controller);
    }

    public Curso getCurso() {
        return actual;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        tituloText = new javax.swing.JTextField();
        codigoText = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel1.setText("Identificación");

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel2.setText("Titulo");

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel4.setText("Nombre");

        guardar.setText("Guardar");

        delete.setText("Eliminar");
        delete.setActionCommand("delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(idText)
                    .addComponent(codigoText)
                    .addComponent(tituloText))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(delete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void init() {
        idText.setText(Integer.toString(actual.getId()));
        codigoText.setText(actual.getCodigo());
        nombreText.setText(actual.getNombre());
//        tituloText.setText(actual.getTitulo());
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
//            actual.setTitulo(tituloText.getText());
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
    private javax.swing.JButton guardar;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTextField tituloText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
//        updateTable();
    }
}
