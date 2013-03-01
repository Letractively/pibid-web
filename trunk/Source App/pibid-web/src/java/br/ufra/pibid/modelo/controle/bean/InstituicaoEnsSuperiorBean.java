package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.rn.InstituicaoRN;
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

    private static final InstituicaoRN rn = new InstituicaoRN();
    
    private Instituicao instituicao = new Instituicao();
    private List<Instituicao> instituicoes;
    
    public InstituicaoEnsSuperiorBean() {
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Instituicao> getInstituicoes() {
        if (instituicoes == null){
            instituicoes = rn.listar();
        }
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
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
