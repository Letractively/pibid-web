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
@Table(name = "aluno_colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoColaborador.findAll", query = "SELECT a FROM AlunoColaborador a"),
    @NamedQuery(name = "AlunoColaborador.findByProjeto", query = "SELECT a FROM AlunoColaborador a WHERE a.alunoColaboradorPK.projeto = :projeto"),
    @NamedQuery(name = "AlunoColaborador.findByDiscente", query = "SELECT a FROM AlunoColaborador a WHERE a.alunoColaboradorPK.discente = :discente"),
    @NamedQuery(name = "AlunoColaborador.findByDataEntrada", query = "SELECT a FROM AlunoColaborador a WHERE a.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "AlunoColaborador.findByDataSaida", query = "SELECT a FROM AlunoColaborador a WHERE a.dataSaida = :dataSaida")})
public class AlunoColaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoColaboradorPK alunoColaboradorPK;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "projeto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto1;
    @JoinColumn(name = "discente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discente discente1;

    public AlunoColaborador() {
    }

    public AlunoColaborador(AlunoColaboradorPK alunoColaboradorPK) {
        this.alunoColaboradorPK = alunoColaboradorPK;
    }

    public AlunoColaborador(int projeto, int discente) {
        this.alunoColaboradorPK = new AlunoColaboradorPK(projeto, discente);
    }

    public AlunoColaboradorPK getAlunoColaboradorPK() {
        return alunoColaboradorPK;
    }

    public void setAlunoColaboradorPK(AlunoColaboradorPK alunoColaboradorPK) {
        this.alunoColaboradorPK = alunoColaboradorPK;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
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
        hash += (alunoColaboradorPK != null ? alunoColaboradorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoColaborador)) {
            return false;
        }
        AlunoColaborador other = (AlunoColaborador) object;
        if ((this.alunoColaboradorPK == null && other.alunoColaboradorPK != null) || (this.alunoColaboradorPK != null && !this.alunoColaboradorPK.equals(other.alunoColaboradorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.AlunoColaborador[ alunoColaboradorPK=" + alunoColaboradorPK + " ]";
    }
    
}
