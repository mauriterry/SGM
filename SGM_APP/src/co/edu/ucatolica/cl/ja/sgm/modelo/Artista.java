/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.cl.ja.sgm.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a"),
    @NamedQuery(name = "Artista.findByIdArtista", query = "SELECT a FROM Artista a WHERE a.idArtista = :idArtista"),
    @NamedQuery(name = "Artista.findByNombre", query = "SELECT a FROM Artista a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Artista.findBySexo", query = "SELECT a FROM Artista a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Artista.findByEdad", query = "SELECT a FROM Artista a WHERE a.edad = :edad"),
    @NamedQuery(name = "Artista.findByNacionalidad", query = "SELECT a FROM Artista a WHERE a.nacionalidad = :nacionalidad")})
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_artista", nullable = false)
    private Integer idArtista;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String sexo;
    @Basic(optional = false)
    @Column(nullable = false)
    private int edad;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistaIdArtista")
    private List<Pista> pistaList;

    public Artista() {
    }

    public Artista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public Artista(Integer idArtista, String nombre, String sexo, int edad, String nacionalidad) {
        this.idArtista = idArtista;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
        hash += (idArtista != null ? idArtista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.idArtista == null && other.idArtista != null) || (this.idArtista != null && !this.idArtista.equals(other.idArtista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucatolica.cl.ja.sgm.modelo.Artista[ idArtista=" + idArtista + " ]";
    }

}
