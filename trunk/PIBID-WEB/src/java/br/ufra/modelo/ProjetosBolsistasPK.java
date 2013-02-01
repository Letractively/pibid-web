/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author marcos
 */
@Embeddable
public class ProjetosBolsistasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "projetos_ID")
    private int projetosID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bolsistas_matricula")
    private String bolsistasMatricula;

    public ProjetosBolsistasPK() {
    }

    public ProjetosBolsistasPK(int projetosID, String bolsistasMatricula) {
        this.projetosID = projetosID;
        this.bolsistasMatricula = bolsistasMatricula;
    }

    public int getProjetosID() {
        return projetosID;
    }

    public void setProjetosID(int projetosID) {
        this.projetosID = projetosID;
    }

    public String getBolsistasMatricula() {
        return bolsistasMatricula;
    }

    public void setBolsistasMatricula(String bolsistasMatricula) {
        this.bolsistasMatricula = bolsistasMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projetosID;
        hash += (bolsistasMatricula != null ? bolsistasMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosBolsistasPK)) {
            return false;
        }
        ProjetosBolsistasPK other = (ProjetosBolsistasPK) object;
        if (this.projetosID != other.projetosID) {
            return false;
        }
        if ((this.bolsistasMatricula == null && other.bolsistasMatricula != null) || (this.bolsistasMatricula != null && !this.bolsistasMatricula.equals(other.bolsistasMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.modelo.ProjetosBolsistasPK[ projetosID=" + projetosID + ", bolsistasMatricula=" + bolsistasMatricula + " ]";
    }
    
}
