package co.edu.ucatolica.cl.ja.sgm.vista;

/**
 *
 * @author oscar
 */
public class GestionPistaPanel extends javax.swing.JPanel {

    private final PrincipalFrame principalFrame;

    /**
     * Creates new form vista
     * @param principalFrame
     */
    public GestionPistaPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        initComponents();
        //ToDo
        cargarAlbumnes();
        cargarArtistas();
        cargarPistas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonGestionMusica = new javax.swing.JButton();
        jButtonNuevoArtista = new javax.swing.JButton();
        jButtonNuevoAlbum = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelDuracion = new javax.swing.JLabel();
        jTextFieldDuracion = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();
        jLabelIdValor = new javax.swing.JLabel();
        jLabelFechaGenero = new javax.swing.JLabel();
        jTextFieldFechaGenero = new javax.swing.JTextField();
        jLabelTipo = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jLabelVideo = new javax.swing.JLabel();
        jTextFieldVideo = new javax.swing.JTextField();
        jLabelAudio = new javax.swing.JLabel();
        jLabelAudioRuta = new javax.swing.JLabel();
        jLabelAlbum = new javax.swing.JLabel();
        jComboBoxAlbumes = new javax.swing.JComboBox<>();
        jLabelArtista = new javax.swing.JLabel();
        jComboBoxArtistas = new javax.swing.JComboBox<>();
        JButtonCrearPista = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonArchivo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTituloPistas = new javax.swing.JLabel();
        jScrollPanePistas = new javax.swing.JScrollPane();
        jTextAreaPistas = new javax.swing.JTextArea();
        jComboBoxPistas = new javax.swing.JComboBox<>();
        jButtonCargarPista = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setText("Gestion de Pistas");

        jButtonGestionMusica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonGestionMusica.setText("Gestion Musica");
        jButtonGestionMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionMusicaActionPerformed(evt);
            }
        });

        jButtonNuevoArtista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNuevoArtista.setText("Nuevo Artista");
        jButtonNuevoArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoArtistaActionPerformed(evt);
            }
        });

        jButtonNuevoAlbum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNuevoAlbum.setText("Nuevo Album");
        jButtonNuevoAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoAlbumActionPerformed(evt);
            }
        });

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNombre.setText("Nombre:");

        jTextFieldNombre.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabelDuracion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDuracion.setText("Duracion:");

        jLabelId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelId.setText("ID");

        jLabelIdValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabelFechaGenero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFechaGenero.setText("Genero:");

        jTextFieldFechaGenero.setToolTipText("");

        jLabelTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTipo.setText("Tipo:");

        jLabelVideo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelVideo.setText("Video:");

        jLabelAudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAudio.setText("Audio:");

        jLabelAudioRuta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAudioRuta.setText("Ruta");

        jLabelAlbum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAlbum.setText("Album:");

        jComboBoxAlbumes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxAlbumes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja un Album", " " }));

        jLabelArtista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelArtista.setText("Artista:");

        jComboBoxArtistas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja un Artista" }));

        JButtonCrearPista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JButtonCrearPista.setText("Crear Pista");
        JButtonCrearPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCrearPistaActionPerformed(evt);
            }
        });

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonArchivo.setText("Archivo");
        jButtonArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArchivoActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelTituloPistas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTituloPistas.setText("Pistas");

        jTextAreaPistas.setColumns(20);
        jTextAreaPistas.setRows(5);
        jScrollPanePistas.setViewportView(jTextAreaPistas);

        jComboBoxPistas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxPistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja una Pista" }));

        jButtonCargarPista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCargarPista.setText("Cargar");
        jButtonCargarPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarPistaActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonGestionMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNuevoArtista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNuevoAlbum)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelArtista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabelAlbum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelAudio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxAlbumes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxArtistas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelAudioRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFechaGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDuracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldFechaGenero)
                            .addComponent(jTextFieldTipo)
                            .addComponent(jTextFieldVideo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelIdValor, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JButtonCrearPista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabelTituloPistas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPanePistas, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCargarPista))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButtonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGestionMusica)
                    .addComponent(jButtonNuevoArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNuevoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTituloPistas)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelNombre)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDuracion)
                                        .addComponent(jTextFieldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelId)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelFechaGenero)
                                    .addComponent(jTextFieldFechaGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelTipo)
                                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelVideo)
                                    .addComponent(jTextFieldVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelAudio)
                                    .addComponent(jLabelAudioRuta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelAlbum)
                                    .addComponent(jComboBoxAlbumes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelArtista)
                                    .addComponent(jComboBoxArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JButtonCrearPista)
                                    .addComponent(jButtonLimpiar)
                                    .addComponent(jButtonArchivo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPanePistas, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxPistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonCargarPista))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonModificar)
                                    .addComponent(jButtonEliminar))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonCrearPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCrearPistaActionPerformed
        crearPista();
    }//GEN-LAST:event_JButtonCrearPistaActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonGestionMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionMusicaActionPerformed
        principalFrame.irAGestionMusicaLista();
    }//GEN-LAST:event_jButtonGestionMusicaActionPerformed

    private void jButtonCargarPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarPistaActionPerformed
        cargarDatosDeLaPista();
    }//GEN-LAST:event_jButtonCargarPistaActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        eliminarPista();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        modificarPista();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonNuevoArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoArtistaActionPerformed
        principalFrame.irAArtista();
    }//GEN-LAST:event_jButtonNuevoArtistaActionPerformed

    private void jButtonNuevoAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoAlbumActionPerformed
        principalFrame.irAGestionAlbum();
    }//GEN-LAST:event_jButtonNuevoAlbumActionPerformed

    private void jButtonArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArchivoActionPerformed
        cargarArchivoDeAudio();
    }//GEN-LAST:event_jButtonArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCrearPista;
    private javax.swing.JButton jButtonArchivo;
    private javax.swing.JButton jButtonCargarPista;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGestionMusica;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonNuevoAlbum;
    private javax.swing.JButton jButtonNuevoArtista;
    private javax.swing.JComboBox<String> jComboBoxAlbumes;
    private javax.swing.JComboBox<String> jComboBoxArtistas;
    private javax.swing.JComboBox<String> jComboBoxPistas;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelAudio;
    private javax.swing.JLabel jLabelAudioRuta;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelFechaGenero;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelIdValor;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTituloPistas;
    private javax.swing.JLabel jLabelVideo;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPanePistas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextAreaPistas;
    private javax.swing.JTextField jTextFieldDuracion;
    private javax.swing.JTextField jTextFieldFechaGenero;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldVideo;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void crearPista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarAlbumnes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarDatosDeLaPista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarPista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void modificarPista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarFoto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarArtistas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarPistas() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cargarArchivoDeAudio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
