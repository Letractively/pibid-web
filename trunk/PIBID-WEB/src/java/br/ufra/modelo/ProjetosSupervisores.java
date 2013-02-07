/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "projetos_supervisores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjetosSupervisores.findAll", query = "SELECT p FROM ProjetosSupervisores p"),
    @NamedQuery(name = "ProjetosSupervisores.findByProjetosID", query = "SELECT p FROM ProjetosSupervisores p WHERE p.projetosSupervisoresPK.projetosID = :projetosID"),
    @NamedQuery(name = "ProjetosSupervisores.findBySupervisoresID", query = "SELECT p FROM ProjetosSupervisores p WHERE p.projetosSupervisoresPK.supervisoresID = :supervisoresID"),
    @NamedQuery(name = "ProjetosSupervisores.findByDataInicio", query = "SELECT p FROM ProjetosSupervisores p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "ProjetosSupervisores.findByDataFim", query = "SELECT p FROM ProjetosSupervisores p WHERE p.dataFim = :dataFim")})
public class ProjetosSupervisores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjetosSupervisoresPK projetosSupervisoresPK;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @JoinColumn(name = "supervisores_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Supervisores supervisores;
    @JoinColumn(name = "projetos_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projetos projetos;

    public ProjetosSupervisores() {
    }

    public ProjetosSupervisores(ProjetosSupervisoresPK projetosSupervisoresPK) {
        this.projetosSupervisoresPK = projetosSupervisoresPK;
    }

    public ProjetosSupervisores(int projetosID, int supervisoresID) {
        this.projetosSupervisoresPK = new ProjetosSupervisoresPK(projetosID, supervisoresID);
    }

    public ProjetosSupervisoresPK getProjetosSupervisoresPK() {
        return projetosSupervisoresPK;
    }

    public void setProjetosSupervisoresPK(ProjetosSupervisoresPK projetosSupervisoresPK) {
        this.projetosSupervisoresPK = projetosSupervisoresPK;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Supervisores getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(Supervisores supervisores) {
        this.supervisores = supervisores;
    }

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projetosSupervisoresPK != null ? projetosSupervisoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosSupervisores)) {
            return false;
        }
        ProjetosSupervisores other = (ProjetosSupervisores) object;
        if ((this.projetosSupervisoresPK == null && other.projetosSupervisoresPK != null) || (this.projetosSupervisoresPK != null && !this.projetosSupervisoresPK.equals(other.projetosSupervisoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.rn.ProjetosSupervisores[ projetosSupervisoresPK=" + projetosSupervisoresPK + " ]";
    }
    
}
