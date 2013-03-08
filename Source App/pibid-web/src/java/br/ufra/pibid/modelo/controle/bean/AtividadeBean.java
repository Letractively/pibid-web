package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.AtividadeRN;
import br.ufra.pibid.modelo.rn.ProjetoRN;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@RequestScoped
public class AtividadeBean {

    private static final AtividadeRN rn = new AtividadeRN();
    private Atividade atividade = new Atividade();
    private List<Atividade> atividades;
    private List<Projeto> projetos;

    public AtividadeBean() {
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public List<Atividade> getAtividades() {
        if (atividades == null) {
            atividades = rn.listar();
        }
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Projeto> getProjetos() {
        if (projetos == null) {
            projetos = new ProjetoRN().listar();
        }
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public String novo() {
        atividade = null;
        atividade = rn.novo();
        return "/restrito/projeto/atividade/cadastro.xhtml?faces-redirect=true";
    }

    public String alterar() {
        return "/restrito/projeto/atividade/cadastro.xhtml";
    }

    public String listagem() {
        return "/restrito/projeto/atividade/listagem.xhtml?faces-redirect=true";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastroAtividade.xhtml";
    }

    public String salvar() {

        atividade.setCadastro(new Date());
        rn.salvar(atividade);

        atividade = null;
        atividades = null;

        return listagem();
    }
}
