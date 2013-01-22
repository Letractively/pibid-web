/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Supervisores;
import br.ufra.rn.SupervisoresRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcos
 */
public class SupervisoresBean {
    
    private Supervisores supervisores = new Supervisores();
    private SupervisoresRN rn = new SupervisoresRN();
    private List<Supervisores>lista;

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
        return "/sistema/supervisores/novo-supervisor.xhtml";
    }

    public String alterar() {
        return "/sistema/supervisores/novo-supervisor.xhtml";
    }

    public String listar() {
        return "/sistema/supervisores/lista-supervisores.xhtml";
    }

    public String salvar() {
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
}
