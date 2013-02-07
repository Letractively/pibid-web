/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "alunos_colaboradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunosColaboradores.findAll", query = "SELECT a FROM AlunosColaboradores a"),
    @NamedQuery(name = "AlunosColaboradores.findById", query = "SELECT a FROM AlunosColaboradores a WHERE a.id = :id"),
    @NamedQuery(name = "AlunosColaboradores.findByMatricula", query = "SELECT a FROM AlunosColaboradores a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "AlunosColaboradores.findByNome", query = "SELECT a FROM AlunosColaboradores a WHERE a.nome = :nome"),
    @NamedQuery(name = "AlunosColaboradores.findByEmailPrincipal", query = "SELECT a FROM AlunosColaboradores a WHERE a.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "AlunosColaboradores.findByEmailSecundario", query = "SELECT a FROM AlunosColaboradores a WHERE a.emailSecundario = :emailSecundario"),
    @NamedQuery(name = "AlunosColaboradores.findByTelefoneResidencial", query = "SELECT a FROM AlunosColaboradores a WHERE a.telefoneResidencial = :telefoneResidencial"),
    @NamedQuery(name = "AlunosColaboradores.findByTelefoneCelular", query = "SELECT a FROM AlunosColaboradores a WHERE a.telefoneCelular = :telefoneCelular"),
    @NamedQuery(name = "AlunosColaboradores.findByEndereco", query = "SELECT a FROM AlunosColaboradores a WHERE a.endereco = :endereco"),
    @NamedQuery(name = "AlunosColaboradores.findByInstituicao", query = "SELECT a FROM AlunosColaboradores a WHERE a.instituicao = :instituicao"),
    @NamedQuery(name = "AlunosColaboradores.findBySituacao", query = "SELECT a FROM AlunosColaboradores a WHERE a.situacao = :situacao"),
    @NamedQuery(name = "AlunosColaboradores.findByStatus", query = "SELECT a FROM AlunosColaboradores a WHERE a.status = :status")})
public class AlunosColaboradores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "email_principal")
    private String emailPrincipal;
    @Size(max = 45)
    @Column(name = "email_secundario")
    private String emailSecundario;
    @Size(max = 45)
    @Column(name = "telefone_residencial")
    private String telefoneResidencial;
    @Size(max = 45)
    @Column(name = "telefone_celular")
    private String telefoneCelular;
    @Size(max = 45)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 45)
    @Column(name = "instituicao")
    private String instituicao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alunosColaboradores")
    private List<ProjetosProfessoresColaboradores> projetosProfessoresColaboradoresList;

    public AlunosColaboradores() {
    }

    public AlunosColaboradores(Integer id) {
        this.id = id;
    }

    public AlunosColaboradores(Integer id, String matricula, String nome, String situacao, int status) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.situacao = situacao;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<ProjetosProfessoresColaboradores> getProjetosProfessoresColaboradoresList() {
        return projetosProfessoresColaboradoresList;
    }

    public void setProjetosProfessoresColaboradoresList(List<ProjetosProfessoresColaboradores> projetosProfessoresColaboradoresList) {
        this.projetosProfessoresColaboradoresList = projetosProfessoresColaboradoresList;
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
        if (!(object instanceof AlunosColaboradores)) {
            return false;
        }
        AlunosColaboradores other = (AlunosColaboradores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.rn.AlunosColaboradores[ id=" + id + " ]";
    }
    
}
