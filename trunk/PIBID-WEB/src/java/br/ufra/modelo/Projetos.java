/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "projetos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projetos.findAll", query = "SELECT p FROM Projetos p"),
    @NamedQuery(name = "Projetos.findById", query = "SELECT p FROM Projetos p WHERE p.id = :id"),
    @NamedQuery(name = "Projetos.findByNome", query = "SELECT p FROM Projetos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Projetos.findByTituloProjeto", query = "SELECT p FROM Projetos p WHERE p.tituloProjeto = :tituloProjeto"),
    @NamedQuery(name = "Projetos.findByDataConclusao", query = "SELECT p FROM Projetos p WHERE p.dataConclusao = :dataConclusao"),
    @NamedQuery(name = "Projetos.findByCurso", query = "SELECT p FROM Projetos p WHERE p.curso = :curso"),
    @NamedQuery(name = "Projetos.findByNomeCoordenador", query = "SELECT p FROM Projetos p WHERE p.nomeCoordenador = :nomeCoordenador"),
    @NamedQuery(name = "Projetos.findByTelefoneResidencialCoordenador", query = "SELECT p FROM Projetos p WHERE p.telefoneResidencialCoordenador = :telefoneResidencialCoordenador"),
    @NamedQuery(name = "Projetos.findByTelefoneCelularCoordenador", query = "SELECT p FROM Projetos p WHERE p.telefoneCelularCoordenador = :telefoneCelularCoordenador"),
    @NamedQuery(name = "Projetos.findByEmailPrincipalCoordenador", query = "SELECT p FROM Projetos p WHERE p.emailPrincipalCoordenador = :emailPrincipalCoordenador"),
    @NamedQuery(name = "Projetos.findByEmailSecundarioCoordenador", query = "SELECT p FROM Projetos p WHERE p.emailSecundarioCoordenador = :emailSecundarioCoordenador"),
    @NamedQuery(name = "Projetos.findByCurriculoLattesCoordenador", query = "SELECT p FROM Projetos p WHERE p.curriculoLattesCoordenador = :curriculoLattesCoordenador"),
    @NamedQuery(name = "Projetos.findByApresentacaoProposta", query = "SELECT p FROM Projetos p WHERE p.apresentacaoProposta = :apresentacaoProposta"),
    @NamedQuery(name = "Projetos.findByAcoesPrevistas", query = "SELECT p FROM Projetos p WHERE p.acoesPrevistas = :acoesPrevistas"),
    @NamedQuery(name = "Projetos.findByResultadosPretendidos", query = "SELECT p FROM Projetos p WHERE p.resultadosPretendidos = :resultadosPretendidos"),
    @NamedQuery(name = "Projetos.findByCronograma", query = "SELECT p FROM Projetos p WHERE p.cronograma = :cronograma"),
    @NamedQuery(name = "Projetos.findBySituacao", query = "SELECT p FROM Projetos p WHERE p.situacao = :situacao")})
public class Projetos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "titulo_projeto")
    private String tituloProjeto;
    @Column(name = "data_conclusao")
    @Temporal(TemporalType.DATE)
    private Date dataConclusao;
    @Column(name = "curso")
    private String curso;
    @Column(name = "nome_coordenador")
    private String nomeCoordenador;
    @Column(name = "telefone_residencial_coordenador")
    private String telefoneResidencialCoordenador;
    @Column(name = "telefone_celular_coordenador")
    private String telefoneCelularCoordenador;
    @Column(name = "email_principal_coordenador")
    private String emailPrincipalCoordenador;
    @Column(name = "email_secundario_coordenador")
    private String emailSecundarioCoordenador;
    @Column(name = "curriculo_lattes_coordenador")
    private String curriculoLattesCoordenador;
    @Column(name = "apresentacao_proposta")
    private String apresentacaoProposta;
    @Column(name = "acoes_previstas")
    private String acoesPrevistas;
    @Column(name = "resultados_pretendidos")
    private String resultadosPretendidos;
    @Column(name = "cronograma")
    private String cronograma;
    @Basic(optional = false)
    @Column(name = "situacao")
    private boolean situacao;
    @JoinTable(name = "projetos_has_supervisores", joinColumns = {
        @JoinColumn(name = "projetos_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "supervisores_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Supervisores> supervisoresList;
    @JoinTable(name = "projetos_has_bolsistas", joinColumns = {
        @JoinColumn(name = "projetos_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "bolsistas_matricula", referencedColumnName = "matricula")})
    @ManyToMany
    private List<Bolsistas> bolsistasList;
    @JoinTable(name = "projetos_has_professores_colaboradores", joinColumns = {
        @JoinColumn(name = "projetos_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "professores_colaboradores_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<ProfessoresColaboradores> professoresColaboradoresList;
    @JoinTable(name = "projetos_has_escolas_parceiras", joinColumns = {
        @JoinColumn(name = "projetos_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "escolas_parceiras_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<EscolasParceiras> escolasParceirasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projetosID")
    private List<Atividades> atividadesList;

    public Projetos() {
    }

    public Projetos(Integer id) {
        this.id = id;
    }

    public Projetos(Integer id, boolean situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTituloProjeto() {
        return tituloProjeto;
    }

    public void setTituloProjeto(String tituloProjeto) {
        this.tituloProjeto = tituloProjeto;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }

    public String getTelefoneResidencialCoordenador() {
        return telefoneResidencialCoordenador;
    }

    public void setTelefoneResidencialCoordenador(String telefoneResidencialCoordenador) {
        this.telefoneResidencialCoordenador = telefoneResidencialCoordenador;
    }

    public String getTelefoneCelularCoordenador() {
        return telefoneCelularCoordenador;
    }

    public void setTelefoneCelularCoordenador(String telefoneCelularCoordenador) {
        this.telefoneCelularCoordenador = telefoneCelularCoordenador;
    }

    public String getEmailPrincipalCoordenador() {
        return emailPrincipalCoordenador;
    }

    public void setEmailPrincipalCoordenador(String emailPrincipalCoordenador) {
        this.emailPrincipalCoordenador = emailPrincipalCoordenador;
    }

    public String getEmailSecundarioCoordenador() {
        return emailSecundarioCoordenador;
    }

    public void setEmailSecundarioCoordenador(String emailSecundarioCoordenador) {
        this.emailSecundarioCoordenador = emailSecundarioCoordenador;
    }

    public String getCurriculoLattesCoordenador() {
        return curriculoLattesCoordenador;
    }

    public void setCurriculoLattesCoordenador(String curriculoLattesCoordenador) {
        this.curriculoLattesCoordenador = curriculoLattesCoordenador;
    }

    public String getApresentacaoProposta() {
        return apresentacaoProposta;
    }

    public void setApresentacaoProposta(String apresentacaoProposta) {
        this.apresentacaoProposta = apresentacaoProposta;
    }

    public String getAcoesPrevistas() {
        return acoesPrevistas;
    }

    public void setAcoesPrevistas(String acoesPrevistas) {
        this.acoesPrevistas = acoesPrevistas;
    }

    public String getResultadosPretendidos() {
        return resultadosPretendidos;
    }

    public void setResultadosPretendidos(String resultadosPretendidos) {
        this.resultadosPretendidos = resultadosPretendidos;
    }

    public String getCronograma() {
        return cronograma;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public List<Supervisores> getSupervisoresList() {
        return supervisoresList;
    }

    public void setSupervisoresList(List<Supervisores> supervisoresList) {
        this.supervisoresList = supervisoresList;
    }

    @XmlTransient
    public List<Bolsistas> getBolsistasList() {
        return bolsistasList;
    }

    public void setBolsistasList(List<Bolsistas> bolsistasList) {
        this.bolsistasList = bolsistasList;
    }

    @XmlTransient
    public List<ProfessoresColaboradores> getProfessoresColaboradoresList() {
        return professoresColaboradoresList;
    }

    public void setProfessoresColaboradoresList(List<ProfessoresColaboradores> professoresColaboradoresList) {
        this.professoresColaboradoresList = professoresColaboradoresList;
    }

    @XmlTransient
    public List<EscolasParceiras> getEscolasParceirasList() {
        return escolasParceirasList;
    }

    public void setEscolasParceirasList(List<EscolasParceiras> escolasParceirasList) {
        this.escolasParceirasList = escolasParceirasList;
    }

    @XmlTransient
    public List<Atividades> getAtividadesList() {
        return atividadesList;
    }

    public void setAtividadesList(List<Atividades> atividadesList) {
        this.atividadesList = atividadesList;
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
        if (!(object instanceof Projetos)) {
            return false;
        }
        Projetos other = (Projetos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
}
