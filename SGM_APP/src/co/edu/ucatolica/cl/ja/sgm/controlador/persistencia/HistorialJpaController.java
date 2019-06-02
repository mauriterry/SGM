/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.persistencia;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Historial;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ucatolica.cl.ja.sgm.modelo.Usuario;
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
public class HistorialJpaController implements Serializable {

    public HistorialJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SGM_APPPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historial historial) {
        if (historial.getPistaList() == null) {
            historial.setPistaList(new ArrayList<Pista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuarioNickname = historial.getUsuarioNickname();
            if (usuarioNickname != null) {
                usuarioNickname = em.getReference(usuarioNickname.getClass(), usuarioNickname.getNickname());
                historial.setUsuarioNickname(usuarioNickname);
            }
            List<Pista> attachedPistaList = new ArrayList<Pista>();
            for (Pista pistaListPistaToAttach : historial.getPistaList()) {
                pistaListPistaToAttach = em.getReference(pistaListPistaToAttach.getClass(), pistaListPistaToAttach.getIdPista());
                attachedPistaList.add(pistaListPistaToAttach);
            }
            historial.setPistaList(attachedPistaList);
            em.persist(historial);
            if (usuarioNickname != null) {
                usuarioNickname.getHistorialList().add(historial);
                usuarioNickname = em.merge(usuarioNickname);
            }
            for (Pista pistaListPista : historial.getPistaList()) {
                pistaListPista.getHistorialList().add(historial);
                pistaListPista = em.merge(pistaListPista);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historial historial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historial persistentHistorial = em.find(Historial.class, historial.getIdHistorial());
            Usuario usuarioNicknameOld = persistentHistorial.getUsuarioNickname();
            Usuario usuarioNicknameNew = historial.getUsuarioNickname();
            List<Pista> pistaListOld = persistentHistorial.getPistaList();
            List<Pista> pistaListNew = historial.getPistaList();
            if (usuarioNicknameNew != null) {
                usuarioNicknameNew = em.getReference(usuarioNicknameNew.getClass(), usuarioNicknameNew.getNickname());
                historial.setUsuarioNickname(usuarioNicknameNew);
            }
            List<Pista> attachedPistaListNew = new ArrayList<Pista>();
            for (Pista pistaListNewPistaToAttach : pistaListNew) {
                pistaListNewPistaToAttach = em.getReference(pistaListNewPistaToAttach.getClass(), pistaListNewPistaToAttach.getIdPista());
                attachedPistaListNew.add(pistaListNewPistaToAttach);
            }
            pistaListNew = attachedPistaListNew;
            historial.setPistaList(pistaListNew);
            historial = em.merge(historial);
            if (usuarioNicknameOld != null && !usuarioNicknameOld.equals(usuarioNicknameNew)) {
                usuarioNicknameOld.getHistorialList().remove(historial);
                usuarioNicknameOld = em.merge(usuarioNicknameOld);
            }
            if (usuarioNicknameNew != null && !usuarioNicknameNew.equals(usuarioNicknameOld)) {
                usuarioNicknameNew.getHistorialList().add(historial);
                usuarioNicknameNew = em.merge(usuarioNicknameNew);
            }
            for (Pista pistaListOldPista : pistaListOld) {
                if (!pistaListNew.contains(pistaListOldPista)) {
                    pistaListOldPista.getHistorialList().remove(historial);
                    pistaListOldPista = em.merge(pistaListOldPista);
                }
            }
            for (Pista pistaListNewPista : pistaListNew) {
                if (!pistaListOld.contains(pistaListNewPista)) {
                    pistaListNewPista.getHistorialList().add(historial);
                    pistaListNewPista = em.merge(pistaListNewPista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historial.getIdHistorial();
                if (findHistorial(id) == null) {
                    throw new NonexistentEntityException("The historial with id " + id + " no longer exists.");
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
            Historial historial;
            try {
                historial = em.getReference(Historial.class, id);
                historial.getIdHistorial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historial with id " + id + " no longer exists.", enfe);
            }
            Usuario usuarioNickname = historial.getUsuarioNickname();
            if (usuarioNickname != null) {
                usuarioNickname.getHistorialList().remove(historial);
                usuarioNickname = em.merge(usuarioNickname);
            }
            List<Pista> pistaList = historial.getPistaList();
            for (Pista pistaListPista : pistaList) {
                pistaListPista.getHistorialList().remove(historial);
                pistaListPista = em.merge(pistaListPista);
            }
            em.remove(historial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historial> findHistorialEntities() {
        return findHistorialEntities(true, -1, -1);
    }

    public List<Historial> findHistorialEntities(int maxResults, int firstResult) {
        return findHistorialEntities(false, maxResults, firstResult);
    }

    private List<Historial> findHistorialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historial.class));
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

    public Historial findHistorial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historial.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistorialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historial> rt = cq.from(Historial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
