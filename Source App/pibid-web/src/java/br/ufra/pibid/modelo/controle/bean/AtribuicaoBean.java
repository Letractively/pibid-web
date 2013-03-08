/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Projeto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcos
 */
@ManagedBean
@SessionScoped
public class AtribuicaoBean {

    private Projeto projeto = new Projeto();
    private Atividade atividade = new Atividade();

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }


    public String atribuirParticipante() {
        return "/restrito/projeto/movimentacao/cadastro.xhtml";
    }
}
