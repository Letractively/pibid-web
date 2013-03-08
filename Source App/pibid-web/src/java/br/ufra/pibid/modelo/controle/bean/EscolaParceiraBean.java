/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.EscolaParceira;
import br.ufra.pibid.modelo.entidade.EscolaParceiraPK;
import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.EscolaParceiraRN;
import br.ufra.pibid.modelo.rn.InstituicaoEnsBasicoRN;
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
public class EscolaParceiraBean {

    private EscolaParceiraPK espPK;
    private EscolaParceiraRN eprn = new EscolaParceiraRN();
    private InstituicaoEnsBasicoRN rn = new InstituicaoEnsBasicoRN();
    private InstituicaoEnsBasico instituicaobasico = new InstituicaoEnsBasico();
    private EscolaParceira escolaparceira = new EscolaParceira();
    private Projeto projeto = new Projeto();
    private List<InstituicaoEnsBasico> instituicoes;
    private List<InstituicaoEnsBasico> estaonoprojeto = new ArrayList<InstituicaoEnsBasico>();
    private List<InstituicaoEnsBasico> naoestaonoprojeto = new ArrayList<InstituicaoEnsBasico>();
    private DualListModel<InstituicaoEnsBasico> escolas;

    public InstituicaoEnsBasico getInstituicaobasico() {
        return instituicaobasico;
    }

    public void setInstituicaobasico(InstituicaoEnsBasico instituicaobasico) {
        this.instituicaobasico = instituicaobasico;
    }

    public List<InstituicaoEnsBasico> getEstaonoprojeto() {
        return estaonoprojeto;
    }

    public void setEstaonoprojeto(List<InstituicaoEnsBasico> estaonoprojeto) {
        this.estaonoprojeto = estaonoprojeto;
    }

    public List<InstituicaoEnsBasico> getNaoestaonoprojeto() {
        return naoestaonoprojeto;
    }

    public void setNaoestaonoprojeto(List<InstituicaoEnsBasico> naoestaonoprojeto) {
        this.naoestaonoprojeto = naoestaonoprojeto;
    }

    public DualListModel<InstituicaoEnsBasico> getEscolas() {
        return escolas;
    }

    public void setEscolas(DualListModel<InstituicaoEnsBasico> escolas) {
        this.escolas = escolas;
    }

    public List<InstituicaoEnsBasico> getInstituicoes() {
        if (instituicoes == null) {
            instituicoes = rn.listar();
        }
        return instituicoes;
    }

    public void setInstituicoes(List<InstituicaoEnsBasico> instituicoes) {
        this.instituicoes = instituicoes;
    }

    public EscolaParceira getEscolaparceira() {
        return escolaparceira;
    }

    public void setEscolaparceira(EscolaParceira escolaparceira) {
        this.escolaparceira = escolaparceira;
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
        escolaparceira = eprn.novo();
        return "/restrito/projeto/movimentacao/escola-parceira/cadastro.xhtml";
    }

    public String atribuir() {
        return "/restrito/projeto/movimentacao/cadastro.xhtml";
    }

    public String salvar() {
        estaonoprojeto = escolas.getTarget();
        naoestaonoprojeto = escolas.getSource();
        for (InstituicaoEnsBasico inst : naoestaonoprojeto) {
            inst.setStatus(0);
            rn.salvar(inst);
        }
        for (InstituicaoEnsBasico inst : estaonoprojeto) {

            inst.setStatus(1);
            espPK = new EscolaParceiraPK();
            espPK.setInstituicaoEnsBasico(inst.getId());
            espPK.setProjeto(projeto.getId());
            escolaparceira.setEscolaParceiraPK(espPK);
            rn.salvar(inst);
            eprn.salvar(escolaparceira);

        }
        return atribuir();
    }

    public EscolaParceiraBean() {
        estaonoprojeto = rn.buscarPorStatus(1);
        System.out.println(estaonoprojeto.size());
        naoestaonoprojeto = rn.buscarPorStatus(0);
        escolas = new DualListModel<InstituicaoEnsBasico>(naoestaonoprojeto, estaonoprojeto);
    }
}
