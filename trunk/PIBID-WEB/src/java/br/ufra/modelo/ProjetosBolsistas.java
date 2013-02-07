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
@Table(name = "projetos_bolsistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjetosBolsistas.findAll", query = "SELECT p FROM ProjetosBolsistas p"),
    @NamedQuery(name = "ProjetosBolsistas.findByProjetosID", query = "SELECT p FROM ProjetosBolsistas p WHERE p.projetosBolsistasPK.projetosID = :projetosID"),
    @NamedQuery(name = "ProjetosBolsistas.findByBolsistasMatricula", query = "SELECT p FROM ProjetosBolsistas p WHERE p.projetosBolsistasPK.bolsistasMatricula = :bolsistasMatricula"),
    @NamedQuery(name = "ProjetosBolsistas.findByDataEntrada", query = "SELECT p FROM ProjetosBolsistas p WHERE p.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "ProjetosBolsistas.findByDataSaida", query = "SELECT p FROM ProjetosBolsistas p WHERE p.dataSaida = :dataSaida")})
public class ProjetosBolsistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjetosBolsistasPK projetosBolsistasPK;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    @JoinColumn(name = "projetos_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projetos projetos;
    @JoinColumn(name = "bolsistas_matricula", referencedColumnName = "matricula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bolsistas bolsistas;

    public ProjetosBolsistas() {
    }

    public ProjetosBolsistas(ProjetosBolsistasPK projetosBolsistasPK) {
        this.projetosBolsistasPK = projetosBolsistasPK;
    }

    public ProjetosBolsistas(int projetosID, String bolsistasMatricula) {
        this.projetosBolsistasPK = new ProjetosBolsistasPK(projetosID, bolsistasMatricula);
    }

    public ProjetosBolsistasPK getProjetosBolsistasPK() {
        return projetosBolsistasPK;
    }

    public void setProjetosBolsistasPK(ProjetosBolsistasPK projetosBolsistasPK) {
        this.projetosBolsistasPK = projetosBolsistasPK;
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

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }

    public Bolsistas getBolsistas() {
        return bolsistas;
    }

    public void setBolsistas(Bolsistas bolsistas) {
        this.bolsistas = bolsistas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projetosBolsistasPK != null ? projetosBolsistasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetosBolsistas)) {
            return false;
        }
        ProjetosBolsistas other = (ProjetosBolsistas) object;
        if ((this.projetosBolsistasPK == null && other.projetosBolsistasPK != null) || (this.projetosBolsistasPK != null && !this.projetosBolsistasPK.equals(other.projetosBolsistasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.rn.ProjetosBolsistas[ projetosBolsistasPK=" + projetosBolsistasPK + " ]";
    }
    
}
