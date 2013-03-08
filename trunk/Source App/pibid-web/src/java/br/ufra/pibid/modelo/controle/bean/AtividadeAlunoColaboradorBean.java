package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividadePK;
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
public class AtividadeAlunoColaboradorBean {

    private final ResponsavelAtividadeRN rn = new ResponsavelAtividadeRN();
    private final ResponsavelAtividadePK respPK = new ResponsavelAtividadePK();
    private ResponsavelAtividade responsavelatividade = new ResponsavelAtividade();
    private List<Discente> discentesVinculados = new ArrayList<Discente>();
    private List<Discente> discentesDesvinculados = new ArrayList<Discente>();
    private DualListModel<Discente> alunosColaboradores;

    public AtividadeAlunoColaboradorBean() {
    }

    public ResponsavelAtividade getResponsavelatividade() {
        return responsavelatividade;
    }

    public void setResponsavelatividade(ResponsavelAtividade responsavelatividade) {
        this.responsavelatividade = responsavelatividade;
    }

    public List<Discente> getDiscentesVinculados() {
        if (discentesVinculados == null) {
            discentesVinculados = new DiscenteRN().buscarStatusProjeto(1);
        }
        return discentesVinculados;
    }

    public void setDiscentesVinculados(List<Discente> discentesVinculados) {
        this.discentesVinculados = discentesVinculados;
    }

    public List<Discente> getDiscentesDesvinculados() {
        if (discentesDesvinculados == null) {
            discentesDesvinculados = new DiscenteRN().listar();
        }
        return discentesDesvinculados;
    }

    public void setDiscentesDesvinculados(List<Discente> discentesDesvinculados) {
        this.discentesDesvinculados = discentesDesvinculados;
    }

    public DualListModel<Discente> getAlunosColaboradores() {
        return alunosColaboradores;
    }

    public void setAlunosColaboradores(DualListModel<Discente> alunosColaboradores) {
        this.alunosColaboradores = alunosColaboradores;
    }

    public String listagem() {
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }

    public String novo() {
        responsavelatividade = rn.novo();
        return "/restrito/projeto/movimentacao/aluno-colaborador/cadastro2.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastro2.xhtml";
    }

    public String salvar() {
        discentesVinculados = alunosColaboradores.getTarget();
        discentesDesvinculados = alunosColaboradores.getSource();
        for (Discente colaborador : discentesDesvinculados) {
            responsavelatividade.setDiscente1(colaborador);
            rn.salvar(responsavelatividade);
        }
        for (Discente discente : discentesVinculados) {
            discente.setStatusAtividade(2);
            respPK.setAtividade(responsavelatividade.getAtividade1().getId());
            respPK.setDiscente(discente.getId());
            responsavelatividade.setResponsavelAtividadePK(respPK);
            rn.salvar(responsavelatividade);

        }
        return atribuir();
    }

    public void AtividadeAlunoColaboradorBean() {
        DiscenteRN alunoRN = new DiscenteRN();
        discentesVinculados = alunoRN.buscarStatusAtividade(2);
        discentesDesvinculados = alunoRN.buscarStatusProjeto(0);
        alunosColaboradores = new DualListModel<Discente>(discentesDesvinculados, discentesVinculados);
    }
}
