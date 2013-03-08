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
public class AlunoColaboradorBean {

    private AlunoColaboradorPK alunocolPK;
    private AlunoColaborador alunocolaborador = new AlunoColaborador();
    private AlunoColaboradorRN arn = new AlunoColaboradorRN();
    private DiscenteRN rn = new DiscenteRN();
    private Projeto projeto = new Projeto();
    private List<Discente> estaonoprojeto = new ArrayList<Discente>();
    private List<Discente> naoestaonoprojeto = new ArrayList<Discente>();
    private DualListModel<Discente> discentes;

    public AlunoColaborador getAlunocolaborador() {
        return alunocolaborador;
    }

    public void setAlunocolaborador(AlunoColaborador alunocolaborador) {
        this.alunocolaborador = alunocolaborador;
    }

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


    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }

    public String novo() {
        alunocolaborador = arn.novo();
        return "/restrito/projeto/movimentacao/aluno-colaborador/cadastro.xhtml";
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

            discente.setStatus(2);
            alunocolPK = new AlunoColaboradorPK();
            alunocolPK.setDiscente(discente.getId());
            alunocolPK.setProjeto(projeto.getId());
            alunocolaborador.setAlunoColaboradorPK(alunocolPK);
            rn.salvar(discente);
            arn.salvar(alunocolaborador);

        }
        return atribuir();
    }

    public AlunoColaboradorBean() {
        estaonoprojeto = rn.buscarStatusProjeto(2);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarStatusProjeto(0);
        discentes = new DualListModel<Discente>(naoestaonoprojeto, estaonoprojeto);
    }
}
