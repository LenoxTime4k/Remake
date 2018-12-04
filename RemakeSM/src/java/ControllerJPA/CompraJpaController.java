/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerJPA;

import ControllerJPA.exceptions.IllegalOrphanException;
import ControllerJPA.exceptions.NonexistentEntityException;
import Model.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Producto;
import Model.Usuario;
import Model.Reporte;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Andyees
 */
public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) {
        if (compra.getReporteCollection() == null) {
            compra.setReporteCollection(new ArrayList<Reporte>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto productoidproducto = compra.getProductoidproducto();
            if (productoidproducto != null) {
                productoidproducto = em.getReference(productoidproducto.getClass(), productoidproducto.getIdProducto());
                compra.setProductoidproducto(productoidproducto);
            }
            Usuario usuariorutusuario = compra.getUsuariorutusuario();
            if (usuariorutusuario != null) {
                usuariorutusuario = em.getReference(usuariorutusuario.getClass(), usuariorutusuario.getRutUsuario());
                compra.setUsuariorutusuario(usuariorutusuario);
            }
            Collection<Reporte> attachedReporteCollection = new ArrayList<Reporte>();
            for (Reporte reporteCollectionReporteToAttach : compra.getReporteCollection()) {
                reporteCollectionReporteToAttach = em.getReference(reporteCollectionReporteToAttach.getClass(), reporteCollectionReporteToAttach.getIdReporte());
                attachedReporteCollection.add(reporteCollectionReporteToAttach);
            }
            compra.setReporteCollection(attachedReporteCollection);
            em.persist(compra);
            if (productoidproducto != null) {
                productoidproducto.getCompraCollection().add(compra);
                productoidproducto = em.merge(productoidproducto);
            }
            if (usuariorutusuario != null) {
                usuariorutusuario.getCompraCollection().add(compra);
                usuariorutusuario = em.merge(usuariorutusuario);
            }
            for (Reporte reporteCollectionReporte : compra.getReporteCollection()) {
                Compra oldCompraidcompraOfReporteCollectionReporte = reporteCollectionReporte.getCompraidcompra();
                reporteCollectionReporte.setCompraidcompra(compra);
                reporteCollectionReporte = em.merge(reporteCollectionReporte);
                if (oldCompraidcompraOfReporteCollectionReporte != null) {
                    oldCompraidcompraOfReporteCollectionReporte.getReporteCollection().remove(reporteCollectionReporte);
                    oldCompraidcompraOfReporteCollectionReporte = em.merge(oldCompraidcompraOfReporteCollectionReporte);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdCompra());
            Producto productoidproductoOld = persistentCompra.getProductoidproducto();
            Producto productoidproductoNew = compra.getProductoidproducto();
            Usuario usuariorutusuarioOld = persistentCompra.getUsuariorutusuario();
            Usuario usuariorutusuarioNew = compra.getUsuariorutusuario();
            Collection<Reporte> reporteCollectionOld = persistentCompra.getReporteCollection();
            Collection<Reporte> reporteCollectionNew = compra.getReporteCollection();
            List<String> illegalOrphanMessages = null;
            for (Reporte reporteCollectionOldReporte : reporteCollectionOld) {
                if (!reporteCollectionNew.contains(reporteCollectionOldReporte)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reporte " + reporteCollectionOldReporte + " since its compraidcompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productoidproductoNew != null) {
                productoidproductoNew = em.getReference(productoidproductoNew.getClass(), productoidproductoNew.getIdProducto());
                compra.setProductoidproducto(productoidproductoNew);
            }
            if (usuariorutusuarioNew != null) {
                usuariorutusuarioNew = em.getReference(usuariorutusuarioNew.getClass(), usuariorutusuarioNew.getRutUsuario());
                compra.setUsuariorutusuario(usuariorutusuarioNew);
            }
            Collection<Reporte> attachedReporteCollectionNew = new ArrayList<Reporte>();
            for (Reporte reporteCollectionNewReporteToAttach : reporteCollectionNew) {
                reporteCollectionNewReporteToAttach = em.getReference(reporteCollectionNewReporteToAttach.getClass(), reporteCollectionNewReporteToAttach.getIdReporte());
                attachedReporteCollectionNew.add(reporteCollectionNewReporteToAttach);
            }
            reporteCollectionNew = attachedReporteCollectionNew;
            compra.setReporteCollection(reporteCollectionNew);
            compra = em.merge(compra);
            if (productoidproductoOld != null && !productoidproductoOld.equals(productoidproductoNew)) {
                productoidproductoOld.getCompraCollection().remove(compra);
                productoidproductoOld = em.merge(productoidproductoOld);
            }
            if (productoidproductoNew != null && !productoidproductoNew.equals(productoidproductoOld)) {
                productoidproductoNew.getCompraCollection().add(compra);
                productoidproductoNew = em.merge(productoidproductoNew);
            }
            if (usuariorutusuarioOld != null && !usuariorutusuarioOld.equals(usuariorutusuarioNew)) {
                usuariorutusuarioOld.getCompraCollection().remove(compra);
                usuariorutusuarioOld = em.merge(usuariorutusuarioOld);
            }
            if (usuariorutusuarioNew != null && !usuariorutusuarioNew.equals(usuariorutusuarioOld)) {
                usuariorutusuarioNew.getCompraCollection().add(compra);
                usuariorutusuarioNew = em.merge(usuariorutusuarioNew);
            }
            for (Reporte reporteCollectionNewReporte : reporteCollectionNew) {
                if (!reporteCollectionOld.contains(reporteCollectionNewReporte)) {
                    Compra oldCompraidcompraOfReporteCollectionNewReporte = reporteCollectionNewReporte.getCompraidcompra();
                    reporteCollectionNewReporte.setCompraidcompra(compra);
                    reporteCollectionNewReporte = em.merge(reporteCollectionNewReporte);
                    if (oldCompraidcompraOfReporteCollectionNewReporte != null && !oldCompraidcompraOfReporteCollectionNewReporte.equals(compra)) {
                        oldCompraidcompraOfReporteCollectionNewReporte.getReporteCollection().remove(reporteCollectionNewReporte);
                        oldCompraidcompraOfReporteCollectionNewReporte = em.merge(oldCompraidcompraOfReporteCollectionNewReporte);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compra.getIdCompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
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
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Reporte> reporteCollectionOrphanCheck = compra.getReporteCollection();
            for (Reporte reporteCollectionOrphanCheckReporte : reporteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compra (" + compra + ") cannot be destroyed since the Reporte " + reporteCollectionOrphanCheckReporte + " in its reporteCollection field has a non-nullable compraidcompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Producto productoidproducto = compra.getProductoidproducto();
            if (productoidproducto != null) {
                productoidproducto.getCompraCollection().remove(compra);
                productoidproducto = em.merge(productoidproducto);
            }
            Usuario usuariorutusuario = compra.getUsuariorutusuario();
            if (usuariorutusuario != null) {
                usuariorutusuario.getCompraCollection().remove(compra);
                usuariorutusuario = em.merge(usuariorutusuario);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
