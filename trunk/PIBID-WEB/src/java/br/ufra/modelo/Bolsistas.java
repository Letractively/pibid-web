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
@Table(name = "bolsistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bolsistas.findAll", query = "SELECT b FROM Bolsistas b"),
    @NamedQuery(name = "Bolsistas.findByMatricula", query = "SELECT b FROM Bolsistas b WHERE b.matricula = :matricula"),
    @NamedQuery(name = "Bolsistas.findByNome", query = "SELECT b FROM Bolsistas b WHERE b.nome = :nome"),
    @NamedQuery(name = "Bolsistas.findByEmailPrincipal", query = "SELECT b FROM Bolsistas b WHERE b.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "Bolsistas.findByEmailSecundario", query = "SELECT b FROM Bolsistas b WHERE b.emailSecundario = :emailSecundario"),
    @NamedQuery(name = "Bolsistas.findByTelefoneResidencial", query = "SELECT b FROM Bolsistas b WHERE b.telefoneResidencial = :telefoneResidencial"),
    @NamedQuery(name = "Bolsistas.findByTelefoneCelular", query = "SELECT b FROM Bolsistas b WHERE b.telefoneCelular = :telefoneCelular"),
    @NamedQuery(name = "Bolsistas.findByEndereco", query = "SELECT b FROM Bolsistas b WHERE b.endereco = :endereco"),
    @NamedQuery(name = "Bolsistas.findBySituacao", query = "SELECT b FROM Bolsistas b WHERE b.situacao = :situacao")})
public class Bolsistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacao")
    private boolean situacao;
    @ManyToMany(mappedBy = "bolsistasList")
    private List<Projetos> projetosList;

    public Bolsistas() {
    }

    public Bolsistas(String matricula) {
        this.matricula = matricula;
    }

    public Bolsistas(String matricula, String nome, boolean situacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.situacao = situacao;
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
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bolsistas)) {
            return false;
        }
        Bolsistas other = (Bolsistas) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Bolsistas[ matricula=" + matricula + " ]";
    }
    
}
