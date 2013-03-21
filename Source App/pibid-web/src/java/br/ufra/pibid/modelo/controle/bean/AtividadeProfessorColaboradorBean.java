/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividadePK;
import br.ufra.pibid.modelo.entidade.Supervisor;
import br.ufra.pibid.modelo.rn.DocenteEnsSuperiorRN;
import br.ufra.pibid.modelo.rn.ResponsavelAtividadeRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.DualListModel;

/**
 *
 * @author marcos
 */
@ManagedBean
@RequestScoped
public class AtividadeProfessorColaboradorBean {

    private ResponsavelAtividadePK respPK;
    private DocenteEnsSuperiorRN rn = new DocenteEnsSuperiorRN();
    private ResponsavelAtividade responsavelatividade = new ResponsavelAtividade();
    private ResponsavelAtividadeRN resrn = new ResponsavelAtividadeRN();
    private Atividade atividade = new Atividade();
    private List<DocenteEnsSuperior> estaonoprojeto = new ArrayList<DocenteEnsSuperior>();
    private List<DocenteEnsSuperior> naoestaonoprojeto = new ArrayList<DocenteEnsSuperior>();
    private DualListModel<DocenteEnsSuperior> docentes;

    public ResponsavelAtividade getResponsavelatividade() {
        return responsavelatividade;
    }

    public void setResponsavelatividade(ResponsavelAtividade responsavelatividade) {
        this.responsavelatividade = responsavelatividade;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
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

    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }

    public String novo() {
        responsavelatividade = resrn.novo();
        return "/restrito/projeto/movimentacao/professor-colaborador/cadastro2.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastroAtividade.xhtml";
    }

    public String salvar() {
        respPK = new ResponsavelAtividadePK();
        List<Supervisor> docentessupervisores = atividade.getProjeto().getSupervisorList();
        for (Supervisor docenteEnsBasico : docentessupervisores) {
            respPK.setSupervisor(docenteEnsBasico.getDocenteEnsBasico().getId());

        }
        List<AlunoColaborador> alunocolaborador = atividade.getProjeto().getAlunoColaboradorList();
        for (AlunoColaborador aluno : alunocolaborador) {
            respPK.setDiscente(aluno.getDiscente1().getId());
        }
        List<Bolsista> bolsista = atividade.getProjeto().getBolsistaList();
        for (Bolsista bolsista1 : bolsista) {
            respPK.setBolsista(bolsista1.getDiscente1().getId());
        }
        estaonoprojeto = docentes.getTarget();
        naoestaonoprojeto = docentes.getSource();
        for (DocenteEnsSuperior docentees : naoestaonoprojeto) {
            docentees.setStatusAtividade(0);
            rn.salvar(docentees);
        }
        for (DocenteEnsSuperior docentees : estaonoprojeto) {

            docentees.setStatusAtividade(1);

            respPK.setDocente(docentees.getId());
            respPK.setAtividade(atividade.getId());
            if (docentees.getStatusAtividade() == 1) {
                respPK.setDocente(docentees.getId());
            }
            responsavelatividade.setResponsavelAtividadePK(respPK);
            rn.salvar(docentees);
            resrn.salvar(responsavelatividade);

        }
        return atribuir();
    }

    public AtividadeProfessorColaboradorBean() {
        estaonoprojeto = rn.buscarStatusAtividade(1);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarStatusAtividade(0);
        docentes = new DualListModel<DocenteEnsSuperior>(naoestaonoprojeto, estaonoprojeto);
    }
}
