/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividadePK;
import br.ufra.pibid.modelo.entidade.Supervisor;
import br.ufra.pibid.modelo.rn.DiscenteRN;
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
public class AtividadeAlunoBolsistaBean {
    
    private ResponsavelAtividadePK respPK;
    private DiscenteRN rn = new DiscenteRN();
    private ResponsavelAtividade responsavelatividade = new ResponsavelAtividade();
    private ResponsavelAtividadeRN resrn = new ResponsavelAtividadeRN();
    private Atividade atividade = new Atividade();
    private List<Discente> estaonoprojeto = new ArrayList<Discente>();
    private List<Discente> naoestaonoprojeto = new ArrayList<Discente>();
    private DualListModel<Discente> discentes;
    
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
    
    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }
    
    public String novo() {
        responsavelatividade = resrn.novo();
        return "/restrito/projeto/movimentacao/bolsista/cadastro2.xhtml";
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
        List<ProfessorColaborador> docentescolaboradores = atividade.getProjeto().getProfessorColaboradorList();
        for (ProfessorColaborador docenteEnsSuperior : docentescolaboradores) {
            respPK.setDocente(docenteEnsSuperior.getDocenteEnsSuperior().getId());
        }
        List<AlunoColaborador> alunocolaborador = atividade.getProjeto().getAlunoColaboradorList();
        for (AlunoColaborador aluno : alunocolaborador) {
            respPK.setDiscente(aluno.getDiscente1().getId());
        }
        estaonoprojeto = discentes.getTarget();
        naoestaonoprojeto = discentes.getSource();
        for (Discente discente : naoestaonoprojeto) {
            discente.setStatusAtividade(0);
            rn.salvar(discente);
        }
        for (Discente discente : estaonoprojeto) {
            
            discente.setStatusAtividade(1);
            
            respPK.setDiscente(discente.getId());
            respPK.setAtividade(atividade.getId());
            if (discente.getStatus() == 1) {
                respPK.setBolsista(discente.getId());
            }
            responsavelatividade.setResponsavelAtividadePK(respPK);
            rn.salvar(discente);
            resrn.salvar(responsavelatividade);
            
        }
        return atribuir();
    }
    
    public AtividadeAlunoBolsistaBean() {
        estaonoprojeto = rn.buscarStatusAtividade(1);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarStatusAtividade(0);
        discentes = new DualListModel<Discente>(naoestaonoprojeto, estaonoprojeto);
    }
}
