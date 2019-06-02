/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.persistencia;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.IllegalOrphanException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.PreexistingEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Album;
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
public class AlbumJpaController implements Serializable {

    public AlbumJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SGM_APPPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Album album) throws PreexistingEntityException, Exception {
        if (album.getPistaList() == null) {
            album.setPistaList(new ArrayList<Pista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Pista> attachedPistaList = new ArrayList<Pista>();
            for (Pista pistaListPistaToAttach : album.getPistaList()) {
                pistaListPistaToAttach = em.getReference(pistaListPistaToAttach.getClass(), pistaListPistaToAttach.getIdPista());
                attachedPistaList.add(pistaListPistaToAttach);
            }
            album.setPistaList(attachedPistaList);
            em.persist(album);
            for (Pista pistaListPista : album.getPistaList()) {
                Album oldAlbumIdAlbumOfPistaListPista = pistaListPista.getAlbumIdAlbum();
                pistaListPista.setAlbumIdAlbum(album);
                pistaListPista = em.merge(pistaListPista);
                if (oldAlbumIdAlbumOfPistaListPista != null) {
                    oldAlbumIdAlbumOfPistaListPista.getPistaList().remove(pistaListPista);
                    oldAlbumIdAlbumOfPistaListPista = em.merge(oldAlbumIdAlbumOfPistaListPista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlbum(album.getIdAlbum()) != null) {
                throw new PreexistingEntityException("Album " + album + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Album album) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Album persistentAlbum = em.find(Album.class, album.getIdAlbum());
            List<Pista> pistaListOld = persistentAlbum.getPistaList();
            List<Pista> pistaListNew = album.getPistaList();
            List<String> illegalOrphanMessages = null;
            for (Pista pistaListOldPista : pistaListOld) {
                if (!pistaListNew.contains(pistaListOldPista)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pista " + pistaListOldPista + " since its albumIdAlbum field is not nullable.");
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
            album.setPistaList(pistaListNew);
            album = em.merge(album);
            for (Pista pistaListNewPista : pistaListNew) {
                if (!pistaListOld.contains(pistaListNewPista)) {
                    Album oldAlbumIdAlbumOfPistaListNewPista = pistaListNewPista.getAlbumIdAlbum();
                    pistaListNewPista.setAlbumIdAlbum(album);
                    pistaListNewPista = em.merge(pistaListNewPista);
                    if (oldAlbumIdAlbumOfPistaListNewPista != null && !oldAlbumIdAlbumOfPistaListNewPista.equals(album)) {
                        oldAlbumIdAlbumOfPistaListNewPista.getPistaList().remove(pistaListNewPista);
                        oldAlbumIdAlbumOfPistaListNewPista = em.merge(oldAlbumIdAlbumOfPistaListNewPista);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = album.getIdAlbum();
                if (findAlbum(id) == null) {
                    throw new NonexistentEntityException("The album with id " + id + " no longer exists.");
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
            Album album;
            try {
                album = em.getReference(Album.class, id);
                album.getIdAlbum();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The album with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pista> pistaListOrphanCheck = album.getPistaList();
            for (Pista pistaListOrphanCheckPista : pistaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Album (" + album + ") cannot be destroyed since the Pista " + pistaListOrphanCheckPista + " in its pistaList field has a non-nullable albumIdAlbum field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(album);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Album> findAlbumEntities() {
        return findAlbumEntities(true, -1, -1);
    }

    public List<Album> findAlbumEntities(int maxResults, int firstResult) {
        return findAlbumEntities(false, maxResults, firstResult);
    }

    private List<Album> findAlbumEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Album.class));
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

    public Album findAlbum(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Album.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlbumCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Album> rt = cq.from(Album.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
