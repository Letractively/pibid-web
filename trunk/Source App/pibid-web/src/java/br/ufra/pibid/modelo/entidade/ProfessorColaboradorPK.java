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
public class ProfessorColaboradorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "projeto")
    private int projeto;
    @Basic(optional = false)
    @Column(name = "docente")
    private int docente;

    public ProfessorColaboradorPK() {
    }

    public ProfessorColaboradorPK(int projeto, int docente) {
        this.projeto = projeto;
        this.docente = docente;
    }

    public int getProjeto() {
        return projeto;
    }

    public void setProjeto(int projeto) {
        this.projeto = projeto;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projeto;
        hash += (int) docente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessorColaboradorPK)) {
            return false;
        }
        ProfessorColaboradorPK other = (ProfessorColaboradorPK) object;
        if (this.projeto != other.projeto) {
            return false;
        }
        if (this.docente != other.docente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.ProfessorColaboradorPK[ projeto=" + projeto + ", docente=" + docente + " ]";
    }
    
}
