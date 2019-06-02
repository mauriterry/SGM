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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l"),
    @NamedQuery(name = "Lista.findByIdLista", query = "SELECT l FROM Lista l WHERE l.idLista = :idLista"),
    @NamedQuery(name = "Lista.findByNombreLista", query = "SELECT l FROM Lista l WHERE l.nombreLista = :nombreLista"),
    @NamedQuery(name = "Lista.findByDuracionTotal", query = "SELECT l FROM Lista l WHERE l.duracionTotal = :duracionTotal")})
public class Lista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lista", nullable = false)
    private Integer idLista;
    @Basic(optional = false)
    @Column(name = "nombre_lista", nullable = false, length = 45)
    private String nombreLista;
    @Column(name = "duracion_total", length = 45)
    private String duracionTotal;
    @JoinTable(name = "lista_has_pista", joinColumns = {
        @JoinColumn(name = "lista_id_lista", referencedColumnName = "id_lista", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "pista_id_pista", referencedColumnName = "id_pista", nullable = false)})
    @ManyToMany
    private List<Pista> pistaList;
    @JoinColumn(name = "usuario_nickname", referencedColumnName = "nickname", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioNickname;

    public Lista() {
    }

    public Lista(Integer idLista) {
        this.idLista = idLista;
    }

    public Lista(Integer idLista, String nombreLista) {
        this.idLista = idLista;
        this.nombreLista = nombreLista;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(String duracionTotal) {
        this.duracionTotal = duracionTotal;
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
        hash += (idLista != null ? idLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.idLista == null && other.idLista != null) || (this.idLista != null && !this.idLista.equals(other.idLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucatolica.cl.ja.sgm.modelo.Lista[ idLista=" + idLista + " ]";
    }

}
