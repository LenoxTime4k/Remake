/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author javie
 */
@Service
public class loginConstroller {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackFor={ServicioException.class})
    
    public void create(Usuario dto) throws ServicioException{
       em.persist(dto);
       //em.merge(dto); actualizar
       //em.remove(dto); borrar
       //em.find(Alumno.class,"111"); buscar por pk
       
    }
    
    public Usuario BuscarPorRut(String rut) throws SecurityException{
        return em.find(Usuario.class, rut);
    }
    //hace una query a la clase
    public Usuario BuscarPorRutJPQL(String rut)throws SecurityException{
        String sql="select a from Alumno a where a.rut = :rut";
        
        Query q=em.createQuery(sql);
        q.setParameter("rut", rut);
        
        try{
            return (Usuario)q.getSingleResult();
        }catch (Exception e){
     return null;
        }
        
    }
    //Consulta completa
    public List<Usuario> ListaJPQL()throws SecurityException{
    
        String sql="Select a from Alumno a";
        Query q=em.createQuery(sql);
        return q.getResultList();
        
    }
    
    public boolean leerRutCreado(String rut)throws SecurityException{
        String sql="Select a from Alumno a where a.rut = :rut";
        
        Query q=em.createQuery(sql);
        q.setParameter("rut", rut);
        
        if (q.getResultList().size()>0){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public int crearJPQL(Usuario dto)throws SecurityException{
       
        if (leerRutCreado(dto.getRut().toString())){
            return 0;
        }
        else{
            em.persist(dto);
            return 1;
        }
    }
        
      
        
}