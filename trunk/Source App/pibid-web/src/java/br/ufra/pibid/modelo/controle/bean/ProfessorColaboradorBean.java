/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import br.ufra.pibid.modelo.entidade.ProfessorColaboradorPK;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.DocenteEnsSuperiorRN;
import br.ufra.pibid.modelo.rn.ProfessorColaboradorRN;
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
public class ProfessorColaboradorBean {

    private ProfessorColaboradorPK prcPK;
    private DocenteEnsSuperiorRN rn = new DocenteEnsSuperiorRN();
    private ProfessorColaboradorRN prn = new ProfessorColaboradorRN();
    private ProfessorColaborador professorcolaborador = new ProfessorColaborador();
    private Projeto projeto = new Projeto();
    private List<DocenteEnsSuperior> estaonoprojeto = new ArrayList<DocenteEnsSuperior>();
    private List<DocenteEnsSuperior> naoestaonoprojeto = new ArrayList<DocenteEnsSuperior>();
    private DualListModel<DocenteEnsSuperior> docentes;

    public ProfessorColaborador getProfessorcolaborador() {
        return professorcolaborador;
    }

    public void setProfessorcolaborador(ProfessorColaborador professorcolaborador) {
        this.professorcolaborador = professorcolaborador;
    }

    public List<DocenteEnsSuperior> getEstaonoprojeto() {
        return estaonoprojeto;
    }

    public void setEstaonoprojeto(List<DocenteEnsSuperior> estaonoprojeto) {
        this.estaonoprojeto = estaonoprojeto;
    }

    public List<DocenteEnsSuperior> getNaoestaonoprojeto() {
        return naoestaonoprojeto;
    }

    public void setNaoestaonoprojeto(List<DocenteEnsSuperior> naoestaonoprojeto) {
        this.naoestaonoprojeto = naoestaonoprojeto;
    }

    public DualListModel<DocenteEnsSuperior> getDocentes() {
        return docentes;
    }

    public void setDocentes(DualListModel<DocenteEnsSuperior> docentes) {
        this.docentes = docentes;
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
        professorcolaborador = prn.novo();
        return "/restrito/projeto/movimentacao/professor-colaborador/cadastro.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastro.xhtml";
    }

    public String salvar() {
        estaonoprojeto = docentes.getTarget();
        naoestaonoprojeto = docentes.getSource();
        for (DocenteEnsSuperior docente : naoestaonoprojeto) {
            docente.setStatus(0);
            rn.salvar(docente);
        }
        for (DocenteEnsSuperior docente : estaonoprojeto) {

            docente.setStatus(1);
            prcPK = new ProfessorColaboradorPK();
            prcPK.setDocente(docente.getId());
            prcPK.setProjeto(projeto.getId());
            professorcolaborador.setProfessorColaboradorPK(prcPK);
            rn.salvar(docente);
            prn.salvar(professorcolaborador);

        }
        return atribuir();
    }

    public ProfessorColaboradorBean() {
        estaonoprojeto = rn.buscarPorStatus(1);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarPorStatus(0);
        docentes = new DualListModel<DocenteEnsSuperior>(naoestaonoprojeto, estaonoprojeto);
    }
}
