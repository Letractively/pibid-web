/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marcos
 */
@Embeddable
public class EscolaParceiraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "projeto")
    private int projeto;
    @Basic(optional = false)
    @Column(name = "instituicao_ens_basico")
    private int instituicaoEnsBasico;

    public EscolaParceiraPK() {
    }

    public EscolaParceiraPK(int projeto, int instituicaoEnsBasico) {
        this.projeto = projeto;
        this.instituicaoEnsBasico = instituicaoEnsBasico;
    }

    public int getProjeto() {
        return projeto;
    }

    public void setProjeto(int projeto) {
        this.projeto = projeto;
    }

    public int getInstituicaoEnsBasico() {
        return instituicaoEnsBasico;
    }

    public void setInstituicaoEnsBasico(int instituicaoEnsBasico) {
        this.instituicaoEnsBasico = instituicaoEnsBasico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) projeto;
        hash += (int) instituicaoEnsBasico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscolaParceiraPK)) {
            return false;
        }
        EscolaParceiraPK other = (EscolaParceiraPK) object;
        if (this.projeto != other.projeto) {
            return false;
        }
        if (this.instituicaoEnsBasico != other.instituicaoEnsBasico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufra.pibid.modelo.entidade.EscolaParceiraPK[ projeto=" + projeto + ", instituicaoEnsBasico=" + instituicaoEnsBasico + " ]";
    }
    
}
