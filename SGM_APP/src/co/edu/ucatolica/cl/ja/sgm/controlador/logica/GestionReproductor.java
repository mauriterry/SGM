/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.logica;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.HistorialJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.ListaJpaController;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Historial;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Francia
 */
public class GestionReproductor {

    
    private final ListaJpaController listaJpaController;
    private final HistorialJpaController historialJpaController;

    public GestionReproductor() {
        this.listaJpaController = new ListaJpaController();
        this.historialJpaController = new HistorialJpaController();
    }
    
    public static void eliminarHistorial(Historial historial) {
        try {
            HistorialJpaController controller = new HistorialJpaController();
            controller.destroy(historial.getIdHistorial());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestionReproductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
