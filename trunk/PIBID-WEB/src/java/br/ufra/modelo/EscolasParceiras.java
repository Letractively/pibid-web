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
@Table(name = "escolas_parceiras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscolasParceiras.findAll", query = "SELECT e FROM EscolasParceiras e"),
    @NamedQuery(name = "EscolasParceiras.findById", query = "SELECT e FROM EscolasParceiras e WHERE e.id = :id"),
    @NamedQuery(name = "EscolasParceiras.findByEndereco", query = "SELECT e FROM EscolasParceiras e WHERE e.endereco = :endereco"),
    @NamedQuery(name = "EscolasParceiras.findByEsfera", query = "SELECT e FROM EscolasParceiras e WHERE e.esfera = :esfera"),
    @NamedQuery(name = "EscolasParceiras.findByNomeDiretor", query = "SELECT e FROM EscolasParceiras e WHERE e.nomeDiretor = :nomeDiretor"),
    @NamedQuery(name = "EscolasParceiras.findByNomeViceDiretorManha", query = "SELECT e FROM EscolasParceiras e WHERE e.nomeViceDiretorManha = :nomeViceDiretorManha"),
    @NamedQuery(name = "EscolasParceiras.findByNomeViceDiretorTarde", query = "SELECT e FROM EscolasParceiras e WHERE e.nomeViceDiretorTarde = :nomeViceDiretorTarde"),
    @NamedQuery(name = "EscolasParceiras.findByNomeViceDiretorNoite", query = "SELECT e FROM EscolasParceiras e WHERE e.nomeViceDiretorNoite = :nomeViceDiretorNoite"),
    @NamedQuery(name = "EscolasParceiras.findByTelefoneEscola", query = "SELECT e FROM EscolasParceiras e WHERE e.telefoneEscola = :telefoneEscola"),
    @NamedQuery(name = "EscolasParceiras.findByEmailEscola", query = "SELECT e FROM EscolasParceiras e WHERE e.emailEscola = :emailEscola"),
    @NamedQuery(name = "EscolasParceiras.findByEmailDirecao", query = "SELECT e FROM EscolasParceiras e WHERE e.emailDirecao = :emailDirecao"),
    @NamedQuery(name = "EscolasParceiras.findByEmailViceDirecao", query = "SELECT e FROM EscolasParceiras e WHERE e.emailViceDirecao = :emailViceDirecao"),
    @NamedQuery(name = "EscolasParceiras.findBySituacao", query = "SELECT e FROM EscolasParceiras e WHERE e.situacao = :situacao")})
public class EscolasParceiras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "esfera")
    private String esfera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_diretor")
    private String nomeDiretor;
    @Size(max = 45)
    @Column(name = "nome_vice_diretor_manha")
    private String nomeViceDiretorManha;
    @Size(max = 45)
    @Column(name = "nome_vice_diretor_tarde")
    private String nomeViceDiretorTarde;
    @Size(max = 45)
    @Column(name = "nome_vice_diretor_noite")
    private String nomeViceDiretorNoite;
    @Size(max = 45)
    @Column(name = "telefone_escola")
    private String telefoneEscola;
    @Size(max = 45)
    @Column(name = "email_escola")
    private String emailEscola;
    @Size(max = 45)
    @Column(name = "email_direcao")
    private String emailDirecao;
    @Size(max = 45)
    @Column(name = "email_vice_direcao")
    private String emailViceDirecao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacao")
    private boolean situacao;
    @ManyToMany(mappedBy = "escolasParceirasList")
    private List<Projetos> projetosList;

    public EscolasParceiras() {
    }

    public EscolasParceiras(Integer id) {
        this.id = id;
    }

    public EscolasParceiras(Integer id, String esfera, String nomeDiretor, boolean situacao) {
        this.id = id;
        this.esfera = esfera;
        this.nomeDiretor = nomeDiretor;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEsfera() {
        return esfera;
    }

    public void setEsfera(String esfera) {
        this.esfera = esfera;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getNomeViceDiretorManha() {
        return nomeViceDiretorManha;
    }

    public void setNomeViceDiretorManha(String nomeViceDiretorManha) {
        this.nomeViceDiretorManha = nomeViceDiretorManha;
    }

    public String getNomeViceDiretorTarde() {
        return nomeViceDiretorTarde;
    }

    public void setNomeViceDiretorTarde(String nomeViceDiretorTarde) {
        this.nomeViceDiretorTarde = nomeViceDiretorTarde;
    }

    public String getNomeViceDiretorNoite() {
        return nomeViceDiretorNoite;
    }

    public void setNomeViceDiretorNoite(String nomeViceDiretorNoite) {
        this.nomeViceDiretorNoite = nomeViceDiretorNoite;
    }

    public String getTelefoneEscola() {
        return telefoneEscola;
    }

    public void setTelefoneEscola(String telefoneEscola) {
        this.telefoneEscola = telefoneEscola;
    }

    public String getEmailEscola() {
        return emailEscola;
    }

    public void setEmailEscola(String emailEscola) {
        this.emailEscola = emailEscola;
    }

    public String getEmailDirecao() {
        return emailDirecao;
    }

    public void setEmailDirecao(String emailDirecao) {
        this.emailDirecao = emailDirecao;
    }

    public String getEmailViceDirecao() {
        return emailViceDirecao;
    }

    public void setEmailViceDirecao(String emailViceDirecao) {
        this.emailViceDirecao = emailViceDirecao;
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
        if (!(object instanceof EscolasParceiras)) {
            return false;
        }
        EscolasParceiras other = (EscolasParceiras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EscolasParceiras[ id=" + id + " ]";
    }
    
}
