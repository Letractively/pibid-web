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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "supervisores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisores.findAll", query = "SELECT s FROM Supervisores s"),
    @NamedQuery(name = "Supervisores.findById", query = "SELECT s FROM Supervisores s WHERE s.id = :id"),
    @NamedQuery(name = "Supervisores.findByNome", query = "SELECT s FROM Supervisores s WHERE s.nome = :nome"),
    @NamedQuery(name = "Supervisores.findByEmailPrincipal", query = "SELECT s FROM Supervisores s WHERE s.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "Supervisores.findByEmailSecundario", query = "SELECT s FROM Supervisores s WHERE s.emailSecundario = :emailSecundario"),
    @NamedQuery(name = "Supervisores.findByTelefoneResidencial", query = "SELECT s FROM Supervisores s WHERE s.telefoneResidencial = :telefoneResidencial"),
    @NamedQuery(name = "Supervisores.findByTelefoneCelular", query = "SELECT s FROM Supervisores s WHERE s.telefoneCelular = :telefoneCelular"),
    @NamedQuery(name = "Supervisores.findByEndereco", query = "SELECT s FROM Supervisores s WHERE s.endereco = :endereco"),
    @NamedQuery(name = "Supervisores.findBySituacao", query = "SELECT s FROM Supervisores s WHERE s.situacao = :situacao")})
public class Supervisores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email_principal")
    private String emailPrincipal;
    @Column(name = "email_secundario")
    private String emailSecundario;
    @Column(name = "telefone_residencial")
    private String telefoneResidencial;
    @Column(name = "telefone_celular")
    private String telefoneCelular;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "situacao")
    private Boolean situacao;
    @ManyToMany(mappedBy = "supervisoresList")
    private List<Projetos> projetosList;

    public Supervisores() {
    }

    public Supervisores(Integer id) {
        this.id = id;
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

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
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
        if (!(object instanceof Supervisores)) {
            return false;
        }
        Supervisores other = (Supervisores) object;
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
