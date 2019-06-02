/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Pista.findAll", query = "SELECT p FROM Pista p"),
    @NamedQuery(name = "Pista.findByIdPista", query = "SELECT p FROM Pista p WHERE p.idPista = :idPista"),
    @NamedQuery(name = "Pista.findByNombre", query = "SELECT p FROM Pista p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pista.findByDuracion", query = "SELECT p FROM Pista p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "Pista.findByGenero", query = "SELECT p FROM Pista p WHERE p.genero = :genero"),
    @NamedQuery(name = "Pista.findByTipo", query = "SELECT p FROM Pista p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pista.findByLinkVideo", query = "SELECT p FROM Pista p WHERE p.linkVideo = :linkVideo"),
    @NamedQuery(name = "Pista.findByRutaArchivo", query = "SELECT p FROM Pista p WHERE p.rutaArchivo = :rutaArchivo")})
public class Pista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pista", nullable = false)
    private Integer idPista;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false)
    private int duracion;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String genero;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "link_video", nullable = false, length = 250)
    private String linkVideo;
    @Basic(optional = false)
    @Column(name = "ruta_archivo", nullable = false, length = 250)
    private String rutaArchivo;
    @ManyToMany(mappedBy = "pistaList")
    private List<Lista> listaList;
    @ManyToMany(mappedBy = "pistaList")
    private List<Historial> historialList;
    @JoinColumn(name = "album_id_album", referencedColumnName = "id_album", nullable = false)
    @ManyToOne(optional = false)
    private Album albumIdAlbum;
    @JoinColumn(name = "artista_id_artista", referencedColumnName = "id_artista", nullable = false)
    @ManyToOne(optional = false)
    private Artista artistaIdArtista;

    public Pista() {
    }

    public Pista(Integer idPista) {
        this.idPista = idPista;
    }

    public Pista(Integer idPista, String nombre, int duracion, String genero, String tipo, String linkVideo, String rutaArchivo) {
        this.idPista = idPista;
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.tipo = tipo;
        this.linkVideo = linkVideo;
        this.rutaArchivo = rutaArchivo;
    }

    public Integer getIdPista() {
        return idPista;
    }

    public void setIdPista(Integer idPista) {
        this.idPista = idPista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @XmlTransient
    public List<Lista> getListaList() {
        return listaList;
    }

    public void setListaList(List<Lista> listaList) {
        this.listaList = listaList;
    }

    @XmlTransient
    public List<Historial> getHistorialList() {
        return historialList;
    }

    public void setHistorialList(List<Historial> historialList) {
        this.historialList = historialList;
    }

    public Album getAlbumIdAlbum() {
        return albumIdAlbum;
    }

    public void setAlbumIdAlbum(Album albumIdAlbum) {
        this.albumIdAlbum = albumIdAlbum;
    }

    public Artista getArtistaIdArtista() {
        return artistaIdArtista;
    }

    public void setArtistaIdArtista(Artista artistaIdArtista) {
        this.artistaIdArtista = artistaIdArtista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPista != null ? idPista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pista)) {
            return false;
        }
        Pista other = (Pista) object;
        if ((this.idPista == null && other.idPista != null) || (this.idPista != null && !this.idPista.equals(other.idPista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucatolica.cl.ja.sgm.modelo.Pista[ idPista=" + idPista + " ]";
    }

}
