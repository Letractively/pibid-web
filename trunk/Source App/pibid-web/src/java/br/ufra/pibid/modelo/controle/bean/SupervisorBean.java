/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.entidade.Supervisor;
import br.ufra.pibid.modelo.entidade.SupervisorPK;
import br.ufra.pibid.modelo.rn.DocenteEnsBasicoRN;
import br.ufra.pibid.modelo.rn.SupervisorRN;
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

    private SupervisorPK sPK;
    private DocenteEnsBasicoRN rn = new DocenteEnsBasicoRN();
    private SupervisorRN srn = new SupervisorRN();
    private Supervisor supervisor = new Supervisor();
    private Projeto projeto = new Projeto();
    private List<DocenteEnsBasico> estaonoprojeto = new ArrayList<DocenteEnsBasico>();
    private List<DocenteEnsBasico> naoestaonoprojeto = new ArrayList<DocenteEnsBasico>();
    private DualListModel<DocenteEnsBasico> docentes;

    public DualListModel<DocenteEnsBasico> getDocentes() {
        return docentes;
    }

    public void setDocentes(DualListModel<DocenteEnsBasico> docentes) {
        this.docentes = docentes;
    }

    public List<DocenteEnsBasico> getEstaonoprojeto() {
        return estaonoprojeto;
    }

    public void setEstaonoprojeto(List<DocenteEnsBasico> estaonoprojeto) {
        this.estaonoprojeto = estaonoprojeto;
    }

    public List<DocenteEnsBasico> getNaoestaonoprojeto() {
        return naoestaonoprojeto;
    }

    public void setNaoestaonoprojeto(List<DocenteEnsBasico> naoestaonoprojeto) {
        this.naoestaonoprojeto = naoestaonoprojeto;
    }

    public DualListModel<DocenteEnsBasico> getDocente() {
        return docentes;
    }

    public void setDocente(DualListModel<DocenteEnsBasico> docentes) {
        this.docentes = docentes;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
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
        supervisor = srn.novo();
        return "/restrito/projeto/movimentacao/supervisor/cadastro.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastro.xhtml";
    }

    public String salvar() {
        estaonoprojeto = docentes.getTarget();
        naoestaonoprojeto = docentes.getSource();
        for (DocenteEnsBasico inst : naoestaonoprojeto) {
            inst.setStatus(0);
            rn.salvar(inst);
        }
        for (DocenteEnsBasico inst : estaonoprojeto) {

            inst.setStatus(1);
            sPK = new SupervisorPK();
            sPK.setSupervisor(inst.getId());
            sPK.setProjeto(projeto.getId());
            supervisor.setSupervisorPK(sPK);
            rn.salvar(inst);
            srn.salvar(supervisor);

        }
        return atribuir();
    }

    public SupervisorBean() {
        estaonoprojeto = rn.buscarPorStatus(1);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarPorStatus(0);
        docentes = new DualListModel<DocenteEnsBasico>(naoestaonoprojeto, estaonoprojeto);
    }
}
