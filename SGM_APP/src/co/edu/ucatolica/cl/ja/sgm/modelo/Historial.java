/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aasanchez
 */
@Entity
@Table(catalog = "sgmdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h"),
    @NamedQuery(name = "Historial.findByIdHistorial", query = "SELECT h FROM Historial h WHERE h.idHistorial = :idHistorial"),
    @NamedQuery(name = "Historial.findByNumeroDePistas", query = "SELECT h FROM Historial h WHERE h.numeroDePistas = :numeroDePistas"),
    @NamedQuery(name = "Historial.findByFechaCreacion", query = "SELECT h FROM Historial h WHERE h.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Historial.findByFechaModificacion", query = "SELECT h FROM Historial h WHERE h.fechaModificacion = :fechaModificacion")})
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial", nullable = false)
    private Integer idHistorial;
    @Basic(optional = false)
    @Column(name = "numero_de_pistas", nullable = false)
    private int numeroDePistas;
    @Basic(optional = false)
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_modificacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @JoinTable(name = "pista_has_historial", joinColumns = {
        @JoinColumn(name = "historial_id_historial", referencedColumnName = "id_historial", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "pista_id_pista", referencedColumnName = "id_pista", nullable = false)})
    @ManyToMany
    private List<Pista> pistaList;
    @JoinColumn(name = "usuario_nickname", referencedColumnName = "nickname", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioNickname;

    public Historial() {
    }

    public Historial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Historial(Integer idHistorial, int numeroDePistas, Date fechaCreacion, Date fechaModificacion) {
        this.idHistorial = idHistorial;
        this.numeroDePistas = numeroDePistas;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getNumeroDePistas() {
        return numeroDePistas;
    }

    public void setNumeroDePistas(int numeroDePistas) {
        this.numeroDePistas = numeroDePistas;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<Pista> getPistaList() {
        return pistaList;
    }

    public void setPistaList(List<Pista> pistaList) {
        this.pistaList = pistaList;
    }

    public Usuario getUsuarioNickname() {
        return usuarioNickname;
    }

    public void setUsuarioNickname(Usuario usuarioNickname) {
        this.usuarioNickname = usuarioNickname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucatolica.cl.ja.sgm.modelo.Historial[ idHistorial=" + idHistorial + " ]";
    }

}
