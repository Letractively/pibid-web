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
 * @author marcos
 */
@Entity
@Table(name = "discente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discente.findAll", query = "SELECT d FROM Discente d"),
    @NamedQuery(name = "Discente.findById", query = "SELECT d FROM Discente d WHERE d.id = :id"),
    @NamedQuery(name = "Discente.findByMatricula", query = "SELECT d FROM Discente d WHERE d.matricula = :matricula"),
    @NamedQuery(name = "Discente.findByNome", query = "SELECT d FROM Discente d WHERE d.nome = :nome"),
    @NamedQuery(name = "Discente.findByEmailPrincipal", query = "SELECT d FROM Discente d WHERE d.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "Discente.findByEmailSecudario", query = "SELECT d FROM Discente d WHERE d.emailSecudario = :emailSecudario"),
    @NamedQuery(name = "Discente.findByTelResidencial", query = "SELECT d FROM Discente d WHERE d.telResidencial = :telResidencial"),
    @NamedQuery(name = "Discente.findByTelCelular", query = "SELECT d FROM Discente d WHERE d.telCelular = :telCelular"),
    @NamedQuery(name = "Discente.findByEndereco", query = "SELECT d FROM Discente d WHERE d.endereco = :endereco"),
    @NamedQuery(name = "Discente.findByLattes", query = "SELECT d FROM Discente d WHERE d.lattes = :lattes"),
    @NamedQuery(name = "Discente.findBySituacao", query = "SELECT d FROM Discente d WHERE d.situacao = :situacao"),
    @NamedQuery(name = "Discente.findByStatus", query = "SELECT d FROM Discente d WHERE d.status = :status"),
    @NamedQuery(name = "Discente.findByStatusAtividade", query = "SELECT d FROM Discente d WHERE d.statusAtividade = :statusAtividade")})
public class Discente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "matricula")
    private String matricula;
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
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "status_atividade")
    private int statusAtividade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discente1")
    private List<AlunoColaborador> alunoColaboradorList;
    @JoinColumn(name = "instituicao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstituicaoEnsSuperior instituicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discente1")
    private List<Bolsista> bolsistaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discente1")
    private List<ResponsavelAtividade> responsavelAtividadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discente2")
    private List<ResponsavelAtividade> responsavelAtividadeList1;

    public Discente() {
    }

    public Discente(Integer id) {
        this.id = id;
    }

    public Discente(Integer id, String matricula, String nome, String emailPrincipal, String telResidencial, String telCelular, String endereco, String situacao, int status, int statusAtividade) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.emailPrincipal = emailPrincipal;
        this.telResidencial = telResidencial;
        this.telCelular = telCelular;
        this.endereco = endereco;
        this.situacao = situacao;
        this.status = status;
        this.statusAtividade = statusAtividade;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(int statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    @XmlTransient
    public List<AlunoColaborador> getAlunoColaboradorList() {
        return alunoColaboradorList;
    }

    public void setAlunoColaboradorList(List<AlunoColaborador> alunoColaboradorList) {
        this.alunoColaboradorList = alunoColaboradorList;
    }

    public InstituicaoEnsSuperior getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoEnsSuperior instituicao) {
        this.instituicao = instituicao;
    }

    @XmlTransient
    public List<Bolsista> getBolsistaList() {
        return bolsistaList;
    }

    public void setBolsistaList(List<Bolsista> bolsistaList) {
        this.bolsistaList = bolsistaList;
    }

    @XmlTransient
    public List<ResponsavelAtividade> getResponsavelAtividadeList() {
        return responsavelAtividadeList;
    }

    public void setResponsavelAtividadeList(List<ResponsavelAtividade> responsavelAtividadeList) {
        this.responsavelAtividadeList = responsavelAtividadeList;
    }

    @XmlTransient
    public List<ResponsavelAtividade> getResponsavelAtividadeList1() {
        return responsavelAtividadeList1;
    }

    public void setResponsavelAtividadeList1(List<ResponsavelAtividade> responsavelAtividadeList1) {
        this.responsavelAtividadeList1 = responsavelAtividadeList1;
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
        if (!(object instanceof Discente)) {
            return false;
        }
        Discente other = (Discente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.Discente[ id=" + id + " ]";
    }
    
}
