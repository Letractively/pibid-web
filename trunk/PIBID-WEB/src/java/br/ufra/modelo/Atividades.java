/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "atividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividades.findAll", query = "SELECT a FROM Atividades a"),
    @NamedQuery(name = "Atividades.findById", query = "SELECT a FROM Atividades a WHERE a.id = :id"),
    @NamedQuery(name = "Atividades.findByTitulo", query = "SELECT a FROM Atividades a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Atividades.findByDescricao", query = "SELECT a FROM Atividades a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Atividades.findByDataCadastro", query = "SELECT a FROM Atividades a WHERE a.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Atividades.findByDataPrevisaoInicio", query = "SELECT a FROM Atividades a WHERE a.dataPrevisaoInicio = :dataPrevisaoInicio"),
    @NamedQuery(name = "Atividades.findByDataPrevisaoFim", query = "SELECT a FROM Atividades a WHERE a.dataPrevisaoFim = :dataPrevisaoFim"),
    @NamedQuery(name = "Atividades.findByDataEfetivaConclusao", query = "SELECT a FROM Atividades a WHERE a.dataEfetivaConclusao = :dataEfetivaConclusao"),
    @NamedQuery(name = "Atividades.findBySituacao", query = "SELECT a FROM Atividades a WHERE a.situacao = :situacao"),
    @NamedQuery(name = "Atividades.findByObsGerais", query = "SELECT a FROM Atividades a WHERE a.obsGerais = :obsGerais")})
public class Atividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 45)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "data_previsao_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrevisaoInicio;
    @Column(name = "data_previsao_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrevisaoFim;
    @Column(name = "data_efetiva_conclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEfetivaConclusao;
    @Size(max = 45)
    @Column(name = "situacao")
    private String situacao;
    @Size(max = 45)
    @Column(name = "obs_gerais")
    private String obsGerais;
    @JoinColumn(name = "projetos_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Projetos projetosID;

    public Atividades() {
    }

    public Atividades(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataPrevisaoInicio() {
        return dataPrevisaoInicio;
    }

    public void setDataPrevisaoInicio(Date dataPrevisaoInicio) {
        this.dataPrevisaoInicio = dataPrevisaoInicio;
    }

    public Date getDataPrevisaoFim() {
        return dataPrevisaoFim;
    }

    public void setDataPrevisaoFim(Date dataPrevisaoFim) {
        this.dataPrevisaoFim = dataPrevisaoFim;
    }

    public Date getDataEfetivaConclusao() {
        return dataEfetivaConclusao;
    }

    public void setDataEfetivaConclusao(Date dataEfetivaConclusao) {
        this.dataEfetivaConclusao = dataEfetivaConclusao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObsGerais() {
        return obsGerais;
    }

    public void setObsGerais(String obsGerais) {
        this.obsGerais = obsGerais;
    }

    public Projetos getProjetosID() {
        return projetosID;
    }

    public void setProjetosID(Projetos projetosID) {
        this.projetosID = projetosID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividades)) {
            return false;
        }
        Atividades other = (Atividades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.modelo.Atividades[ id=" + id + " ]";
    }
    
}
