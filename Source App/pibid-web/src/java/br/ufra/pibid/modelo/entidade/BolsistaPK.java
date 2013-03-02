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
 * @author marcos
 */
@Embeddable
public class BolsistaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "projeto")
    private int projeto;
    @Basic(optional = false)
    @Column(name = "discente")
    private int discente;

    public BolsistaPK() {
    }

    public BolsistaPK(int projeto, int discente) {
        this.projeto = projeto;
        this.discente = discente;
    }

    public int getProjeto() {
        return projeto;
    }

    public void setProjeto(int projeto) {
        this.projeto = projeto;
    }

    public int getDiscente() {
        return discente;
    }

    public void setDiscente(int discente) {
        this.discente = discente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projeto;
        hash += (int) discente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BolsistaPK)) {
            return false;
        }
        BolsistaPK other = (BolsistaPK) object;
        if (this.projeto != other.projeto) {
            return false;
        }
        if (this.discente != other.discente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.BolsistaPK[ projeto=" + projeto + ", discente=" + discente + " ]";
    }
    
}
