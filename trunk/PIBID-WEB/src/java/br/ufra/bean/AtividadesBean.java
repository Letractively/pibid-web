/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Atividades;
import br.ufra.rn.AtividadesRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcos
 */
@ManagedBean
@RequestScoped
public class AtividadesBean {

    private Atividades atividades = new Atividades();
    private AtividadesRN rn = new AtividadesRN();
    private List<Atividades> lista;

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades atividades) {
        this.atividades = atividades;
    }

    public List<Atividades> getLista() {
        return lista;
    }

    public void setLista(List<Atividades> lista) {
        this.lista = lista;
    }

    public String novo() {
        atividades = rn.novo();
        return "/sistema/atividade/novo.xhtml";
    }

    public String alterar() {
        return "/sistema/atividade/novo.xhtml";
    }

    public String listar() {
        return "/sistema/atividade/lista.xhtml";
    }

    public String cancelar() {
        return "/sistema/cadastro/bolsista/lista.xhtml";
    }

    public String salvar() {
        if (rn.salvar(atividades)) {
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
