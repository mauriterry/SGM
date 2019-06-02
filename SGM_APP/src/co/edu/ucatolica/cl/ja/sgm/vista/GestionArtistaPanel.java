/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sala3
 */
public class GestionArtistaPanel extends JPanel {

    private final PrincipalFrame principalFrame;

    /**
     * Creates new form PanelArtista
     *
     * @param principalFrame
     */
    public GestionArtistaPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        initComponents();
        //ToDo
        cargarArtistas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonGestionMusica = new javax.swing.JButton();
        jButtonGestionPista = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelEdad = new javax.swing.JLabel();
        jTextFieldEdad = new javax.swing.JTextField();
        jLabelSexo = new javax.swing.JLabel();
        jTextFieldSexo = new javax.swing.JTextField();
        jLabelNacionalidad = new javax.swing.JLabel();
        jTextFieldNacionalidad = new javax.swing.JTextField();
        jButtonCrearArtista = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTituloArtistas = new javax.swing.JLabel();
        jScrollPaneArtistas = new javax.swing.JScrollPane();
        jTextAreaArtistas = new javax.swing.JTextArea();
        jComboBoxArtista = new javax.swing.JComboBox<>();
        jButtonCargarArtista = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setText("Gestion de Artistas");

        jButtonGestionMusica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonGestionMusica.setText("Gestion Musica");
        jButtonGestionMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionMusicaActionPerformed(evt);
            }
        });

        jButtonGestionPista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonGestionPista.setText("Gestion Pista");
        jButtonGestionPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionPistaActionPerformed(evt);
            }
        });

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelID.setText("ID");

        jLabelEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdad.setText("Edad");

        jLabelSexo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSexo.setText("Sexo");

        jLabelNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNacionalidad.setText("Nacionalidad");

        jButtonCrearArtista.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCrearArtista.setText("Crear Artista");
        jButtonCrearArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearArtistaActionPerformed(evt);
            }
        });

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelTituloArtistas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTituloArtistas.setText("Artistas");

        jTextAreaArtistas.setEditable(false);
        jTextAreaArtistas.setColumns(20);
        jTextAreaArtistas.setRows(5);
        jScrollPaneArtistas.setViewportView(jTextAreaArtistas);

        jComboBoxArtista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxArtista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja un Artista" }));

        jButtonCargarArtista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCargarArtista.setText("Cargar");
        jButtonCargarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarArtistaActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNacionalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jTextFieldID)
                            .addComponent(jTextFieldEdad)
                            .addComponent(jTextFieldSexo)
                            .addComponent(jTextFieldNacionalidad)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButtonCrearArtista)
                        .addGap(26, 26, 26)
                        .addComponent(jButtonLimpiar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButtonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar)
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCargarArtista)))
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTituloArtistas)
                        .addGap(145, 145, 145))))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonGestionMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGestionPista, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGestionMusica)
                    .addComponent(jButtonGestionPista, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNombre)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelID)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelEdad)
                                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelSexo)
                                    .addComponent(jTextFieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelNacionalidad)
                                    .addComponent(jTextFieldNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonCrearArtista)
                                    .addComponent(jButtonLimpiar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTituloArtistas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCargarArtista))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonModificar)
                                    .addComponent(jButtonEliminar))))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addComponent(jSeparator1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonCrearArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearArtistaActionPerformed
        crearArtista();
    }//GEN-LAST:event_jButtonCrearArtistaActionPerformed

    private void jButtonGestionMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionMusicaActionPerformed
        principalFrame.irAGestionMusicaLista();
    }//GEN-LAST:event_jButtonGestionMusicaActionPerformed

    private void jButtonGestionPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionPistaActionPerformed
        principalFrame.irAGestionPista();
    }//GEN-LAST:event_jButtonGestionPistaActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificarArtista();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminarArtista();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCargarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarArtistaActionPerformed
        cargarDatosDelArtista();
    }//GEN-LAST:event_jButtonCargarArtistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargarArtista;
    private javax.swing.JButton jButtonCrearArtista;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGestionMusica;
    private javax.swing.JButton jButtonGestionPista;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBoxArtista;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNacionalidad;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloArtistas;
    private javax.swing.JScrollPane jScrollPaneArtistas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextAreaArtistas;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNacionalidad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldSexo;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        jTextFieldEdad.setText("");
        jTextFieldID.setText("");
        jTextFieldID.setEnabled(true);
        jTextFieldNacionalidad.setText("");
        jTextFieldNombre.setText("");
        jTextFieldSexo.setText("");
        jComboBoxArtista.setSelectedIndex(0);
        cargarArtistas();
    }

    private void cargarArtistas() {
        jTextFieldNombre.requestFocus();
        jTextAreaArtistas.setText("");
        jTextAreaArtistas.setText(principalFrame.obtenerArtistasToString());
        jComboBoxArtista.setModel(new DefaultComboBoxModel<>(new String[]{"Seleccione un Artista"}));
        String[] items = new String[principalFrame.cantidadDeArtistas() + 1];
        items[0] = "Seleccione un Artista";
        String[] artistas = principalFrame.obtenerArtistasToStringArray();
        for (int i = 1; i < items.length; i++) {
            items[i] = artistas[i - 1];
        }
        jComboBoxArtista.setModel(new DefaultComboBoxModel<>(items));
    }

    private boolean validar() {
        if (jTextFieldEdad.getText().equals("")) {
            return false;
        } else if (jTextFieldID.getText().equals("")) {
            return false;
        } else if (jTextFieldNacionalidad.getText().equals("")) {
            return false;
        } else if (jTextFieldNombre.getText().equals("")) {
            return false;
        } else if (jTextFieldSexo.getText().equals("")) {
            return false;
        } else {
            try {
                Integer.parseInt(jTextFieldEdad.getText());
                Integer.parseInt(jTextFieldID.getText());
                return true;
            } catch (NumberFormatException | NullPointerException e) {
                return false;
            }
        }
    }

    private boolean validarCargar() {
        return jComboBoxArtista.getSelectedIndex() > 0;
    }

    private void cargarDatosDelArtista() {
        if (validarCargar()) {
            String[] datos = principalFrame.datosDelArtista((String) jComboBoxArtista.getSelectedItem());
            jTextFieldNombre.setText(datos[0]);
            jTextFieldID.setText(datos[1]);
            jTextFieldID.setEnabled(false);
            jTextFieldEdad.setText(datos[2]);
            jTextFieldNacionalidad.setText(datos[3]);
            jTextFieldSexo.setText(datos[4]);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Artista", "Ver Artista", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarArtista() {
        cargarDatosDelArtista();
        if (principalFrame.eliminarArtista(Integer.parseInt(jTextFieldID.getText()))) {
            JOptionPane.showMessageDialog(this, "Se elimino el Artista", "Eliminar Artista", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "No se elimino el Artista", "Eliminar Artista", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void crearArtista() {
        if (validar()) {
            int id = Integer.parseInt(jTextFieldID.getText());
            if (!principalFrame.existeArtista(id)) {
                String nombre = jTextFieldNombre.getText();
                int edad = Integer.parseInt(jTextFieldEdad.getText());
                String sexo = jTextFieldSexo.getText();
                String nacionalidad = jTextFieldNacionalidad.getText();
                if (principalFrame.crearArtista(id, nombre, edad, sexo, nacionalidad)) {
                    limpiar();
                    cargarArtistas();
                    JOptionPane.showMessageDialog(this, "el artista se creo correctamente", "Crear Artista", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El Artista no se pudo crear", "Crear Artista", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Artista ya existe", "Crear Artista", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Faltan Datos necesarios para la creacion del Artista", "Crear Artista", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void modificarArtista() {
        if (validar()) {
            int id = Integer.parseInt(jTextFieldID.getText());
            jTextFieldID.setEnabled(false);
            String nombre = jTextFieldNombre.getText();
            int edad = Integer.parseInt(jTextFieldEdad.getText());
            String sexo = jTextFieldSexo.getText();
            String nacionalidad = jTextFieldNacionalidad.getText();
            if (principalFrame.modificarArtista(id, nombre, edad, sexo, nacionalidad)) {
                JOptionPane.showMessageDialog(this, "el artista se modifico correctamente", "Modificar Artista", JOptionPane.INFORMATION_MESSAGE);
                cargarArtistas();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "El Artista no se pudo modificar", "Modificar Artista", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Faltan Datos necesarios para la creacion del Artista", "Crear Artista", JOptionPane.WARNING_MESSAGE);
        }
    }

}
