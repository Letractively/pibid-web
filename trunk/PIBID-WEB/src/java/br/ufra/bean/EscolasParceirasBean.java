/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.EscolasParceiras;
import br.ufra.rn.EscolasParceirasRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcos
 */
public class EscolasParceirasBean {
    
    private EscolasParceiras escolasParceiras = new EscolasParceiras();
    private EscolasParceirasRN rn = new EscolasParceirasRN();
    private List<EscolasParceiras> lista;

    public EscolasParceiras getEscolasParceiras() {
        return escolasParceiras;
    }

    public void setEscolasParceiras(EscolasParceiras escolasParceiras) {
        this.escolasParceiras = escolasParceiras;
    }

    public List<EscolasParceiras> getLista() {
        return lista;
    }

    public void setLista(List<EscolasParceiras> lista) {
        this.lista = lista;
    }
    
    public String novo() {
        escolasParceiras = rn.novo();
        return "/sistema/cadastro/escolasparceiros/novo-parceiro.xhtml";
    }

    public String alterar() {
        return "/sistema/cadastro/escolasparceiros/novo-parceiro.xhtml";
    }

    public String listar() {
        return "/sistema/cadastro/escolasparceiros/lista-parceiros.xhtml";
    }

    public String salvar() {
        if (rn.salvar(escolasParceiras)) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operação realizada com sucesso!",
                    null));
        } else {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Ocorreu um erro inesperado ao tentar salvar dados.",
                    null));
        }

        return novo();
    }
}
