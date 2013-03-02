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
 * @author marcos
 */
@Entity
@Table(name = "docente_ens_basico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocenteEnsBasico.findAll", query = "SELECT d FROM DocenteEnsBasico d"),
    @NamedQuery(name = "DocenteEnsBasico.findById", query = "SELECT d FROM DocenteEnsBasico d WHERE d.id = :id"),
    @NamedQuery(name = "DocenteEnsBasico.findByNome", query = "SELECT d FROM DocenteEnsBasico d WHERE d.nome = :nome"),
    @NamedQuery(name = "DocenteEnsBasico.findByEmailPrincipal", query = "SELECT d FROM DocenteEnsBasico d WHERE d.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "DocenteEnsBasico.findByEmailSecudario", query = "SELECT d FROM DocenteEnsBasico d WHERE d.emailSecudario = :emailSecudario"),
    @NamedQuery(name = "DocenteEnsBasico.findByTelResidencial", query = "SELECT d FROM DocenteEnsBasico d WHERE d.telResidencial = :telResidencial"),
    @NamedQuery(name = "DocenteEnsBasico.findByTelCelular", query = "SELECT d FROM DocenteEnsBasico d WHERE d.telCelular = :telCelular"),
    @NamedQuery(name = "DocenteEnsBasico.findByEndereco", query = "SELECT d FROM DocenteEnsBasico d WHERE d.endereco = :endereco"),
    @NamedQuery(name = "DocenteEnsBasico.findBySituacao", query = "SELECT d FROM DocenteEnsBasico d WHERE d.situacao = :situacao"),
    @NamedQuery(name = "DocenteEnsBasico.findByStatus", query = "SELECT d FROM DocenteEnsBasico d WHERE d.status = :status")})
public class DocenteEnsBasico implements Serializable {
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
    @Column(name = "tel_residencial")
    private String telResidencial;
    @Column(name = "tel_celular")
    private String telCelular;
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "escola", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstituicaoEnsBasico escola;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docenteEnsBasico")
    private List<Supervisor> supervisorList;

    public DocenteEnsBasico() {
    }

    public DocenteEnsBasico(Integer id) {
        this.id = id;
    }

    public DocenteEnsBasico(Integer id, String nome, String emailPrincipal, String situacao, int status) {
        this.id = id;
        this.nome = nome;
        this.emailPrincipal = emailPrincipal;
        this.situacao = situacao;
        this.status = status;
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

    public InstituicaoEnsBasico getEscola() {
        return escola;
    }

    public void setEscola(InstituicaoEnsBasico escola) {
        this.escola = escola;
    }

    @XmlTransient
    public List<Supervisor> getSupervisorList() {
        return supervisorList;
    }

    public void setSupervisorList(List<Supervisor> supervisorList) {
        this.supervisorList = supervisorList;
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
        if (!(object instanceof DocenteEnsBasico)) {
            return false;
        }
        DocenteEnsBasico other = (DocenteEnsBasico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.DocenteEnsBasico[ id=" + id + " ]";
    }
    
}
