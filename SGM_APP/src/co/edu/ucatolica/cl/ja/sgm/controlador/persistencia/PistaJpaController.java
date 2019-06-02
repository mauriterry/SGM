/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.persistencia;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ucatolica.cl.ja.sgm.modelo.Album;
import co.edu.ucatolica.cl.ja.sgm.modelo.Artista;
import co.edu.ucatolica.cl.ja.sgm.modelo.Lista;
import java.util.ArrayList;
import java.util.List;
import co.edu.ucatolica.cl.ja.sgm.modelo.Historial;
import co.edu.ucatolica.cl.ja.sgm.modelo.Pista;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aasanchez
 */
public class PistaJpaController implements Serializable {

    public PistaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SGM_APPPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pista pista) {
        if (pista.getListaList() == null) {
            pista.setListaList(new ArrayList<Lista>());
        }
        if (pista.getHistorialList() == null) {
            pista.setHistorialList(new ArrayList<Historial>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Album albumIdAlbum = pista.getAlbumIdAlbum();
            if (albumIdAlbum != null) {
                albumIdAlbum = em.getReference(albumIdAlbum.getClass(), albumIdAlbum.getIdAlbum());
                pista.setAlbumIdAlbum(albumIdAlbum);
            }
            Artista artistaIdArtista = pista.getArtistaIdArtista();
            if (artistaIdArtista != null) {
                artistaIdArtista = em.getReference(artistaIdArtista.getClass(), artistaIdArtista.getIdArtista());
                pista.setArtistaIdArtista(artistaIdArtista);
            }
            List<Lista> attachedListaList = new ArrayList<Lista>();
            for (Lista listaListListaToAttach : pista.getListaList()) {
                listaListListaToAttach = em.getReference(listaListListaToAttach.getClass(), listaListListaToAttach.getIdLista());
                attachedListaList.add(listaListListaToAttach);
            }
            pista.setListaList(attachedListaList);
            List<Historial> attachedHistorialList = new ArrayList<Historial>();
            for (Historial historialListHistorialToAttach : pista.getHistorialList()) {
                historialListHistorialToAttach = em.getReference(historialListHistorialToAttach.getClass(), historialListHistorialToAttach.getIdHistorial());
                attachedHistorialList.add(historialListHistorialToAttach);
            }
            pista.setHistorialList(attachedHistorialList);
            em.persist(pista);
            if (albumIdAlbum != null) {
                albumIdAlbum.getPistaList().add(pista);
                albumIdAlbum = em.merge(albumIdAlbum);
            }
            if (artistaIdArtista != null) {
                artistaIdArtista.getPistaList().add(pista);
                artistaIdArtista = em.merge(artistaIdArtista);
            }
            for (Lista listaListLista : pista.getListaList()) {
                listaListLista.getPistaList().add(pista);
                listaListLista = em.merge(listaListLista);
            }
            for (Historial historialListHistorial : pista.getHistorialList()) {
                historialListHistorial.getPistaList().add(pista);
                historialListHistorial = em.merge(historialListHistorial);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pista pista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pista persistentPista = em.find(Pista.class, pista.getIdPista());
            Album albumIdAlbumOld = persistentPista.getAlbumIdAlbum();
            Album albumIdAlbumNew = pista.getAlbumIdAlbum();
            Artista artistaIdArtistaOld = persistentPista.getArtistaIdArtista();
            Artista artistaIdArtistaNew = pista.getArtistaIdArtista();
            List<Lista> listaListOld = persistentPista.getListaList();
            List<Lista> listaListNew = pista.getListaList();
            List<Historial> historialListOld = persistentPista.getHistorialList();
            List<Historial> historialListNew = pista.getHistorialList();
            if (albumIdAlbumNew != null) {
                albumIdAlbumNew = em.getReference(albumIdAlbumNew.getClass(), albumIdAlbumNew.getIdAlbum());
                pista.setAlbumIdAlbum(albumIdAlbumNew);
            }
            if (artistaIdArtistaNew != null) {
                artistaIdArtistaNew = em.getReference(artistaIdArtistaNew.getClass(), artistaIdArtistaNew.getIdArtista());
                pista.setArtistaIdArtista(artistaIdArtistaNew);
            }
            List<Lista> attachedListaListNew = new ArrayList<Lista>();
            for (Lista listaListNewListaToAttach : listaListNew) {
                listaListNewListaToAttach = em.getReference(listaListNewListaToAttach.getClass(), listaListNewListaToAttach.getIdLista());
                attachedListaListNew.add(listaListNewListaToAttach);
            }
            listaListNew = attachedListaListNew;
            pista.setListaList(listaListNew);
            List<Historial> attachedHistorialListNew = new ArrayList<Historial>();
            for (Historial historialListNewHistorialToAttach : historialListNew) {
                historialListNewHistorialToAttach = em.getReference(historialListNewHistorialToAttach.getClass(), historialListNewHistorialToAttach.getIdHistorial());
                attachedHistorialListNew.add(historialListNewHistorialToAttach);
            }
            historialListNew = attachedHistorialListNew;
            pista.setHistorialList(historialListNew);
            pista = em.merge(pista);
            if (albumIdAlbumOld != null && !albumIdAlbumOld.equals(albumIdAlbumNew)) {
                albumIdAlbumOld.getPistaList().remove(pista);
                albumIdAlbumOld = em.merge(albumIdAlbumOld);
            }
            if (albumIdAlbumNew != null && !albumIdAlbumNew.equals(albumIdAlbumOld)) {
                albumIdAlbumNew.getPistaList().add(pista);
                albumIdAlbumNew = em.merge(albumIdAlbumNew);
            }
            if (artistaIdArtistaOld != null && !artistaIdArtistaOld.equals(artistaIdArtistaNew)) {
                artistaIdArtistaOld.getPistaList().remove(pista);
                artistaIdArtistaOld = em.merge(artistaIdArtistaOld);
            }
            if (artistaIdArtistaNew != null && !artistaIdArtistaNew.equals(artistaIdArtistaOld)) {
                artistaIdArtistaNew.getPistaList().add(pista);
                artistaIdArtistaNew = em.merge(artistaIdArtistaNew);
            }
            for (Lista listaListOldLista : listaListOld) {
                if (!listaListNew.contains(listaListOldLista)) {
                    listaListOldLista.getPistaList().remove(pista);
                    listaListOldLista = em.merge(listaListOldLista);
                }
            }
            for (Lista listaListNewLista : listaListNew) {
                if (!listaListOld.contains(listaListNewLista)) {
                    listaListNewLista.getPistaList().add(pista);
                    listaListNewLista = em.merge(listaListNewLista);
                }
            }
            for (Historial historialListOldHistorial : historialListOld) {
                if (!historialListNew.contains(historialListOldHistorial)) {
                    historialListOldHistorial.getPistaList().remove(pista);
                    historialListOldHistorial = em.merge(historialListOldHistorial);
                }
            }
            for (Historial historialListNewHistorial : historialListNew) {
                if (!historialListOld.contains(historialListNewHistorial)) {
                    historialListNewHistorial.getPistaList().add(pista);
                    historialListNewHistorial = em.merge(historialListNewHistorial);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pista.getIdPista();
                if (findPista(id) == null) {
                    throw new NonexistentEntityException("The pista with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pista pista;
            try {
                pista = em.getReference(Pista.class, id);
                pista.getIdPista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pista with id " + id + " no longer exists.", enfe);
            }
            Album albumIdAlbum = pista.getAlbumIdAlbum();
            if (albumIdAlbum != null) {
                albumIdAlbum.getPistaList().remove(pista);
                albumIdAlbum = em.merge(albumIdAlbum);
            }
            Artista artistaIdArtista = pista.getArtistaIdArtista();
            if (artistaIdArtista != null) {
                artistaIdArtista.getPistaList().remove(pista);
                artistaIdArtista = em.merge(artistaIdArtista);
            }
            List<Lista> listaList = pista.getListaList();
            for (Lista listaListLista : listaList) {
                listaListLista.getPistaList().remove(pista);
                listaListLista = em.merge(listaListLista);
            }
            List<Historial> historialList = pista.getHistorialList();
            for (Historial historialListHistorial : historialList) {
                historialListHistorial.getPistaList().remove(pista);
                historialListHistorial = em.merge(historialListHistorial);
            }
            em.remove(pista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pista> findPistaEntities() {
        return findPistaEntities(true, -1, -1);
    }

    public List<Pista> findPistaEntities(int maxResults, int firstResult) {
        return findPistaEntities(false, maxResults, firstResult);
    }

    private List<Pista> findPistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pista.class));
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

    public Pista findPista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pista.class, id);
        } finally {
            em.close();
        }
    }

    public int getPistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pista> rt = cq.from(Pista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
