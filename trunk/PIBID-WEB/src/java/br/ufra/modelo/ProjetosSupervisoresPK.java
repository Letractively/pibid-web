/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marcos
 */
@Embeddable
public class ProjetosSupervisoresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "projetos_ID")
    private int projetosID;
    @Basic(optional = false)
    @Column(name = "supervisores_ID")
    private int supervisoresID;

    public ProjetosSupervisoresPK() {
    }

    public ProjetosSupervisoresPK(int projetosID, int supervisoresID) {
        this.projetosID = projetosID;
        this.supervisoresID = supervisoresID;
    }

    public int getProjetosID() {
        return projetosID;
    }

    public void setProjetosID(int projetosID) {
        this.projetosID = projetosID;
    }

    public int getSupervisoresID() {
        return supervisoresID;
    }

    public void setSupervisoresID(int supervisoresID) {
        this.supervisoresID = supervisoresID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projetosID;
        hash += (int) supervisoresID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosSupervisoresPK)) {
            return false;
        }
        ProjetosSupervisoresPK other = (ProjetosSupervisoresPK) object;
        if (this.projetosID != other.projetosID) {
            return false;
        }
        if (this.supervisoresID != other.supervisoresID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.modelo.ProjetosSupervisoresPK[ projetosID=" + projetosID + ", supervisoresID=" + supervisoresID + " ]";
    }
    
}
