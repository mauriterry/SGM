/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.persistencia;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.PreexistingEntityException;
import co.edu.ucatolica.cl.ja.sgm.modelo.Lista;
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
public class ListaJpaController implements Serializable {

    public ListaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SGM_APPPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lista lista) throws PreexistingEntityException, Exception {
        if (lista.getPistaList() == null) {
            lista.setPistaList(new ArrayList<Pista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuarioNickname = lista.getUsuarioNickname();
            if (usuarioNickname != null) {
                usuarioNickname = em.getReference(usuarioNickname.getClass(), usuarioNickname.getNickname());
                lista.setUsuarioNickname(usuarioNickname);
            }
            List<Pista> attachedPistaList = new ArrayList<Pista>();
            for (Pista pistaListPistaToAttach : lista.getPistaList()) {
                pistaListPistaToAttach = em.getReference(pistaListPistaToAttach.getClass(), pistaListPistaToAttach.getIdPista());
                attachedPistaList.add(pistaListPistaToAttach);
            }
            lista.setPistaList(attachedPistaList);
            em.persist(lista);
            if (usuarioNickname != null) {
                usuarioNickname.getListaList().add(lista);
                usuarioNickname = em.merge(usuarioNickname);
            }
            for (Pista pistaListPista : lista.getPistaList()) {
                pistaListPista.getListaList().add(lista);
                pistaListPista = em.merge(pistaListPista);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLista(lista.getIdLista()) != null) {
                throw new PreexistingEntityException("Lista " + lista + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lista lista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lista persistentLista = em.find(Lista.class, lista.getIdLista());
            Usuario usuarioNicknameOld = persistentLista.getUsuarioNickname();
            Usuario usuarioNicknameNew = lista.getUsuarioNickname();
            List<Pista> pistaListOld = persistentLista.getPistaList();
            List<Pista> pistaListNew = lista.getPistaList();
            if (usuarioNicknameNew != null) {
                usuarioNicknameNew = em.getReference(usuarioNicknameNew.getClass(), usuarioNicknameNew.getNickname());
                lista.setUsuarioNickname(usuarioNicknameNew);
            }
            List<Pista> attachedPistaListNew = new ArrayList<Pista>();
            for (Pista pistaListNewPistaToAttach : pistaListNew) {
                pistaListNewPistaToAttach = em.getReference(pistaListNewPistaToAttach.getClass(), pistaListNewPistaToAttach.getIdPista());
                attachedPistaListNew.add(pistaListNewPistaToAttach);
            }
            pistaListNew = attachedPistaListNew;
            lista.setPistaList(pistaListNew);
            lista = em.merge(lista);
            if (usuarioNicknameOld != null && !usuarioNicknameOld.equals(usuarioNicknameNew)) {
                usuarioNicknameOld.getListaList().remove(lista);
                usuarioNicknameOld = em.merge(usuarioNicknameOld);
            }
            if (usuarioNicknameNew != null && !usuarioNicknameNew.equals(usuarioNicknameOld)) {
                usuarioNicknameNew.getListaList().add(lista);
                usuarioNicknameNew = em.merge(usuarioNicknameNew);
            }
            for (Pista pistaListOldPista : pistaListOld) {
                if (!pistaListNew.contains(pistaListOldPista)) {
                    pistaListOldPista.getListaList().remove(lista);
                    pistaListOldPista = em.merge(pistaListOldPista);
                }
            }
            for (Pista pistaListNewPista : pistaListNew) {
                if (!pistaListOld.contains(pistaListNewPista)) {
                    pistaListNewPista.getListaList().add(lista);
                    pistaListNewPista = em.merge(pistaListNewPista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lista.getIdLista();
                if (findLista(id) == null) {
                    throw new NonexistentEntityException("The lista with id " + id + " no longer exists.");
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
            Lista lista;
            try {
                lista = em.getReference(Lista.class, id);
                lista.getIdLista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lista with id " + id + " no longer exists.", enfe);
            }
            Usuario usuarioNickname = lista.getUsuarioNickname();
            if (usuarioNickname != null) {
                usuarioNickname.getListaList().remove(lista);
                usuarioNickname = em.merge(usuarioNickname);
            }
            List<Pista> pistaList = lista.getPistaList();
            for (Pista pistaListPista : pistaList) {
                pistaListPista.getListaList().remove(lista);
                pistaListPista = em.merge(pistaListPista);
            }
            em.remove(lista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lista> findListaEntities() {
        return findListaEntities(true, -1, -1);
    }

    public List<Lista> findListaEntities(int maxResults, int firstResult) {
        return findListaEntities(false, maxResults, firstResult);
    }

    private List<Lista> findListaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lista.class));
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

    public Lista findLista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lista.class, id);
        } finally {
            em.close();
        }
    }

    public int getListaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lista> rt = cq.from(Lista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
