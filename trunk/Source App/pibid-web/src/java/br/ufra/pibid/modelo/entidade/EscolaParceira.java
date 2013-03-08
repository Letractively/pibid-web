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
@Table(name = "escola_parceira")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscolaParceira.findAll", query = "SELECT e FROM EscolaParceira e"),
    @NamedQuery(name = "EscolaParceira.findByProjeto", query = "SELECT e FROM EscolaParceira e WHERE e.escolaParceiraPK.projeto = :projeto"),
    @NamedQuery(name = "EscolaParceira.findByInstituicaoEnsBasico", query = "SELECT e FROM EscolaParceira e WHERE e.escolaParceiraPK.instituicaoEnsBasico = :instituicaoEnsBasico"),
    @NamedQuery(name = "EscolaParceira.findByDataIni", query = "SELECT e FROM EscolaParceira e WHERE e.dataIni = :dataIni"),
    @NamedQuery(name = "EscolaParceira.findByDataFim", query = "SELECT e FROM EscolaParceira e WHERE e.dataFim = :dataFim")})
public class EscolaParceira implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EscolaParceiraPK escolaParceiraPK;
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
    @JoinColumn(name = "instituicao_ens_basico", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private InstituicaoEnsBasico instituicaoEnsBasico1;

    public EscolaParceira() {
    }

    public EscolaParceira(EscolaParceiraPK escolaParceiraPK) {
        this.escolaParceiraPK = escolaParceiraPK;
    }

    public EscolaParceira(int projeto, int instituicaoEnsBasico) {
        this.escolaParceiraPK = new EscolaParceiraPK(projeto, instituicaoEnsBasico);
    }

    public EscolaParceiraPK getEscolaParceiraPK() {
        return escolaParceiraPK;
    }

    public void setEscolaParceiraPK(EscolaParceiraPK escolaParceiraPK) {
        this.escolaParceiraPK = escolaParceiraPK;
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

    public InstituicaoEnsBasico getInstituicaoEnsBasico1() {
        return instituicaoEnsBasico1;
    }

    public void setInstituicaoEnsBasico1(InstituicaoEnsBasico instituicaoEnsBasico1) {
        this.instituicaoEnsBasico1 = instituicaoEnsBasico1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escolaParceiraPK != null ? escolaParceiraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscolaParceira)) {
            return false;
        }
        EscolaParceira other = (EscolaParceira) object;
        if ((this.escolaParceiraPK == null && other.escolaParceiraPK != null) || (this.escolaParceiraPK != null && !this.escolaParceiraPK.equals(other.escolaParceiraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.EscolaParceira[ escolaParceiraPK=" + escolaParceiraPK + " ]";
    }
    
}
