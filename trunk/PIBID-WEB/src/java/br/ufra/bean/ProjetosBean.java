/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Projetos;
import br.ufra.rn.ProjetosRN;
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
public class ProjetosBean {

    private Projetos projetos = new Projetos();
    private ProjetosRN rn = new ProjetosRN();
    private List<Projetos> lista;

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }

    public List<Projetos> getLista() {
        return lista;
    }

    public void setLista(List<Projetos> lista) {
        this.lista = lista;
    }

    public String novo() {
        projetos = rn.novo();
        return "/sistema/projetos/novo.xhtml";
    }

    public String alterar() {
        return "/sistema/projeto/novo-projeto.xhtml";
    }

    public String listar() {
        return "/sistema/projetos/lista.xhtml";
    }
     public String cancelar() {
        return "/sistema/projetos/lista.xhtml";
    }

    public String salvar() {
        if (rn.salvar(projetos)) {
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
    
       private SelectItem[] situacoes;

    public SelectItem[] getSituacoes() {
        situacoes = new SelectItem[3];
        situacoes[0] = new SelectItem("", "Selecione");
        situacoes[1] = new SelectItem("Ativo", "Ativo");
        situacoes[2] = new SelectItem("Inativo", "Inativo");
        return situacoes;
    }
}
