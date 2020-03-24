package views.ViewCarrera;

import DomRestfull.API.Object.Carreras;
import DomRestfull.API.Object.Tabla;
import DomRestfull.API.Object.TablaCurso;
import Logic.Carrera;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.ModeloCarrera;
import modelo.ModeloCurso;
import static utils.Utils.ajustarPantalla;

public class ViewCarreraEditar extends javax.swing.JFrame implements Observer {

    private ModeloCarrera model;
    private ModeloCurso modelCurso;
    private Carrera actual;
    private TablaCurso tablaCurso;
    private Tabla tabla;

    public ViewCarreraEditar(ModeloCarrera model, ModeloCurso modelCurso, Carrera actual) {
        this.model = model;
        this.modelCurso = modelCurso;
        this.actual = actual;
        initComponents();

    }

    public void addListeners(Carreras controller) {
        ajustarPantalla(this);
        update.addActionListener(controller);
        delete.addActionListener(controller);
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
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpHeader.setBackground(new java.awt.Color(0, 153, 255));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Carreras");

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
        cod1.setText("Código Carrera");

        idText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cod.setText("Código");

        codigoText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        N.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        N.setText("Nombre");

        nombreText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Titulo.setText("Título");

        tituloText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/save.png"))); // NOI18N
        update.setText("Editar");
        update.setActionCommand("update");

        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/Imagenes/deleteSolicitud.png"))); // NOI18N
        delete.setText("Eliminar");
        delete.setActionCommand("delete");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Cursos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        datasLayout.setVerticalGroup(
            datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datasLayout.createSequentialGroup()
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod1)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Lista de Cursos de la Carrera");

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
                .addComponent(datas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Carreras", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            if (evt.getClickCount() == 1) {
                int row = this.jTable1.getSelectedRow();
                Carrera seleccionado = model.getTabla().getRowAt(row);
                new Carreras("Edicion", seleccionado);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "El Laberinto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTable1MouseClicked
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

    private void updateTable() {
        this.tablaCurso = modelCurso.getTabla();
        this.jTable2.setModel(tablaCurso);
        this.tabla = model.getTabla();
        this.jTable1.setModel(tabla);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpBody;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTextField tituloText;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        updateTable();
    }
}
