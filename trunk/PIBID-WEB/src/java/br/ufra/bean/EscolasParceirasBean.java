/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.EscolasParceiras;
import br.ufra.rn.EscolasParceirasRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author marcos
 */
@ManagedBean
@RequestScoped
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
        lista = rn.listarTodos();
        return lista;
    }

    public void setLista(List<EscolasParceiras> lista) {
        this.lista = lista;
    }

    public String novo() {
        escolasParceiras = rn.novo();
        return "/sistema/cadastro/escolasparceiros/novo.xhtml";
    }

    public String alterar() {
        return "/sistema/cadastro/escolasparceiros/novo.xhtml";
    }

    public String listar() {
        return "/sistema/cadastro/escolasparceiros/lista.xhtml";
    }

    public String cancelar() {
        return "/sistema/cadastro/escolasparceiros/lista.xhtml";
    }

    public String salvar() {
        if (rn.salvar(escolasParceiras)) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operação realizada com sucesso!",
                    null));
            return "/sistema/cadastro/escolasparceiros/lista.xhtml";
        } else {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Ocorreu um erro inesperado ao tentar salvar dados.",
                    null));
            return "/sistema/cadastro/escolasparceiros/novo.xhtml";
        }


    }

    public ArrayList<String> getEsfera() {
        ArrayList<String> esfera = new ArrayList<String>();
        esfera.add("Estadual");
        esfera.add("Federal");
        return esfera;
    }

    public ArrayList<String> getSituacao() {
        situacao.add("Ativo");
        situacao.add("Inativo");
        return situacao;
    }
    private SelectItem[] situacoes;
    ArrayList<String> situacao = new ArrayList<String>();

    public SelectItem[] getSituacoes() {


        situacoes = new SelectItem[3];
        situacoes[0] = new SelectItem("", "Selecione");
        situacoes[1] = new SelectItem("Ativo", "Ativo");
        situacoes[2] = new SelectItem("Inativo", "Inativo");
        return situacoes;
    }
}
