/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "responsavel_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsavelAtividade.findAll", query = "SELECT r FROM ResponsavelAtividade r"),
    @NamedQuery(name = "ResponsavelAtividade.findByAtividade", query = "SELECT r FROM ResponsavelAtividade r WHERE r.responsavelAtividadePK.atividade = :atividade"),
    @NamedQuery(name = "ResponsavelAtividade.findByDiscente", query = "SELECT r FROM ResponsavelAtividade r WHERE r.responsavelAtividadePK.discente = :discente"),
    @NamedQuery(name = "ResponsavelAtividade.findByBolsista", query = "SELECT r FROM ResponsavelAtividade r WHERE r.responsavelAtividadePK.bolsista = :bolsista"),
    @NamedQuery(name = "ResponsavelAtividade.findByDocente", query = "SELECT r FROM ResponsavelAtividade r WHERE r.responsavelAtividadePK.docente = :docente"),
    @NamedQuery(name = "ResponsavelAtividade.findBySupervisor", query = "SELECT r FROM ResponsavelAtividade r WHERE r.responsavelAtividadePK.supervisor = :supervisor")})
public class ResponsavelAtividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsavelAtividadePK responsavelAtividadePK;
    @JoinColumn(name = "supervisor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DocenteEnsBasico docenteEnsBasico;
    @JoinColumn(name = "docente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DocenteEnsSuperior docenteEnsSuperior;
    @JoinColumn(name = "bolsista", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discente discente1;
    @JoinColumn(name = "discente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discente discente2;
    @JoinColumn(name = "atividade", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Atividade atividade1;

    public ResponsavelAtividade() {
    }

    public ResponsavelAtividade(ResponsavelAtividadePK responsavelAtividadePK) {
        this.responsavelAtividadePK = responsavelAtividadePK;
    }

    public ResponsavelAtividade(int atividade, int discente, int bolsista, int docente, int supervisor) {
        this.responsavelAtividadePK = new ResponsavelAtividadePK(atividade, discente, bolsista, docente, supervisor);
    }

    public ResponsavelAtividadePK getResponsavelAtividadePK() {
        return responsavelAtividadePK;
    }

    public void setResponsavelAtividadePK(ResponsavelAtividadePK responsavelAtividadePK) {
        this.responsavelAtividadePK = responsavelAtividadePK;
    }

    public DocenteEnsBasico getDocenteEnsBasico() {
        return docenteEnsBasico;
    }

    public void setDocenteEnsBasico(DocenteEnsBasico docenteEnsBasico) {
        this.docenteEnsBasico = docenteEnsBasico;
    }

    public DocenteEnsSuperior getDocenteEnsSuperior() {
        return docenteEnsSuperior;
    }

    public void setDocenteEnsSuperior(DocenteEnsSuperior docenteEnsSuperior) {
        this.docenteEnsSuperior = docenteEnsSuperior;
    }

    public Discente getDiscente1() {
        return discente1;
    }

    public void setDiscente1(Discente discente1) {
        this.discente1 = discente1;
    }

    public Discente getDiscente2() {
        return discente2;
    }

    public void setDiscente2(Discente discente2) {
        this.discente2 = discente2;
    }

    public Atividade getAtividade1() {
        return atividade1;
    }

    public void setAtividade1(Atividade atividade1) {
        this.atividade1 = atividade1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsavelAtividadePK != null ? responsavelAtividadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsavelAtividade)) {
            return false;
        }
        ResponsavelAtividade other = (ResponsavelAtividade) object;
        if ((this.responsavelAtividadePK == null && other.responsavelAtividadePK != null) || (this.responsavelAtividadePK != null && !this.responsavelAtividadePK.equals(other.responsavelAtividadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.ResponsavelAtividade[ responsavelAtividadePK=" + responsavelAtividadePK + " ]";
    }
    
}
