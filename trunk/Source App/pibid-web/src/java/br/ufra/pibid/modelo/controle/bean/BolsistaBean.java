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
    private List<Discente> estaonoprojeto = new ArrayList<Discente>();
    private List<Discente> naoestaonoprojeto = new ArrayList<Discente>();
    private DualListModel<Discente> discentes;

    public List<Discente> getEstaonoprojeto() {
        return estaonoprojeto;
    }

    public void setEstaonoprojeto(List<Discente> estaonoprojeto) {
        this.estaonoprojeto = estaonoprojeto;
    }

    public List<Discente> getNaoestaonoprojeto() {
        return naoestaonoprojeto;
    }

    public void setNaoestaonoprojeto(List<Discente> naoestaonoprojeto) {
        this.naoestaonoprojeto = naoestaonoprojeto;
    }

    public DualListModel<Discente> getDiscentes() {
        return discentes;
    }

    public void setDiscentes(DualListModel<Discente> discentes) {
        this.discentes = discentes;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
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

    public String novo() {
        bolsista = brn.novo();
        return "/restrito/projeto/movimentacao/bolsista/cadastro.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastro.xhtml";
    }

    public String salvar() {
        estaonoprojeto = discentes.getTarget();
        naoestaonoprojeto = discentes.getSource();
        for (Discente discente : naoestaonoprojeto) {
            discente.setStatus(0);
            rn.salvar(discente);
        }
        for (Discente discente : estaonoprojeto) {

            discente.setStatus(1);
            bolsistaPK = new BolsistaPK();
            bolsistaPK.setDiscente(discente.getId());
            bolsistaPK.setProjeto(projeto.getId());
            bolsista.setBolsistaPK(bolsistaPK);
            rn.salvar(discente);
            brn.salvar(bolsista);

        }
        return atribuir();
    }

    public BolsistaBean() {
        estaonoprojeto = rn.buscarPorStatus(1);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarPorStatus(0);
        discentes = new DualListModel<Discente>(naoestaonoprojeto, estaonoprojeto);
    }
}
