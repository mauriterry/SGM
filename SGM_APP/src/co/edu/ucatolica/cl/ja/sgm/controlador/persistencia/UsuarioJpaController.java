/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.controlador.persistencia;

import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.IllegalOrphanException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.NonexistentEntityException;
import co.edu.ucatolica.cl.ja.sgm.controlador.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ucatolica.cl.ja.sgm.modelo.Lista;
import java.util.ArrayList;
import java.util.List;
import co.edu.ucatolica.cl.ja.sgm.modelo.Historial;
import co.edu.ucatolica.cl.ja.sgm.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aasanchez
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("SGM_APPPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getListaList() == null) {
            usuario.setListaList(new ArrayList<Lista>());
        }
        if (usuario.getHistorialList() == null) {
            usuario.setHistorialList(new ArrayList<Historial>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Lista> attachedListaList = new ArrayList<Lista>();
            for (Lista listaListListaToAttach : usuario.getListaList()) {
                listaListListaToAttach = em.getReference(listaListListaToAttach.getClass(), listaListListaToAttach.getIdLista());
                attachedListaList.add(listaListListaToAttach);
            }
            usuario.setListaList(attachedListaList);
            List<Historial> attachedHistorialList = new ArrayList<Historial>();
            for (Historial historialListHistorialToAttach : usuario.getHistorialList()) {
                historialListHistorialToAttach = em.getReference(historialListHistorialToAttach.getClass(), historialListHistorialToAttach.getIdHistorial());
                attachedHistorialList.add(historialListHistorialToAttach);
            }
            usuario.setHistorialList(attachedHistorialList);
            em.persist(usuario);
            for (Lista listaListLista : usuario.getListaList()) {
                Usuario oldUsuarioNicknameOfListaListLista = listaListLista.getUsuarioNickname();
                listaListLista.setUsuarioNickname(usuario);
                listaListLista = em.merge(listaListLista);
                if (oldUsuarioNicknameOfListaListLista != null) {
                    oldUsuarioNicknameOfListaListLista.getListaList().remove(listaListLista);
                    oldUsuarioNicknameOfListaListLista = em.merge(oldUsuarioNicknameOfListaListLista);
                }
            }
            for (Historial historialListHistorial : usuario.getHistorialList()) {
                Usuario oldUsuarioNicknameOfHistorialListHistorial = historialListHistorial.getUsuarioNickname();
                historialListHistorial.setUsuarioNickname(usuario);
                historialListHistorial = em.merge(historialListHistorial);
                if (oldUsuarioNicknameOfHistorialListHistorial != null) {
                    oldUsuarioNicknameOfHistorialListHistorial.getHistorialList().remove(historialListHistorial);
                    oldUsuarioNicknameOfHistorialListHistorial = em.merge(oldUsuarioNicknameOfHistorialListHistorial);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getNickname()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getNickname());
            List<Lista> listaListOld = persistentUsuario.getListaList();
            List<Lista> listaListNew = usuario.getListaList();
            List<Historial> historialListOld = persistentUsuario.getHistorialList();
            List<Historial> historialListNew = usuario.getHistorialList();
            List<String> illegalOrphanMessages = null;
            for (Lista listaListOldLista : listaListOld) {
                if (!listaListNew.contains(listaListOldLista)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lista " + listaListOldLista + " since its usuarioNickname field is not nullable.");
                }
            }
            for (Historial historialListOldHistorial : historialListOld) {
                if (!historialListNew.contains(historialListOldHistorial)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historial " + historialListOldHistorial + " since its usuarioNickname field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Lista> attachedListaListNew = new ArrayList<Lista>();
            for (Lista listaListNewListaToAttach : listaListNew) {
                listaListNewListaToAttach = em.getReference(listaListNewListaToAttach.getClass(), listaListNewListaToAttach.getIdLista());
                attachedListaListNew.add(listaListNewListaToAttach);
            }
            listaListNew = attachedListaListNew;
            usuario.setListaList(listaListNew);
            List<Historial> attachedHistorialListNew = new ArrayList<Historial>();
            for (Historial historialListNewHistorialToAttach : historialListNew) {
                historialListNewHistorialToAttach = em.getReference(historialListNewHistorialToAttach.getClass(), historialListNewHistorialToAttach.getIdHistorial());
                attachedHistorialListNew.add(historialListNewHistorialToAttach);
            }
            historialListNew = attachedHistorialListNew;
            usuario.setHistorialList(historialListNew);
            usuario = em.merge(usuario);
            for (Lista listaListNewLista : listaListNew) {
                if (!listaListOld.contains(listaListNewLista)) {
                    Usuario oldUsuarioNicknameOfListaListNewLista = listaListNewLista.getUsuarioNickname();
                    listaListNewLista.setUsuarioNickname(usuario);
                    listaListNewLista = em.merge(listaListNewLista);
                    if (oldUsuarioNicknameOfListaListNewLista != null && !oldUsuarioNicknameOfListaListNewLista.equals(usuario)) {
                        oldUsuarioNicknameOfListaListNewLista.getListaList().remove(listaListNewLista);
                        oldUsuarioNicknameOfListaListNewLista = em.merge(oldUsuarioNicknameOfListaListNewLista);
                    }
                }
            }
            for (Historial historialListNewHistorial : historialListNew) {
                if (!historialListOld.contains(historialListNewHistorial)) {
                    Usuario oldUsuarioNicknameOfHistorialListNewHistorial = historialListNewHistorial.getUsuarioNickname();
                    historialListNewHistorial.setUsuarioNickname(usuario);
                    historialListNewHistorial = em.merge(historialListNewHistorial);
                    if (oldUsuarioNicknameOfHistorialListNewHistorial != null && !oldUsuarioNicknameOfHistorialListNewHistorial.equals(usuario)) {
                        oldUsuarioNicknameOfHistorialListNewHistorial.getHistorialList().remove(historialListNewHistorial);
                        oldUsuarioNicknameOfHistorialListNewHistorial = em.merge(oldUsuarioNicknameOfHistorialListNewHistorial);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getNickname();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getNickname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Lista> listaListOrphanCheck = usuario.getListaList();
            for (Lista listaListOrphanCheckLista : listaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Lista " + listaListOrphanCheckLista + " in its listaList field has a non-nullable usuarioNickname field.");
            }
            List<Historial> historialListOrphanCheck = usuario.getHistorialList();
            for (Historial historialListOrphanCheckHistorial : historialListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Historial " + historialListOrphanCheckHistorial + " in its historialList field has a non-nullable usuarioNickname field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
