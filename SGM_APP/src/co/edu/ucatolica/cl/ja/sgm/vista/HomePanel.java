/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.vista;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class HomePanel extends javax.swing.JPanel {
    
    private final PrincipalFrame principalFrame;

    /**
     * Creates new form PrincipalPanel
     *
     * @param principalFrame
     */
    public HomePanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        initComponents();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelImagen = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelListas = new javax.swing.JLabel();
        jScrollPaneListas = new javax.swing.JScrollPane();
        jListListas = new javax.swing.JList<>();
        jButtonPlay = new javax.swing.JButton();
        jButtonMusica = new javax.swing.JButton();

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelUsuario.setText("USUARIO");

        jLabelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/imgprofile2.png"))); // NOI18N
        jLabelImagen.setPreferredSize(new java.awt.Dimension(150, 160));

        jLabelListas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelListas.setText("Listas de reproducción");

        jListListas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneListas.setViewportView(jListListas);

        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/play_opt.png"))); // NOI18N
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/musica_opt.png"))); // NOI18N
        jButtonMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMusicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabelListas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneListas)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jButtonMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelListas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneListas, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPlay)
                    .addComponent(jButtonMusica))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        reproducirLista();
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jButtonMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMusicaActionPerformed
        principalFrame.irAGestionMusicaLista();
    }//GEN-LAST:event_jButtonMusicaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMusica;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelListas;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JList<String> jListListas;
    private javax.swing.JScrollPane jScrollPaneListas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    private boolean validar() {
        if (jListListas.getModel().getSize() <= 0) {
            return false;
        } else if (jListListas.getSelectedIndex() == -1) {
            return false;
        } else {
            return true;
        }        
    }
    
    private void cargarDatos() {
        jLabelUsuario.setText(principalFrame.obtenerNickName());
        jLabelImagen.setIcon(principalFrame.mostrarFoto(false, jLabelImagen.getPreferredSize().getHeight(), jLabelImagen.getPreferredSize().getWidth()));
        cargarListas();
    }
    
    private void cargarListas() {
        DefaultListModel listModel = principalFrame.obtenerListasDelUsuario();
        jListListas.setModel(listModel);        
    }
    
    private void reproducirLista() {
        if (validar()) {
            principalFrame.irAReproductor(principalFrame.idListaDelUsuario(jListListas.getSelectedValue()));
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la lista que desea Reproducir", "Reproductor", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}