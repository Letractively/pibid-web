/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Projeto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcos
 */
@ManagedBean
@SessionScoped
public class AtribuicaoBean {

    private Projeto projeto = new Projeto();

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastro.xhtml";
    }
}
