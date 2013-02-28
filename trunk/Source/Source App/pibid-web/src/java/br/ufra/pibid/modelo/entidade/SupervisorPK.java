/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author stelio
 */
@Embeddable
public class SupervisorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "supervisor")
    private int supervisor;
    @Basic(optional = false)
    @Column(name = "projeto")
    private int projeto;

    public SupervisorPK() {
    }

    public SupervisorPK(int supervisor, int projeto) {
        this.supervisor = supervisor;
        this.projeto = projeto;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public int getProjeto() {
        return projeto;
    }

    public void setProjeto(int projeto) {
        this.projeto = projeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) supervisor;
        hash += (int) projeto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupervisorPK)) {
            return false;
        }
        SupervisorPK other = (SupervisorPK) object;
        if (this.supervisor != other.supervisor) {
            return false;
        }
        if (this.projeto != other.projeto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.SupervisorPK[ supervisor=" + supervisor + ", projeto=" + projeto + " ]";
    }
    
}
