/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Atividades;
import br.ufra.modelo.Projetos;
import br.ufra.rn.AtividadesRN;
import br.ufra.rn.ProjetosRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author marcos
 */
@ManagedBean
@RequestScoped
public class AtividadesBean {

    private Atividades atividades = new Atividades();
    private Projetos projetos = new Projetos();
    private AtividadesRN rn = new AtividadesRN();
    private ProjetosRN prn = new ProjetosRN();
    private List<Atividades> lista;
    ArrayList<String> situacao = new ArrayList<String>();

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades atividades) {
        this.atividades = atividades;
    }

    public List<Atividades> getLista() {
        lista = rn.listarTodos();
        return lista;
    }

    public void setLista(List<Atividades> lista) {
        this.lista = lista;
    }

    public String novo() {
        atividades = rn.novo();
        return "/sistema/atividade/novo.xhtml?faces-redirect=true";
    }

    public String alterar() {
        return "/sistema/atividade/novo.xhtml";
    }

    public String listar() {
        return "/sistema/atividade/lista.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "/sistema/atividade/lista.xhtml";
    }

    public String informacao() {
        return "/sistema/projetos/informacao.xhtml";
    }

    public String salvar() {
//        atividades.setProjetosID(projetos);
        if (rn.salvar(atividades)) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operação realizada com sucesso!",
                    null));
            return listar();
        } else {
//             ConstraintViolationException constraint = null;
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Ocorreu um erro inesperado ao tentar salvar dados.",
                    null));

            return novo();
        }


    }

    public List<SelectItem> getSituacao() {
        List<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(0, "Inativo"));
        itens.add(new SelectItem(1, "Ativo"));

        return itens;
    }
    private SelectItem[] situacoes;

    public SelectItem[] getSituacoes() {
        situacoes = new SelectItem[3];
        situacoes[0] = new SelectItem("selecione", "Selecione");
        situacoes[1] = new SelectItem("Ativo", "Ativo");
        situacoes[2] = new SelectItem("Inativo", "Inativo");
        return situacoes;
    }

    public List<SelectItem> getListaItensProjeto() {
        List<SelectItem> listarItemRegiao = new ArrayList<SelectItem>();

        List<Projetos> projetos1 = prn.listarTodos();

        for (Projetos itemProjeto : projetos1) {
            listarItemRegiao.add(new SelectItem(itemProjeto, itemProjeto.getNome()));
        }

        return listarItemRegiao;
    }
}
