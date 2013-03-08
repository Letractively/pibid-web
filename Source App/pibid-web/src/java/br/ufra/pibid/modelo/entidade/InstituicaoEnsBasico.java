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
@Table(name = "instituicao_ens_basico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstituicaoEnsBasico.findAll", query = "SELECT i FROM InstituicaoEnsBasico i"),
    @NamedQuery(name = "InstituicaoEnsBasico.findById", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.id = :id"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByNome", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.nome = :nome"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByMatricula", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.matricula = :matricula"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByEsfera", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.esfera = :esfera"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByEndereco", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.endereco = :endereco"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByDiretor", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.diretor = :diretor"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByViceDiretorManha", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.viceDiretorManha = :viceDiretorManha"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByViceDiretorTarde", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.viceDiretorTarde = :viceDiretorTarde"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByViceDiretorNoite", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.viceDiretorNoite = :viceDiretorNoite"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByTelefone", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.telefone = :telefone"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByEmailEscola", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.emailEscola = :emailEscola"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByEmailDirecao", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.emailDirecao = :emailDirecao"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByEmailViceDirecao", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.emailViceDirecao = :emailViceDirecao"),
    @NamedQuery(name = "InstituicaoEnsBasico.findBySituacao", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.situacao = :situacao"),
    @NamedQuery(name = "InstituicaoEnsBasico.findByStatus", query = "SELECT i FROM InstituicaoEnsBasico i WHERE i.status = :status")})
public class InstituicaoEnsBasico implements Serializable {
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
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @Column(name = "esfera")
    private String esfera;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "diretor")
    private String diretor;
    @Basic(optional = false)
    @Column(name = "vice_diretor_manha")
    private String viceDiretorManha;
    @Basic(optional = false)
    @Column(name = "vice_diretor_tarde")
    private String viceDiretorTarde;
    @Basic(optional = false)
    @Column(name = "vice_diretor_noite")
    private String viceDiretorNoite;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email_escola")
    private String emailEscola;
    @Column(name = "email_direcao")
    private String emailDirecao;
    @Column(name = "email_vice_direcao")
    private String emailViceDirecao;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escola")
    private List<DocenteEnsBasico> docenteEnsBasicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instituicaoEnsBasico1")
    private List<EscolaParceira> escolaParceiraList;

    public InstituicaoEnsBasico() {
    }

    public InstituicaoEnsBasico(Integer id) {
        this.id = id;
    }

    public InstituicaoEnsBasico(Integer id, String nome, String matricula, String esfera, String endereco, String diretor, String viceDiretorManha, String viceDiretorTarde, String viceDiretorNoite, String telefone, String situacao, int status) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.esfera = esfera;
        this.endereco = endereco;
        this.diretor = diretor;
        this.viceDiretorManha = viceDiretorManha;
        this.viceDiretorTarde = viceDiretorTarde;
        this.viceDiretorNoite = viceDiretorNoite;
        this.telefone = telefone;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEsfera() {
        return esfera;
    }

    public void setEsfera(String esfera) {
        this.esfera = esfera;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getViceDiretorManha() {
        return viceDiretorManha;
    }

    public void setViceDiretorManha(String viceDiretorManha) {
        this.viceDiretorManha = viceDiretorManha;
    }

    public String getViceDiretorTarde() {
        return viceDiretorTarde;
    }

    public void setViceDiretorTarde(String viceDiretorTarde) {
        this.viceDiretorTarde = viceDiretorTarde;
    }

    public String getViceDiretorNoite() {
        return viceDiretorNoite;
    }

    public void setViceDiretorNoite(String viceDiretorNoite) {
        this.viceDiretorNoite = viceDiretorNoite;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    public List<DocenteEnsBasico> getDocenteEnsBasicoList() {
        return docenteEnsBasicoList;
    }

    public void setDocenteEnsBasicoList(List<DocenteEnsBasico> docenteEnsBasicoList) {
        this.docenteEnsBasicoList = docenteEnsBasicoList;
    }

    @XmlTransient
    public List<EscolaParceira> getEscolaParceiraList() {
        return escolaParceiraList;
    }

    public void setEscolaParceiraList(List<EscolaParceira> escolaParceiraList) {
        this.escolaParceiraList = escolaParceiraList;
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
        if (!(object instanceof InstituicaoEnsBasico)) {
            return false;
        }
        InstituicaoEnsBasico other = (InstituicaoEnsBasico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico[ id=" + id + " ]";
    }
    
}
