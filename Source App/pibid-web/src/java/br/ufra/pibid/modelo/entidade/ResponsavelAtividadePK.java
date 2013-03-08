package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marcos
 */
@Embeddable
public class ResponsavelAtividadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "atividade")
    private int atividade;
    @Basic(optional = false)
    @Column(name = "discente")
    private int discente;
    @Basic(optional = false)
    @Column(name = "bolsista")
    private int bolsista;
    @Basic(optional = false)
    @Column(name = "docente")
    private int docente;
    @Basic(optional = false)
    @Column(name = "supervisor")
    private int supervisor;

    public ResponsavelAtividadePK() {
    }

    public ResponsavelAtividadePK(int atividade, int discente, int bolsista, int docente, int supervisor) {
        this.atividade = atividade;
        this.discente = discente;
        this.bolsista = bolsista;
        this.docente = docente;
        this.supervisor = supervisor;
    }

    public int getAtividade() {
        return atividade;
    }

    public void setAtividade(int atividade) {
        this.atividade = atividade;
    }

    public int getDiscente() {
        return discente;
    }

    public void setDiscente(int discente) {
        this.discente = discente;
    }

    public int getBolsista() {
        return bolsista;
    }

    public void setBolsista(int bolsista) {
        this.bolsista = bolsista;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) atividade;
        hash += (int) discente;
        hash += (int) bolsista;
        hash += (int) docente;
        hash += (int) supervisor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsavelAtividadePK)) {
            return false;
        }
        ResponsavelAtividadePK other = (ResponsavelAtividadePK) object;
        if (this.atividade != other.atividade) {
            return false;
        }
        if (this.discente != other.discente) {
            return false;
        }
        if (this.bolsista != other.bolsista) {
            return false;
        }
        if (this.docente != other.docente) {
            return false;
        }
        if (this.supervisor != other.supervisor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.ResponsavelAtividadePK[ atividade=" + atividade + ", discente=" + discente + ", bolsista=" + bolsista + ", docente=" + docente + ", supervisor=" + supervisor + " ]";
    }
    
}
