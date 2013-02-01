/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.ProfessoresColaboradores;
import br.ufra.rn.ProfessoresColaboradoresRN;
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
public class ProfColaboradoresBean {

    private ProfessoresColaboradores professoresColaboradores = new ProfessoresColaboradores();
    private ProfessoresColaboradoresRN rn = new ProfessoresColaboradoresRN();
    private List<ProfessoresColaboradores> lista;
    ArrayList<String> situacao = new ArrayList<String>();

    public ProfessoresColaboradores getProfessoresColaboradores() {
        return professoresColaboradores;
    }

    public void setProfessoresColaboradores(ProfessoresColaboradores professoresColaboradores) {
        this.professoresColaboradores = professoresColaboradores;
    }

    public List<ProfessoresColaboradores> getLista() {
        lista = rn.listarTodos();
        return lista;
    }

    public void setLista(List<ProfessoresColaboradores> lista) {
        this.lista = lista;
    }

    public String novo() {
        professoresColaboradores = rn.novo();
        return "/sistema/cadastro/colaboradores/novo.xhtml";
    }

    public String alterar() {
        return "/sistema/cadastro/colaboradores/novo.xhtml";
    }

    public String listar() {
        return "/sistema/cadastro/colaboradores/lista.xhtml";
    }

    public String cancelar() {
        return "/sistema/cadastro/colaboradores/lista.xhtml";
    }

    public ArrayList<String> getSituacao() {
        situacao.add("Ativo");
        situacao.add("Inativo");
        return situacao;
    }

    public String salvar() {
        if (rn.salvar(professoresColaboradores)) {
          
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operação realizada com sucesso!",
                    null));
            return "/sistema/cadastro/colaboradores/lista.xhtml";
        } else {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Ocorreu um erro inesperado ao tentar salvar dados.",
                    null));
            return "/sistema/cadastro/colaboradores/novo.xhtml";
        }

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
