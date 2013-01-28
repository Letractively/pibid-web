/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

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
 * @author victorperes
 */
@Entity
@Table(name = "projetos_escolas_parceiras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjetosEscolasParceiras.findAll", query = "SELECT p FROM ProjetosEscolasParceiras p"),
    @NamedQuery(name = "ProjetosEscolasParceiras.findByProjetosID", query = "SELECT p FROM ProjetosEscolasParceiras p WHERE p.projetosEscolasParceirasPK.projetosID = :projetosID"),
    @NamedQuery(name = "ProjetosEscolasParceiras.findByEscolasparceirasID", query = "SELECT p FROM ProjetosEscolasParceiras p WHERE p.projetosEscolasParceirasPK.escolasparceirasID = :escolasparceirasID")})
public class ProjetosEscolasParceiras implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjetosEscolasParceirasPK projetosEscolasParceirasPK;
    @JoinColumn(name = "projetos_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projetos projetos;
    @JoinColumn(name = "escolas_parceiras_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EscolasParceiras escolasParceiras;

    public ProjetosEscolasParceiras() {
    }

    public ProjetosEscolasParceiras(ProjetosEscolasParceirasPK projetosEscolasParceirasPK) {
        this.projetosEscolasParceirasPK = projetosEscolasParceirasPK;
    }

    public ProjetosEscolasParceiras(int projetosID, int escolasparceirasID) {
        this.projetosEscolasParceirasPK = new ProjetosEscolasParceirasPK(projetosID, escolasparceirasID);
    }

    public ProjetosEscolasParceirasPK getProjetosEscolasParceirasPK() {
        return projetosEscolasParceirasPK;
    }

    public void setProjetosEscolasParceirasPK(ProjetosEscolasParceirasPK projetosEscolasParceirasPK) {
        this.projetosEscolasParceirasPK = projetosEscolasParceirasPK;
    }

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }

    public EscolasParceiras getEscolasParceiras() {
        return escolasParceiras;
    }

    public void setEscolasParceiras(EscolasParceiras escolasParceiras) {
        this.escolasParceiras = escolasParceiras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projetosEscolasParceirasPK != null ? projetosEscolasParceirasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosEscolasParceiras)) {
            return false;
        }
        ProjetosEscolasParceiras other = (ProjetosEscolasParceiras) object;
        if ((this.projetosEscolasParceirasPK == null && other.projetosEscolasParceirasPK != null) || (this.projetosEscolasParceirasPK != null && !this.projetosEscolasParceirasPK.equals(other.projetosEscolasParceirasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.modelo.ProjetosEscolasParceiras[ projetosEscolasParceirasPK=" + projetosEscolasParceirasPK + " ]";
    }
    
}
