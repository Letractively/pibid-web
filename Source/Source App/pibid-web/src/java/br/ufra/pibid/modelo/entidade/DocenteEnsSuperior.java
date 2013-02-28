/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stelio
 */
@Entity
@Table(name = "docente_ens_superior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocenteEnsSuperior.findAll", query = "SELECT d FROM DocenteEnsSuperior d"),
    @NamedQuery(name = "DocenteEnsSuperior.findById", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.id = :id"),
    @NamedQuery(name = "DocenteEnsSuperior.findByNome", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.nome = :nome"),
    @NamedQuery(name = "DocenteEnsSuperior.findByEmailPrincipal", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "DocenteEnsSuperior.findByEmailSecudario", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.emailSecudario = :emailSecudario"),
    @NamedQuery(name = "DocenteEnsSuperior.findByTelResidencial", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.telResidencial = :telResidencial"),
    @NamedQuery(name = "DocenteEnsSuperior.findByTelCelular", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.telCelular = :telCelular"),
    @NamedQuery(name = "DocenteEnsSuperior.findByEndereco", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.endereco = :endereco"),
    @NamedQuery(name = "DocenteEnsSuperior.findByLattes", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.lattes = :lattes"),
    @NamedQuery(name = "DocenteEnsSuperior.findByInstituicao", query = "SELECT d FROM Discente d WHERE d.instituicao = :instituicao"),
    @NamedQuery(name = "DocenteEnsSuperior.findBySituacao", query = "SELECT d FROM DocenteEnsSuperior d WHERE d.situacao = :situacao")})
public class DocenteEnsSuperior implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "email_principal")
    private String emailPrincipal;
    @Column(name = "email_secudario")
    private String emailSecudario;
    @Basic(optional = false)
    @Column(name = "tel_residencial")
    private String telResidencial;
    @Basic(optional = false)
    @Column(name = "tel_celular")
    private String telCelular;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "lattes")
    private String lattes;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "instituicao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Instituicao instituicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coordenador")
    private List<Projeto> projetoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docenteEnsSuperior")
    private List<ProfessorColaborador> professorColaboradorList;

    public DocenteEnsSuperior() {
    }

    public DocenteEnsSuperior(Integer id) {
        this.id = id;
    }

    public DocenteEnsSuperior(Integer id, String nome, String emailPrincipal, String telResidencial, String telCelular, String endereco, String situacao) {
        this.id = id;
        this.nome = nome;
        this.emailPrincipal = emailPrincipal;
        this.telResidencial = telResidencial;
        this.telCelular = telCelular;
        this.endereco = endereco;
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

    public String getEmailSecudario() {
        return emailSecudario;
    }

    public void setEmailSecudario(String emailSecudario) {
        this.emailSecudario = emailSecudario;
    }

    public String getTelResidencial() {
        return telResidencial;
    }

    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLattes() {
        return lattes;
    }

    public void setLattes(String lattes) {
        this.lattes = lattes;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    @XmlTransient
    public List<Projeto> getProjetoList() {
        return projetoList;
    }

    public void setProjetoList(List<Projeto> projetoList) {
        this.projetoList = projetoList;
    }

    @XmlTransient
    public List<ProfessorColaborador> getProfessorColaboradorList() {
        return professorColaboradorList;
    }

    public void setProfessorColaboradorList(List<ProfessorColaborador> professorColaboradorList) {
        this.professorColaboradorList = professorColaboradorList;
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
        if (!(object instanceof DocenteEnsSuperior)) {
            return false;
        }
        DocenteEnsSuperior other = (DocenteEnsSuperior) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.DocenteEnsSuperior[ id=" + id + " ]";
    }
    
}
