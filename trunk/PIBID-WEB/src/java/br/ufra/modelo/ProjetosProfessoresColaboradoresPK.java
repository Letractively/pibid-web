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

/**
 *
 * @author marcos
 */
@Embeddable
public class ProjetosProfessoresColaboradoresPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "projetos_ID")
    private int projetosID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "professores_colaboradores_ID")
    private int professorescolaboradoresID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alunos_colaboradores_ID")
    private int alunoscolaboradoresID;

    public ProjetosProfessoresColaboradoresPK() {
    }

    public ProjetosProfessoresColaboradoresPK(int projetosID, int professorescolaboradoresID, int alunoscolaboradoresID) {
        this.projetosID = projetosID;
        this.professorescolaboradoresID = professorescolaboradoresID;
        this.alunoscolaboradoresID = alunoscolaboradoresID;
    }

    public int getProjetosID() {
        return projetosID;
    }

    public void setProjetosID(int projetosID) {
        this.projetosID = projetosID;
    }

    public int getProfessorescolaboradoresID() {
        return professorescolaboradoresID;
    }

    public void setProfessorescolaboradoresID(int professorescolaboradoresID) {
        this.professorescolaboradoresID = professorescolaboradoresID;
    }

    public int getAlunoscolaboradoresID() {
        return alunoscolaboradoresID;
    }

    public void setAlunoscolaboradoresID(int alunoscolaboradoresID) {
        this.alunoscolaboradoresID = alunoscolaboradoresID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projetosID;
        hash += (int) professorescolaboradoresID;
        hash += (int) alunoscolaboradoresID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosProfessoresColaboradoresPK)) {
            return false;
        }
        ProjetosProfessoresColaboradoresPK other = (ProjetosProfessoresColaboradoresPK) object;
        if (this.projetosID != other.projetosID) {
            return false;
        }
        if (this.professorescolaboradoresID != other.professorescolaboradoresID) {
            return false;
        }
        if (this.alunoscolaboradoresID != other.alunoscolaboradoresID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.rn.ProjetosProfessoresColaboradoresPK[ projetosID=" + projetosID + ", professorescolaboradoresID=" + professorescolaboradoresID + ", alunoscolaboradoresID=" + alunoscolaboradoresID + " ]";
    }
    
}
