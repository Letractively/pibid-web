package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import br.ufra.pibid.modelo.rn.InstituicaoEnsBasicoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@RequestScoped
public class InstituicaoEnsBasicoBean {

    private static final InstituicaoEnsBasicoRN rn = new InstituicaoEnsBasicoRN();
    
    private InstituicaoEnsBasico escola = new InstituicaoEnsBasico();
    private List<InstituicaoEnsBasico> escolas;
    
    public InstituicaoEnsBasicoBean() {
    }

    public InstituicaoEnsBasico getEscola() {
        return escola;
    }

    public void setEscola(InstituicaoEnsBasico escola) {
        this.escola = escola;
    }

    public List<InstituicaoEnsBasico> getEscolas() {
        if (escolas == null){
            escolas = rn.listar();
        }
        return escolas;
    }

    public void setEscolas(List<InstituicaoEnsBasico> escolas) {
        this.escolas = escolas;
    }
    
    
    public String novo(){
        escola = null;
        escola =  rn.novo();
        return "/restrito/instituicao-ensino-basico/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/instituicao-ensino-basico/cadastro.xhtml";
    }
    
    public String listagem(){
        return "/restrito/instituicao-ensino-basico/listagem.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        rn.salvar(escola);
        
        escola  = null;
        escolas = null;
        
        return listagem();
    }
}
