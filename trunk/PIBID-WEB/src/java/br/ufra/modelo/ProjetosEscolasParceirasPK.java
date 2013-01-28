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
 * @author victorperes
 */
@Embeddable
public class ProjetosEscolasParceirasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "projetos_ID")
    private int projetosID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escolas_parceiras_ID")
    private int escolasparceirasID;

    public ProjetosEscolasParceirasPK() {
    }

    public ProjetosEscolasParceirasPK(int projetosID, int escolasparceirasID) {
        this.projetosID = projetosID;
        this.escolasparceirasID = escolasparceirasID;
    }

    public int getProjetosID() {
        return projetosID;
    }

    public void setProjetosID(int projetosID) {
        this.projetosID = projetosID;
    }

    public int getEscolasparceirasID() {
        return escolasparceirasID;
    }

    public void setEscolasparceirasID(int escolasparceirasID) {
        this.escolasparceirasID = escolasparceirasID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projetosID;
        hash += (int) escolasparceirasID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosEscolasParceirasPK)) {
            return false;
        }
        ProjetosEscolasParceirasPK other = (ProjetosEscolasParceirasPK) object;
        if (this.projetosID != other.projetosID) {
            return false;
        }
        if (this.escolasparceirasID != other.escolasparceirasID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.modelo.ProjetosEscolasParceirasPK[ projetosID=" + projetosID + ", escolasparceirasID=" + escolasparceirasID + " ]";
    }
    
}
