/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stelio
 */
@Entity
@Table(name = "supervisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s"),
    @NamedQuery(name = "Supervisor.findBySupervisor", query = "SELECT s FROM Supervisor s WHERE s.supervisorPK.supervisor = :supervisor"),
    @NamedQuery(name = "Supervisor.findByProjeto", query = "SELECT s FROM Supervisor s WHERE s.supervisorPK.projeto = :projeto"),
    @NamedQuery(name = "Supervisor.findByDataIni", query = "SELECT s FROM Supervisor s WHERE s.dataIni = :dataIni"),
    @NamedQuery(name = "Supervisor.findByDateFim", query = "SELECT s FROM Supervisor s WHERE s.dateFim = :dateFim")})
public class Supervisor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupervisorPK supervisorPK;
    @Basic(optional = false)
    @Column(name = "data_ini")
    @Temporal(TemporalType.DATE)
    private Date dataIni;
    @Column(name = "date_fim")
    @Temporal(TemporalType.DATE)
    private Date dateFim;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "projeto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto1;
    @JoinColumn(name = "supervisor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DocenteEnsBasico docenteEnsBasico;

    public Supervisor() {
    }

    public Supervisor(SupervisorPK supervisorPK) {
        this.supervisorPK = supervisorPK;
    }

    public Supervisor(SupervisorPK supervisorPK, Date dataIni) {
        this.supervisorPK = supervisorPK;
        this.dataIni = dataIni;
    }

    public Supervisor(int supervisor, int projeto) {
        this.supervisorPK = new SupervisorPK(supervisor, projeto);
    }

    public SupervisorPK getSupervisorPK() {
        return supervisorPK;
    }

    public void setSupervisorPK(SupervisorPK supervisorPK) {
        this.supervisorPK = supervisorPK;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDateFim() {
        return dateFim;
    }

    public void setDateFim(Date dateFim) {
        this.dateFim = dateFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Projeto getProjeto1() {
        return projeto1;
    }

    public void setProjeto1(Projeto projeto1) {
        this.projeto1 = projeto1;
    }

    public DocenteEnsBasico getDocenteEnsBasico() {
        return docenteEnsBasico;
    }

    public void setDocenteEnsBasico(DocenteEnsBasico docenteEnsBasico) {
        this.docenteEnsBasico = docenteEnsBasico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supervisorPK != null ? supervisorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.supervisorPK == null && other.supervisorPK != null) || (this.supervisorPK != null && !this.supervisorPK.equals(other.supervisorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.Supervisor[ supervisorPK=" + supervisorPK + " ]";
    }
    
}
