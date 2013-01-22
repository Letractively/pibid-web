/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author victorperes
 */
@Entity
@Table(name = "professores_colaboradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessoresColaboradores.findAll", query = "SELECT p FROM ProfessoresColaboradores p"),
    @NamedQuery(name = "ProfessoresColaboradores.findById", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.id = :id"),
    @NamedQuery(name = "ProfessoresColaboradores.findByNome", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.nome = :nome"),
    @NamedQuery(name = "ProfessoresColaboradores.findByEmailPrincipal", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "ProfessoresColaboradores.findByEmailSecundario", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.emailSecundario = :emailSecundario"),
    @NamedQuery(name = "ProfessoresColaboradores.findByTelefoneResidencial", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.telefoneResidencial = :telefoneResidencial"),
    @NamedQuery(name = "ProfessoresColaboradores.findByTelefoneCelular", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.telefoneCelular = :telefoneCelular"),
    @NamedQuery(name = "ProfessoresColaboradores.findByEndereco", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.endereco = :endereco"),
    @NamedQuery(name = "ProfessoresColaboradores.findByInstituicao", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.instituicao = :instituicao"),
    @NamedQuery(name = "ProfessoresColaboradores.findBySituacao", query = "SELECT p FROM ProfessoresColaboradores p WHERE p.situacao = :situacao")})
public class ProfessoresColaboradores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
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
    @Column(name = "situacao")
    private boolean situacao;
    @ManyToMany(mappedBy = "professoresColaboradoresList")
    private List<Projetos> projetosList;

    public ProfessoresColaboradores() {
    }

    public ProfessoresColaboradores(Integer id) {
        this.id = id;
    }

    public ProfessoresColaboradores(Integer id, String nome, boolean situacao) {
        this.id = id;
        this.nome = nome;
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

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public List<Projetos> getProjetosList() {
        return projetosList;
    }

    public void setProjetosList(List<Projetos> projetosList) {
        this.projetosList = projetosList;
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
        if (!(object instanceof ProfessoresColaboradores)) {
            return false;
        }
        ProfessoresColaboradores other = (ProfessoresColaboradores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProfessoresColaboradores[ id=" + id + " ]";
    }
    
}
