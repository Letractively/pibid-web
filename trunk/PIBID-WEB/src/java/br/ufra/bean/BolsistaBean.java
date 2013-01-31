/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Bolsistas;
import br.ufra.rn.BolsistaRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author victorperes
 */
@ManagedBean
@RequestScoped
public class BolsistaBean {

    /**
     * Creates a new instance of cargoBean
     */
    private Bolsistas bolsista = new Bolsistas();
    private BolsistaRN rn = new BolsistaRN();
    private List<Bolsistas> bolsistas;
    ArrayList<String> situacao = new ArrayList<String>();

    public BolsistaBean() {
    }

    public String salvar() {
        bolsista.setStatus(0);
        rn.salvar(bolsista);
        FacesMessage msg = new FacesMessage("Cadastrado com Sucesso",
                "Cadastrado :" + bolsista.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/sistema/cadastro/bolsista/lista.xhtml";
    }

    public Bolsistas getBolsista() {
        return bolsista;
    }

    public void setBolsista(Bolsistas bolsista) {
        this.bolsista = bolsista;
    }

    public List<Bolsistas> getBolsistas() {
        return rn.listarTodos();

        //return bolsistaRN.listarAtivos(true);
    }

    public List<Bolsistas> getBolsistasInativos() {
        return rn.listarAtivos("inativo");

        //return bolsistaRN.listarAtivos(true);
    }

    public void setBolsistas(List<Bolsistas> bolsistas) {
        this.bolsistas = bolsistas;
    }

    public String novo() {
        System.out.println("Novo Bolsista");
        bolsista = rn.novo();
        System.out.println("Novo Bolsista 2");
        return "/sistema/cadastro/bolsista/novo.xhtml";
    }

    public String irInativo() {
        bolsista = rn.novo();
        return "/sistema/cadastro/bolsista/lista-inativo.xhtml";
    }

    public String alterar() {
        return "/sistema/cadastro/bolsista/novo.xhtml";
    }

    public String irInativar() {
        return "/sistema/cadastro/bolsista/lista-inativo.xhtml";
    }

    public String cancelar() {
        return "/sistema/cadastro/bolsista/lista.xhtml";
    }

    public ArrayList<String> getSituacao() {
        situacao.add("Ativo");
        situacao.add("Inativo");
        return situacao;
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
