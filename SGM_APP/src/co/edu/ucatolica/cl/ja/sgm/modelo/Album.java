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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByIdAlbum", query = "SELECT a FROM Album a WHERE a.idAlbum = :idAlbum"),
    @NamedQuery(name = "Album.findByNombreDelAlbum", query = "SELECT a FROM Album a WHERE a.nombreDelAlbum = :nombreDelAlbum"),
    @NamedQuery(name = "Album.findByFechaLanzamiento", query = "SELECT a FROM Album a WHERE a.fechaLanzamiento = :fechaLanzamiento"),
    @NamedQuery(name = "Album.findByFechaGrabacion", query = "SELECT a FROM Album a WHERE a.fechaGrabacion = :fechaGrabacion"),
    @NamedQuery(name = "Album.findByDisquera", query = "SELECT a FROM Album a WHERE a.disquera = :disquera"),
    @NamedQuery(name = "Album.findByNumeroCanciones", query = "SELECT a FROM Album a WHERE a.numeroCanciones = :numeroCanciones"),
    @NamedQuery(name = "Album.findByTipoAlbum", query = "SELECT a FROM Album a WHERE a.tipoAlbum = :tipoAlbum")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_album", nullable = false)
    private Integer idAlbum;
    @Basic(optional = false)
    @Column(name = "nombre_del_album", nullable = false, length = 45)
    private String nombreDelAlbum;
    @Basic(optional = false)
    @Column(name = "fecha_lanzamiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaLanzamiento;
    @Basic(optional = false)
    @Column(name = "fecha_grabacion", nullable = false, length = 45)
    private String fechaGrabacion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String disquera;
    @Basic(optional = false)
    @Column(name = "numero_canciones", nullable = false)
    private int numeroCanciones;
    @Basic(optional = false)
    @Column(name = "tipo_album", nullable = false)
    private boolean tipoAlbum;
    @Lob
    private byte[] portada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumIdAlbum")
    private List<Pista> pistaList;

    public Album() {
    }

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Album(Integer idAlbum, String nombreDelAlbum, Date fechaLanzamiento, String fechaGrabacion, String disquera, int numeroCanciones, boolean tipoAlbum) {
        this.idAlbum = idAlbum;
        this.nombreDelAlbum = nombreDelAlbum;
        this.fechaLanzamiento = fechaLanzamiento;
        this.fechaGrabacion = fechaGrabacion;
        this.disquera = disquera;
        this.numeroCanciones = numeroCanciones;
        this.tipoAlbum = tipoAlbum;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreDelAlbum() {
        return nombreDelAlbum;
    }

    public void setNombreDelAlbum(String nombreDelAlbum) {
        this.nombreDelAlbum = nombreDelAlbum;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getFechaGrabacion() {
        return fechaGrabacion;
    }

    public void setFechaGrabacion(String fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public boolean getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(boolean tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    @XmlTransient
    public List<Pista> getPistaList() {
        return pistaList;
    }

    public void setPistaList(List<Pista> pistaList) {
        this.pistaList = pistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbum != null ? idAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idAlbum == null && other.idAlbum != null) || (this.idAlbum != null && !this.idAlbum.equals(other.idAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucatolica.cl.ja.sgm.modelo.Album[ idAlbum=" + idAlbum + " ]";
    }

}
