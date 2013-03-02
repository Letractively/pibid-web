/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findById", query = "SELECT a FROM Atividade a WHERE a.id = :id"),
    @NamedQuery(name = "Atividade.findByTitulo", query = "SELECT a FROM Atividade a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Atividade.findByCadastro", query = "SELECT a FROM Atividade a WHERE a.cadastro = :cadastro"),
    @NamedQuery(name = "Atividade.findByDataIni", query = "SELECT a FROM Atividade a WHERE a.dataIni = :dataIni"),
    @NamedQuery(name = "Atividade.findByDataFim", query = "SELECT a FROM Atividade a WHERE a.dataFim = :dataFim"),
    @NamedQuery(name = "Atividade.findByDataConclusao", query = "SELECT a FROM Atividade a WHERE a.dataConclusao = :dataConclusao")})
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "cadastro")
    @Temporal(TemporalType.DATE)
    private Date cadastro;
    @Basic(optional = false)
    @Column(name = "data_ini")
    @Temporal(TemporalType.DATE)
    private Date dataIni;
    @Basic(optional = false)
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Basic(optional = false)
    @Column(name = "data_conclusao")
    @Temporal(TemporalType.DATE)
    private Date dataConclusao;
    @Basic(optional = false)
    @Lob
    @Column(name = "obs_gerais")
    private String obsGerais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atividade1")
    private List<ResponsavelAtividade> responsavelAtividadeList;
    @JoinColumn(name = "projeto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Projeto projeto;

    public Atividade() {
    }

    public Atividade(Integer id) {
        this.id = id;
    }

    public Atividade(Integer id, String titulo, String descricao, Date cadastro, Date dataIni, Date dataFim, Date dataConclusao, String obsGerais) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cadastro = cadastro;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
        this.dataConclusao = dataConclusao;
        this.obsGerais = obsGerais;
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

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
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

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getObsGerais() {
        return obsGerais;
    }

    public void setObsGerais(String obsGerais) {
        this.obsGerais = obsGerais;
    }

    @XmlTransient
    public List<ResponsavelAtividade> getResponsavelAtividadeList() {
        return responsavelAtividadeList;
    }

    public void setResponsavelAtividadeList(List<ResponsavelAtividade> responsavelAtividadeList) {
        this.responsavelAtividadeList = responsavelAtividadeList;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
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
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.Atividade[ id=" + id + " ]";
    }
    
}
