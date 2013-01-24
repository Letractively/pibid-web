/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Supervisores;
import br.ufra.rn.SupervisoresRN;
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
public class SupervisoresBean {

    private Supervisores supervisores = new Supervisores();
    private SupervisoresRN rn = new SupervisoresRN();
    private List<Supervisores> lista;
    ArrayList<String> situacao = new ArrayList<String>();

    public Supervisores getSupervisores() {
        return supervisores;
    }

    public void setSupervisores(Supervisores supervisores) {
        this.supervisores = supervisores;
    }

    public List<Supervisores> getLista() {
        return lista;
    }

    public void setLista(List<Supervisores> lista) {
        this.lista = lista;
    }

    public String novo() {
        supervisores = rn.novo();
        return "/sistema/supervisores/novo.xhtml";
    }

    public String alterar() {
        return "/sistema/supervisores/novo.xhtml";
    }

    public String listar() {
        return "/sistema/supervisores/lista.xhtml";
    }

    public String salvar() {
        supervisores.setStatus(0);
        if (rn.salvar(supervisores)) {
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

    public ArrayList<String> getSituacao() {
        situacao.add("Ativo");
        situacao.add("Inativo");
        return situacao;
    }
    private SelectItem[] situacoes;

    public SelectItem[] getSituacoes() {
        situacoes = new SelectItem[3];
        situacoes[0] = new SelectItem("Selecione");
        situacoes[1] = new SelectItem("Ativo");
        situacoes[2] = new SelectItem("Inativo");
        return situacoes;
    }
}
