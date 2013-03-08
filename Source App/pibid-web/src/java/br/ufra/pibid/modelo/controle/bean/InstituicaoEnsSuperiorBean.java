package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsSuperior;
import br.ufra.pibid.modelo.rn.InstituicaoEnsSuperiorRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@RequestScoped
public class InstituicaoEnsSuperiorBean {

    private static final InstituicaoEnsSuperiorRN rn = new InstituicaoEnsSuperiorRN();
    
    private InstituicaoEnsSuperior instituicao = new InstituicaoEnsSuperior();
    private List<InstituicaoEnsSuperior> instituicoes;
    
    public InstituicaoEnsSuperiorBean() {
    }

    public InstituicaoEnsSuperior getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(InstituicaoEnsSuperior instituicao) {
        this.instituicao = instituicao;
    }

    public List<InstituicaoEnsSuperior> getInstituicoes() {
        if (instituicoes == null){
            instituicoes = rn.listar();
        }
        return instituicoes;
    }

    public void setInstituicoes(List<InstituicaoEnsSuperior> instituicoes) {
        this.instituicoes = instituicoes;
    }
    
    
    public String novo(){
        instituicao = null;
        instituicao =  rn.novo();
        return "/restrito/instituicao-ensino-superior/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/instituicao-ensino-superior/cadastro.xhtml";
    }
    
    public String listagem(){
        return "/restrito/instituicao-ensino-superior/listagem.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        rn.salvar(instituicao);
        
        instituicao  = null;
        instituicoes = null;
        
        return listagem();
    }
}
