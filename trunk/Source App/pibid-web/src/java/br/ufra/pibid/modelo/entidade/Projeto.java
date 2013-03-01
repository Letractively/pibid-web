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
 * @author stelio
 */
@Entity
@Table(name = "projeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projeto.findAll", query = "SELECT p FROM Projeto p"),
    @NamedQuery(name = "Projeto.findById", query = "SELECT p FROM Projeto p WHERE p.id = :id"),
    @NamedQuery(name = "Projeto.findByTitulo", query = "SELECT p FROM Projeto p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Projeto.findByDataIni", query = "SELECT p FROM Projeto p WHERE p.dataIni = :dataIni"),
    @NamedQuery(name = "Projeto.findByDataFim", query = "SELECT p FROM Projeto p WHERE p.dataFim = :dataFim"),
    @NamedQuery(name = "Projeto.findBySituacao", query = "SELECT p FROM Projeto p WHERE p.situacao = :situacao")})
public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "data_ini")
    @Temporal(TemporalType.DATE)
    private Date dataIni;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Lob
    @Column(name = "apresentacao_proposta")
    private String apresentacaoProposta;
    @Lob
    @Column(name = "acoes_prevista")
    private String acoesPrevista;
    @Lob
    @Column(name = "resultados_pretendido")
    private String resultadosPretendido;
    @Column(name = "situacao")
    private String situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto")
    private List<Cronograma> cronogramaList;
    @JoinColumn(name = "instituicao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Instituicao instituicao;
    @JoinColumn(name = "coordenador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocenteEnsSuperior coordenador;
    @JoinColumn(name = "curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Curso curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto1")
    private List<AlunoColaborador> alunoColaboradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto1")
    private List<ProfessorColaborador> professorColaboradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto1")
    private List<Bolsista> bolsistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto1")
    private List<Supervisor> supervisorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projeto")
    private List<Atividade> atividadeList;

    public Projeto() {
    }

    public Projeto(Integer id) {
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

    public String getApresentacaoProposta() {
        return apresentacaoProposta;
    }

    public void setApresentacaoProposta(String apresentacaoProposta) {
        this.apresentacaoProposta = apresentacaoProposta;
    }

    public String getAcoesPrevista() {
        return acoesPrevista;
    }

    public void setAcoesPrevista(String acoesPrevista) {
        this.acoesPrevista = acoesPrevista;
    }

    public String getResultadosPretendido() {
        return resultadosPretendido;
    }

    public void setResultadosPretendido(String resultadosPretendido) {
        this.resultadosPretendido = resultadosPretendido;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public List<Cronograma> getCronogramaList() {
        return cronogramaList;
    }

    public void setCronogramaList(List<Cronograma> cronogramaList) {
        this.cronogramaList = cronogramaList;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public DocenteEnsSuperior getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(DocenteEnsSuperior coordenador) {
        this.coordenador = coordenador;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @XmlTransient
    public List<AlunoColaborador> getAlunoColaboradorList() {
        return alunoColaboradorList;
    }

    public void setAlunoColaboradorList(List<AlunoColaborador> alunoColaboradorList) {
        this.alunoColaboradorList = alunoColaboradorList;
    }

    @XmlTransient
    public List<ProfessorColaborador> getProfessorColaboradorList() {
        return professorColaboradorList;
    }

    public void setProfessorColaboradorList(List<ProfessorColaborador> professorColaboradorList) {
        this.professorColaboradorList = professorColaboradorList;
    }

    @XmlTransient
    public List<Bolsista> getBolsistaList() {
        return bolsistaList;
    }

    public void setBolsistaList(List<Bolsista> bolsistaList) {
        this.bolsistaList = bolsistaList;
    }

    @XmlTransient
    public List<Supervisor> getSupervisorList() {
        return supervisorList;
    }

    public void setSupervisorList(List<Supervisor> supervisorList) {
        this.supervisorList = supervisorList;
    }

    @XmlTransient
    public List<Atividade> getAtividadeList() {
        return atividadeList;
    }

    public void setAtividadeList(List<Atividade> atividadeList) {
        this.atividadeList = atividadeList;
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
        if (!(object instanceof Projeto)) {
            return false;
        }
        Projeto other = (Projeto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.Projeto[ id=" + id + " ]";
    }
    
}
