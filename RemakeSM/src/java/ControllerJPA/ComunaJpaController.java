/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerJPA;

import ControllerJPA.exceptions.IllegalOrphanException;
import ControllerJPA.exceptions.NonexistentEntityException;
import Model.Comuna;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andyees
 */
public class ComunaJpaController implements Serializable {

    public ComunaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comuna comuna) {
        if (comuna.getUsuarioCollection() == null) {
            comuna.setUsuarioCollection(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : comuna.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getRutUsuario());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            comuna.setUsuarioCollection(attachedUsuarioCollection);
            em.persist(comuna);
            for (Usuario usuarioCollectionUsuario : comuna.getUsuarioCollection()) {
                Comuna oldComunaidComunaOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getComunaidComuna();
                usuarioCollectionUsuario.setComunaidComuna(comuna);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldComunaidComunaOfUsuarioCollectionUsuario != null) {
                    oldComunaidComunaOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldComunaidComunaOfUsuarioCollectionUsuario = em.merge(oldComunaidComunaOfUsuarioCollectionUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comuna comuna) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comuna persistentComuna = em.find(Comuna.class, comuna.getIdComuna());
            Collection<Usuario> usuarioCollectionOld = persistentComuna.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = comuna.getUsuarioCollection();
            List<String> illegalOrphanMessages = null;
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioCollectionOldUsuario + " since its comunaidComuna field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getRutUsuario());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            comuna.setUsuarioCollection(usuarioCollectionNew);
            comuna = em.merge(comuna);
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Comuna oldComunaidComunaOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getComunaidComuna();
                    usuarioCollectionNewUsuario.setComunaidComuna(comuna);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldComunaidComunaOfUsuarioCollectionNewUsuario != null && !oldComunaidComunaOfUsuarioCollectionNewUsuario.equals(comuna)) {
                        oldComunaidComunaOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldComunaidComunaOfUsuarioCollectionNewUsuario = em.merge(oldComunaidComunaOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comuna.getIdComuna();
                if (findComuna(id) == null) {
                    throw new NonexistentEntityException("The comuna with id " + id + " no longer exists.");
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
            Comuna comuna;
            try {
                comuna = em.getReference(Comuna.class, id);
                comuna.getIdComuna();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comuna with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Usuario> usuarioCollectionOrphanCheck = comuna.getUsuarioCollection();
            for (Usuario usuarioCollectionOrphanCheckUsuario : usuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Comuna (" + comuna + ") cannot be destroyed since the Usuario " + usuarioCollectionOrphanCheckUsuario + " in its usuarioCollection field has a non-nullable comunaidComuna field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(comuna);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comuna> findComunaEntities() {
        return findComunaEntities(true, -1, -1);
    }

    public List<Comuna> findComunaEntities(int maxResults, int firstResult) {
        return findComunaEntities(false, maxResults, firstResult);
    }

    private List<Comuna> findComunaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comuna.class));
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

    public Comuna findComuna(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comuna.class, id);
        } finally {
            em.close();
        }
    }

    public int getComunaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comuna> rt = cq.from(Comuna.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
