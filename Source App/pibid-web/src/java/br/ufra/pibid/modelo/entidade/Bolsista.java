/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "bolsista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bolsista.findAll", query = "SELECT b FROM Bolsista b"),
    @NamedQuery(name = "Bolsista.findByProjeto", query = "SELECT b FROM Bolsista b WHERE b.bolsistaPK.projeto = :projeto"),
    @NamedQuery(name = "Bolsista.findByDiscente", query = "SELECT b FROM Bolsista b WHERE b.bolsistaPK.discente = :discente"),
    @NamedQuery(name = "Bolsista.findByDataIni", query = "SELECT b FROM Bolsista b WHERE b.dataIni = :dataIni"),
    @NamedQuery(name = "Bolsista.findByDataFim", query = "SELECT b FROM Bolsista b WHERE b.dataFim = :dataFim")})
public class Bolsista implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BolsistaPK bolsistaPK;
    @Column(name = "data_ini")
    @Temporal(TemporalType.DATE)
    private Date dataIni;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "projeto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto1;
    @JoinColumn(name = "discente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discente discente1;

    public Bolsista() {
    }

    public Bolsista(BolsistaPK bolsistaPK) {
        this.bolsistaPK = bolsistaPK;
    }

    public Bolsista(int projeto, int discente) {
        this.bolsistaPK = new BolsistaPK(projeto, discente);
    }

    public BolsistaPK getBolsistaPK() {
        return bolsistaPK;
    }

    public void setBolsistaPK(BolsistaPK bolsistaPK) {
        this.bolsistaPK = bolsistaPK;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Projeto getProjeto1() {
        return projeto1;
    }

    public void setProjeto1(Projeto projeto1) {
        this.projeto1 = projeto1;
    }

    public Discente getDiscente1() {
        return discente1;
    }

    public void setDiscente1(Discente discente1) {
        this.discente1 = discente1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bolsistaPK != null ? bolsistaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bolsista)) {
            return false;
        }
        Bolsista other = (Bolsista) object;
        if ((this.bolsistaPK == null && other.bolsistaPK != null) || (this.bolsistaPK != null && !this.bolsistaPK.equals(other.bolsistaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.Bolsista[ bolsistaPK=" + bolsistaPK + " ]";
    }
    
}
