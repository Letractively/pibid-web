/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Bolsistas;
import br.ufra.modelo.Projetos;
import br.ufra.modelo.ProjetosBolsistas;
import br.ufra.rn.ProjetosRN;
import br.ufra.utilitario.ComparadorBolsista;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.model.DualListModel;

/**
 *
 * @author marcos
 */
@ManagedBean
@SessionScoped
public class ProjetosBean {

    private Projetos projetos = new Projetos();
    ProjetosRN rn = new ProjetosRN();
    List<Projetos> lista;
    ArrayList<String> situacao = new ArrayList<String>();

    public List<Projetos> getLista() {
        lista = rn.listarTodos();
        return lista;
    }

    public void setLista(List<Projetos> lista) {
        this.lista = lista;
    }

    public Projetos getProjetos() {
        return projetos;
    }

    public void setProjetos(Projetos projetos) {
        this.projetos = projetos;
    }

    public String novo() {
        projetos = rn.novo();
        return "/sistema/projetos/novo.xhtml?faces-redirect=true";
    }

    public String alterar() {
        return "/sistema/projetos/informacao.xhtml";
    }

    public String alterarDados() {
        return "/sistema/projetos/novo.xhtml";
    }

    public String informacao() {
        return "/sistema/projetos/informacao.xhtml";
    }

    public String listar() {
        return "/sistema/projetos/lista.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "/sistema/projetos/lista.xhtml";
    }

    public List<SelectItem> getSituacao() {
        List<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(0, "Inativo"));
        itens.add(new SelectItem(1, "Ativo"));

        return itens;
    }

    public String salvar() {
        if (rn.salvar(projetos)) {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operação realizada com sucesso!",
                    null));
            return listar();
        } else {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Ocorreu um erro inesperado ao tentar salvar dados.",
                    null));
            return novo();
        }

    }
    private SelectItem[] situacoes;

    public SelectItem[] getSituacoes() {
        situacoes = new SelectItem[3];
        situacoes[0] = new SelectItem("selecione", "Selecione");
        situacoes[1] = new SelectItem("Ativo", "Ativo");
        situacoes[2] = new SelectItem("Inativo", "Inativo");
        return situacoes;
    }

    public String alterarBolsistas() {
        return "/sistema/projetos/alterar-bolsista.xhtml";
    }
    private DualListModel<Bolsistas> itens2;
    private List<Bolsistas> selecionados2 = new ArrayList<Bolsistas>();
    private ComparadorBolsista comparadorMaquina = new ComparadorBolsista();

    public DualListModel<Bolsistas> getItens2() {

        selecionados2 = new ArrayList<Bolsistas>();
        for (ProjetosBolsistas bolsistas : projetos.getProjetosBolsistasList()) {
            selecionados2.add(bolsistas.getBolsistas());
        }
        List<Bolsistas> temp = new BolsistaBean().getBolsistas();
        Collections.sort(temp, comparadorMaquina);
        DualListModel<Bolsistas> itens2 = new DualListModel<Bolsistas>(temp, selecionados2);
        return itens2;
    }
    
    Date dataMaq = new Date();

    public Date getDataMaq() {
        return dataMaq;
    }

    public void setDataMaq(Date dataMaq) {
        this.dataMaq = dataMaq;
    }
    
    public String salvarAlteracaoBolsistas(){
        return "";
    }
}
