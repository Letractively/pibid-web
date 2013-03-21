/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividadePK;
import br.ufra.pibid.modelo.rn.DocenteEnsBasicoRN;
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
public class AtividadeSupervisorBean {

    private ResponsavelAtividadePK respPK;
    private DocenteEnsBasicoRN rn = new DocenteEnsBasicoRN();
    private ResponsavelAtividade responsavelatividade = new ResponsavelAtividade();
    private ResponsavelAtividadeRN resrn = new ResponsavelAtividadeRN();
    private Atividade atividade = new Atividade();
    private List<DocenteEnsBasico> estaonoprojeto = new ArrayList<DocenteEnsBasico>();
    private List<DocenteEnsBasico> naoestaonoprojeto = new ArrayList<DocenteEnsBasico>();
    private DualListModel<DocenteEnsBasico> docentes;

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

    public DualListModel<DocenteEnsBasico> getDocentes() {
        return docentes;
    }

    public void setDocentes(DualListModel<DocenteEnsBasico> docentes) {
        this.docentes = docentes;
    }

    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }

    public String novo() {
        responsavelatividade = resrn.novo();
        return "/restrito/projeto/movimentacao/supervisor/cadastro2.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastroAtividade.xhtml";
    }

    public String salvar() {
        respPK = new ResponsavelAtividadePK();
        List<ProfessorColaborador> docentescolaboradores = atividade.getProjeto().getProfessorColaboradorList();
        for (ProfessorColaborador docenteEnsSuperior : docentescolaboradores) {
            respPK.setDocente(docenteEnsSuperior.getDocenteEnsSuperior().getId());
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
        for (DocenteEnsBasico docentees : naoestaonoprojeto) {
            docentees.setStatusAtividade(0);
            rn.salvar(docentees);
        }
        
        for (DocenteEnsBasico docentees : estaonoprojeto) {

            docentees.setStatusAtividade(2);

            respPK.setSupervisor(docentees.getId());
            respPK.setAtividade(atividade.getId());
            if (docentees.getStatusAtividade() == 2) {
                respPK.setSupervisor(docentees.getId());
            }
            responsavelatividade.setResponsavelAtividadePK(respPK);
            rn.salvar(docentees);
            resrn.salvar(responsavelatividade);

        }
        return atribuir();
    }

    public AtividadeSupervisorBean() {
        estaonoprojeto = rn.buscarStatusAtividade(2);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarStatusAtividade(0);
        docentes = new DualListModel<DocenteEnsBasico>(naoestaonoprojeto, estaonoprojeto);
    }
}
