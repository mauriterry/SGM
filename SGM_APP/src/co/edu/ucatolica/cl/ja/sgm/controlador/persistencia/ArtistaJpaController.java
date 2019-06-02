/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.persistencia;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.IllegalOrphanException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.PreexistingEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Artista;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ucatolica.cl.ja.sgm.modelo.Pista;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aasanchez
 */
public class ArtistaJpaController implements Serializable {

    public ArtistaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SGM_APPPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Artista artista) throws PreexistingEntityException, Exception {
        if (artista.getPistaList() == null) {
            artista.setPistaList(new ArrayList<Pista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pista> attachedPistaList = new ArrayList<Pista>();
            for (Pista pistaListPistaToAttach : artista.getPistaList()) {
                pistaListPistaToAttach = em.getReference(pistaListPistaToAttach.getClass(), pistaListPistaToAttach.getIdPista());
                attachedPistaList.add(pistaListPistaToAttach);
            }
            artista.setPistaList(attachedPistaList);
            em.persist(artista);
            for (Pista pistaListPista : artista.getPistaList()) {
                Artista oldArtistaIdArtistaOfPistaListPista = pistaListPista.getArtistaIdArtista();
                pistaListPista.setArtistaIdArtista(artista);
                pistaListPista = em.merge(pistaListPista);
                if (oldArtistaIdArtistaOfPistaListPista != null) {
                    oldArtistaIdArtistaOfPistaListPista.getPistaList().remove(pistaListPista);
                    oldArtistaIdArtistaOfPistaListPista = em.merge(oldArtistaIdArtistaOfPistaListPista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findArtista(artista.getIdArtista()) != null) {
                throw new PreexistingEntityException("Artista " + artista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Artista artista) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Artista persistentArtista = em.find(Artista.class, artista.getIdArtista());
            List<Pista> pistaListOld = persistentArtista.getPistaList();
            List<Pista> pistaListNew = artista.getPistaList();
            List<String> illegalOrphanMessages = null;
            for (Pista pistaListOldPista : pistaListOld) {
                if (!pistaListNew.contains(pistaListOldPista)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pista " + pistaListOldPista + " since its artistaIdArtista field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Pista> attachedPistaListNew = new ArrayList<Pista>();
            for (Pista pistaListNewPistaToAttach : pistaListNew) {
                pistaListNewPistaToAttach = em.getReference(pistaListNewPistaToAttach.getClass(), pistaListNewPistaToAttach.getIdPista());
                attachedPistaListNew.add(pistaListNewPistaToAttach);
            }
            pistaListNew = attachedPistaListNew;
            artista.setPistaList(pistaListNew);
            artista = em.merge(artista);
            for (Pista pistaListNewPista : pistaListNew) {
                if (!pistaListOld.contains(pistaListNewPista)) {
                    Artista oldArtistaIdArtistaOfPistaListNewPista = pistaListNewPista.getArtistaIdArtista();
                    pistaListNewPista.setArtistaIdArtista(artista);
                    pistaListNewPista = em.merge(pistaListNewPista);
                    if (oldArtistaIdArtistaOfPistaListNewPista != null && !oldArtistaIdArtistaOfPistaListNewPista.equals(artista)) {
                        oldArtistaIdArtistaOfPistaListNewPista.getPistaList().remove(pistaListNewPista);
                        oldArtistaIdArtistaOfPistaListNewPista = em.merge(oldArtistaIdArtistaOfPistaListNewPista);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = artista.getIdArtista();
                if (findArtista(id) == null) {
                    throw new NonexistentEntityException("The artista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Artista artista;
            try {
                artista = em.getReference(Artista.class, id);
                artista.getIdArtista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The artista with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pista> pistaListOrphanCheck = artista.getPistaList();
            for (Pista pistaListOrphanCheckPista : pistaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Artista (" + artista + ") cannot be destroyed since the Pista " + pistaListOrphanCheckPista + " in its pistaList field has a non-nullable artistaIdArtista field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(artista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Artista> findArtistaEntities() {
        return findArtistaEntities(true, -1, -1);
    }

    public List<Artista> findArtistaEntities(int maxResults, int firstResult) {
        return findArtistaEntities(false, maxResults, firstResult);
    }

    private List<Artista> findArtistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Artista.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Artista findArtista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Artista.class, id);
        } finally {
            em.close();
        }
    }

    public int getArtistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Artista> rt = cq.from(Artista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
