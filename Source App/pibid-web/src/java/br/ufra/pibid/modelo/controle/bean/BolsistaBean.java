/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.BolsistaPK;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.BolsistaRN;
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
public class BolsistaBean {

    private BolsistaPK bolsistaPK;
    private Bolsista bolsista = new Bolsista();
    private DiscenteRN rn = new DiscenteRN();
    private BolsistaRN brn = new BolsistaRN();
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

    public Bolsista getBolsista() {
        return bolsista;
    }

    public void setBolsista(Bolsista bolsista) {
        this.bolsista = bolsista;
    }

    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }

    public String salvar() {
        for (Discente discente : source) {
            bolsistaPK = new BolsistaPK();
            bolsistaPK.setDiscente(discente.getId());
            bolsistaPK.setProjeto(projeto.getId());
            brn.salvar(bolsista);
        }
        return listagem();
    }
}
