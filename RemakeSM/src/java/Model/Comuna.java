/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andyees
 */
@Entity
@Table(name = "comuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comuna.findAll", query = "SELECT c FROM Comuna c")
    , @NamedQuery(name = "Comuna.findByIdComuna", query = "SELECT c FROM Comuna c WHERE c.idComuna = :idComuna")
    , @NamedQuery(name = "Comuna.findByComuNombre", query = "SELECT c FROM Comuna c WHERE c.comuNombre = :comuNombre")
    , @NamedQuery(name = "Comuna.findByComuRegion", query = "SELECT c FROM Comuna c WHERE c.comuRegion = :comuRegion")})
public class Comuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComuna")
    private Integer idComuna;
    @Basic(optional = false)
    @Column(name = "comu_nombre")
    private String comuNombre;
    @Basic(optional = false)
    @Column(name = "comu_region")
    private String comuRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunaidComuna")
    private Collection<Usuario> usuarioCollection;

    public Comuna() {
    }

    public Comuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public Comuna(Integer idComuna, String comuNombre, String comuRegion) {
        this.idComuna = idComuna;
        this.comuNombre = comuNombre;
        this.comuRegion = comuRegion;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public String getComuNombre() {
        return comuNombre;
    }

    public void setComuNombre(String comuNombre) {
        this.comuNombre = comuNombre;
    }

    public String getComuRegion() {
        return comuRegion;
    }

    public void setComuRegion(String comuRegion) {
        this.comuRegion = comuRegion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComuna != null ? idComuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comuna)) {
            return false;
        }
        Comuna other = (Comuna) object;
        if ((this.idComuna == null && other.idComuna != null) || (this.idComuna != null && !this.idComuna.equals(other.idComuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Comuna[ idComuna=" + idComuna + " ]";
    }
    
}
