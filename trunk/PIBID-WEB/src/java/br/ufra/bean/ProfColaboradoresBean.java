/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.ProfessoresColaboradores;
import br.ufra.rn.ProfessoresColaboradoresRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author marcos
 */
public class ProfColaboradoresBean {
    
    private ProfessoresColaboradores professoresColaboradores = new ProfessoresColaboradores();
    private ProfessoresColaboradoresRN rn = new ProfessoresColaboradoresRN();
    private List<ProfessoresColaboradores> lista;

    public ProfessoresColaboradores getProfessoresColaboradores() {
        return professoresColaboradores;
    }

    public void setProfessoresColaboradores(ProfessoresColaboradores professoresColaboradores) {
        this.professoresColaboradores = professoresColaboradores;
    }

    public List<ProfessoresColaboradores> getLista() {
        return lista;
    }

    public void setLista(List<ProfessoresColaboradores> lista) {
        this.lista = lista;
    }

    public String novo() {
        professoresColaboradores = rn.novo();
        return "/sistema/cadastro/colaboradores/novo-colaborador.xhtml";
    }

    public String alterar() {
        return "/sistema/cadastro/colaboradores/novo-colaborador.xhtml";
    }

    public String listar() {
        return "/sistema/cadastro/colaboradores/lista-colaboradores.xhtml";
    }

    public String salvar() {
        if (rn.salvar(professoresColaboradores)) {
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
