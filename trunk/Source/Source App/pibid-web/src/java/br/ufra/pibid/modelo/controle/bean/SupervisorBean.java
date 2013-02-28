/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.AlunoColaboradorPK;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.AlunoColaboradorRN;
import br.ufra.pibid.modelo.rn.DiscenteRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Dir de Armas Marinha
 */
@ManagedBean
@RequestScoped
public class SupervisorBean {

    private AlunoColaboradorPK alunopk;
    private AlunoColaborador alunocolaborador = new AlunoColaborador();
    private AlunoColaboradorRN arn = new AlunoColaboradorRN();
    private DiscenteRN rn = new DiscenteRN();
    private Projeto projeto = new Projeto();
    List<Discente> source = rn.listar();
    List<Discente> target = new ArrayList<Discente>();
    private DualListModel<Discente> discentes = new DualListModel<Discente>(source, target);

    public DualListModel<Discente> getDiscentes() {
        return discentes;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public void setDiscentes(DualListModel<Discente> discentes) {
        this.discentes = discentes;
    }


    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }

    public String salvar() {
        for (Discente discente : source) {
            alunopk = new AlunoColaboradorPK();
            alunopk.setDiscente(discente.getId());
            alunopk.setProjeto(projeto.getId());
            arn.salvar(alunocolaborador);
        }
        return listagem();
    }
}
