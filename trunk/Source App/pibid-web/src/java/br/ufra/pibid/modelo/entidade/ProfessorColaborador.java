/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcos
 */
@Entity
@Table(name = "professor_colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessorColaborador.findAll", query = "SELECT p FROM ProfessorColaborador p"),
    @NamedQuery(name = "ProfessorColaborador.findByProjeto", query = "SELECT p FROM ProfessorColaborador p WHERE p.professorColaboradorPK.projeto = :projeto"),
    @NamedQuery(name = "ProfessorColaborador.findByDocente", query = "SELECT p FROM ProfessorColaborador p WHERE p.professorColaboradorPK.docente = :docente"),
    @NamedQuery(name = "ProfessorColaborador.findByDataEntrada", query = "SELECT p FROM ProfessorColaborador p WHERE p.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "ProfessorColaborador.findByDataSaida", query = "SELECT p FROM ProfessorColaborador p WHERE p.dataSaida = :dataSaida")})
public class ProfessorColaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfessorColaboradorPK professorColaboradorPK;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "projeto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto1;
    @JoinColumn(name = "docente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DocenteEnsSuperior docenteEnsSuperior;

    public ProfessorColaborador() {
    }

    public ProfessorColaborador(ProfessorColaboradorPK professorColaboradorPK) {
        this.professorColaboradorPK = professorColaboradorPK;
    }

    public ProfessorColaborador(int projeto, int docente) {
        this.professorColaboradorPK = new ProfessorColaboradorPK(projeto, docente);
    }

    public ProfessorColaboradorPK getProfessorColaboradorPK() {
        return professorColaboradorPK;
    }

    public void setProfessorColaboradorPK(ProfessorColaboradorPK professorColaboradorPK) {
        this.professorColaboradorPK = professorColaboradorPK;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Projeto getProjeto1() {
        return projeto1;
    }

    public void setProjeto1(Projeto projeto1) {
        this.projeto1 = projeto1;
    }

    public DocenteEnsSuperior getDocenteEnsSuperior() {
        return docenteEnsSuperior;
    }

    public void setDocenteEnsSuperior(DocenteEnsSuperior docenteEnsSuperior) {
        this.docenteEnsSuperior = docenteEnsSuperior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professorColaboradorPK != null ? professorColaboradorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessorColaborador)) {
            return false;
        }
        ProfessorColaborador other = (ProfessorColaborador) object;
        if ((this.professorColaboradorPK == null && other.professorColaboradorPK != null) || (this.professorColaboradorPK != null && !this.professorColaboradorPK.equals(other.professorColaboradorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.ProfessorColaborador[ professorColaboradorPK=" + professorColaboradorPK + " ]";
    }
    
}
