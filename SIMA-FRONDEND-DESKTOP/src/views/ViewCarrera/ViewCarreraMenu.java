package views.ViewCarrera;

import DomRestfull.API.Object.Carrera;
import DomRestfull.API.Object.Login;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

public class ViewCarreraMenu extends javax.swing.JFrame implements Observer {

    public ViewCarreraMenu() {
        initComponents();
    }

    public void addListeners(Carrera controller) {
        buscarView.addActionListener(controller);
        agregarView.addActionListener(controller);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buscarView = new javax.swing.JButton();
        agregarView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel2.setText("Carreras");

        buscarView.setText("Buscar");
        buscarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarViewActionPerformed(evt);
            }
        });

        agregarView.setText("Agregar");
        agregarView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarView))
                .addGap(18, 18, 18)
                .addComponent(buscarView)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarView)
                    .addComponent(agregarView))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarViewActionPerformed

    private void agregarViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarViewActionPerformed
    public void init() {
        setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarView;
    private javax.swing.JButton buscarView;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
//        updateTable();
    }
}
