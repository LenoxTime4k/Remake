/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andyees
 */
@Entity
@Table(name = "resgistrousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resgistrousuario.findAll", query = "SELECT r FROM Resgistrousuario r")
    , @NamedQuery(name = "Resgistrousuario.findById", query = "SELECT r FROM Resgistrousuario r WHERE r.id = :id")
    , @NamedQuery(name = "Resgistrousuario.findByNombreUsuario", query = "SELECT r FROM Resgistrousuario r WHERE r.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Resgistrousuario.findByContrase\u00f1a", query = "SELECT r FROM Resgistrousuario r WHERE r.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Resgistrousuario.findByNombreCompleto", query = "SELECT r FROM Resgistrousuario r WHERE r.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Resgistrousuario.findByRutReg", query = "SELECT r FROM Resgistrousuario r WHERE r.rutReg = :rutReg")
    , @NamedQuery(name = "Resgistrousuario.findByComunaresidencia", query = "SELECT r FROM Resgistrousuario r WHERE r.comunaresidencia = :comunaresidencia")
    , @NamedQuery(name = "Resgistrousuario.findBySede", query = "SELECT r FROM Resgistrousuario r WHERE r.sede = :sede")})
public class Resgistrousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @Column(name = "rut_reg")
    private String rutReg;
    @Basic(optional = false)
    @Column(name = "Comuna_residencia")
    private String comunaresidencia;
    @Basic(optional = false)
    @Column(name = "sede")
    private String sede;

    public Resgistrousuario() {
    }

    public Resgistrousuario(Integer id) {
        this.id = id;
    }

    public Resgistrousuario(Integer id, String nombreUsuario, String contraseña, String nombreCompleto, String rutReg, String comunaresidencia, String sede) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.rutReg = rutReg;
        this.comunaresidencia = comunaresidencia;
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRutReg() {
        return rutReg;
    }

    public void setRutReg(String rutReg) {
        this.rutReg = rutReg;
    }

    public String getComunaresidencia() {
        return comunaresidencia;
    }

    public void setComunaresidencia(String comunaresidencia) {
        this.comunaresidencia = comunaresidencia;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resgistrousuario)) {
            return false;
        }
        Resgistrousuario other = (Resgistrousuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Resgistrousuario[ id=" + id + " ]";
    }
    
}
