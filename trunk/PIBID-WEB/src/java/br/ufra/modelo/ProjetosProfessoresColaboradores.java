/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "projetos_professores_colaboradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjetosProfessoresColaboradores.findAll", query = "SELECT p FROM ProjetosProfessoresColaboradores p"),
    @NamedQuery(name = "ProjetosProfessoresColaboradores.findByProjetosID", query = "SELECT p FROM ProjetosProfessoresColaboradores p WHERE p.projetosProfessoresColaboradoresPK.projetosID = :projetosID"),
    @NamedQuery(name = "ProjetosProfessoresColaboradores.findByProfessorescolaboradoresID", query = "SELECT p FROM ProjetosProfessoresColaboradores p WHERE p.projetosProfessoresColaboradoresPK.professorescolaboradoresID = :professorescolaboradoresID"),
    @NamedQuery(name = "ProjetosProfessoresColaboradores.findByDataInicio", query = "SELECT p FROM ProjetosProfessoresColaboradores p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "ProjetosProfessoresColaboradores.findByDataFim", query = "SELECT p FROM ProjetosProfessoresColaboradores p WHERE p.dataFim = :dataFim")})
public class ProjetosProfessoresColaboradores implements Serializable {
    @JoinColumn(name = "professores_colaboradores_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProfessoresColaboradores professoresColaboradores;
    @JoinColumn(name = "projetos_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projetos projetos;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjetosProfessoresColaboradoresPK projetosProfessoresColaboradoresPK;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    public ProjetosProfessoresColaboradores() {
    }

    public ProjetosProfessoresColaboradores(ProjetosProfessoresColaboradoresPK projetosProfessoresColaboradoresPK) {
        this.projetosProfessoresColaboradoresPK = projetosProfessoresColaboradoresPK;
    }

    public ProjetosProfessoresColaboradores(int projetosID, int professorescolaboradoresID) {
        this.projetosProfessoresColaboradoresPK = new ProjetosProfessoresColaboradoresPK(projetosID, professorescolaboradoresID);
    }

    public ProjetosProfessoresColaboradoresPK getProjetosProfessoresColaboradoresPK() {
        return projetosProfessoresColaboradoresPK;
    }

    public void setProjetosProfessoresColaboradoresPK(ProjetosProfessoresColaboradoresPK projetosProfessoresColaboradoresPK) {
        this.projetosProfessoresColaboradoresPK = projetosProfessoresColaboradoresPK;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projetosProfessoresColaboradoresPK != null ? projetosProfessoresColaboradoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosProfessoresColaboradores)) {
            return false;
        }
        ProjetosProfessoresColaboradores other = (ProjetosProfessoresColaboradores) object;
        if ((this.projetosProfessoresColaboradoresPK == null && other.projetosProfessoresColaboradoresPK != null) || (this.projetosProfessoresColaboradoresPK != null && !this.projetosProfessoresColaboradoresPK.equals(other.projetosProfessoresColaboradoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.modelo.ProjetosProfessoresColaboradores[ projetosProfessoresColaboradoresPK=" + projetosProfessoresColaboradoresPK + " ]";
    }

    public ProfessoresColaboradores getProfessoresColaboradores() {
        return professoresColaboradores;
    }

    public void setProfessoresColaboradores(ProfessoresColaboradores professoresColaboradores) {
        this.professoresColaboradores = professoresColaboradores;
    }

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }
    
}
