/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.AlunosColaboradores;
import br.ufra.rn.AlunosColaboradoresRN;
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
public class AlunosColaboradoresBean {

    private AlunosColaboradores alunosColaboradores = new AlunosColaboradores();
    private AlunosColaboradoresRN rn = new AlunosColaboradoresRN();
    private List<AlunosColaboradores> lista;
    ArrayList<String> situacao = new ArrayList<String>();

    public AlunosColaboradores getAlunosColaboradores() {
        return alunosColaboradores;
    }

    public void setAlunosColaboradores(AlunosColaboradores alunosColaboradores) {
        this.alunosColaboradores = alunosColaboradores;
    }

    public List<AlunosColaboradores> getLista() {
        lista = rn.listarTodos();
        return lista;
    }

    public void setLista(List<AlunosColaboradores> lista) {
        this.lista = lista;
    }

    public String novo() {
        alunosColaboradores = rn.novo();
        return "/sistema/cadastro/colaboradores/aluno/novo.xhtml";
    }

    public String alterar() {
        return "/sistema/cadastro/colaboradores/aluno/novo.xhtml";
    }

    public String listar() {
        return "/sistema/cadastro/colaboradores/aluno/lista.xhtml";
    }

    public String cancelar() {
        return "/sistema/cadastro/colaboradores/aluno/lista.xhtml";
    }

    public ArrayList<String> getSituacao() {
        situacao.add("Ativo");
        situacao.add("Inativo");
        return situacao;
    }

    public String salvar() {
        alunosColaboradores.setStatus(0);
        if (rn.salvar(alunosColaboradores)) {

            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operação realizada com sucesso!",
                    null));
            return "/sistema/cadastro/colaboradores/aluno/lista.xhtml";
        } else {
            FacesContext.getCurrentInstance().
                    addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Ocorreu um erro inesperado ao tentar salvar dados.",
                    null));
            return "/sistema/cadastro/colaboradores/aluno/novo.xhtml";
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
