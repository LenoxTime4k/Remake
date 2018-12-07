/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerJPA;

import ControllerJPA.exceptions.NonexistentEntityException;
import Model.Resgistrousuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Andyees
 */
public class ResgistrousuarioJpaController implements Serializable {

    public ResgistrousuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("RemakeSMPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Resgistrousuario resgistrousuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(resgistrousuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Resgistrousuario resgistrousuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            resgistrousuario = em.merge(resgistrousuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = resgistrousuario.getId();
                if (findResgistrousuario(id) == null) {
                    throw new NonexistentEntityException("The resgistrousuario with id " + id + " no longer exists.");
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
            Resgistrousuario resgistrousuario;
            try {
                resgistrousuario = em.getReference(Resgistrousuario.class, id);
                resgistrousuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resgistrousuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(resgistrousuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Resgistrousuario> findResgistrousuarioEntities() {
        return findResgistrousuarioEntities(true, -1, -1);
    }

    public List<Resgistrousuario> findResgistrousuarioEntities(int maxResults, int firstResult) {
        return findResgistrousuarioEntities(false, maxResults, firstResult);
    }

    private List<Resgistrousuario> findResgistrousuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Resgistrousuario.class));
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

    public Resgistrousuario findResgistrousuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Resgistrousuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getResgistrousuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Resgistrousuario> rt = cq.from(Resgistrousuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
