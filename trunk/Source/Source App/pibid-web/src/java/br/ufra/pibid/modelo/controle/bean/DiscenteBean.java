package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.rn.DiscenteRN;
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
public class DiscenteBean {

    private static final DiscenteRN rn = new DiscenteRN();
    
    private Discente discente = new Discente();
    private List<Discente> discentes;
    private List<Instituicao> instituicoes;
    
    public DiscenteBean() {
    }

    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    public List<Discente> getDiscentes() {
        if (discentes == null){
            discentes = rn.listar();
        }
        return discentes;
    }

    public void setDiscentes(List<Discente> discentes) {
        this.discentes = discentes;
    }

    public List<Instituicao> getInstituicoes() {
        if (instituicoes == null){
            instituicoes = new InstituicaoRN().listar();
        }
        return instituicoes;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        this.instituicoes = instituicoes;
    }
    
    
    public String novo(){
        discente = null;
        discente =  rn.novo();
        return "/restrito/discente/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/discente/cadastro.xhtml";
    }
    
    public String listagem(){
        return "/restrito/discente/listagem.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        
        rn.salvar(discente);
        
        discente  = null;
        discentes = null;
        
        return listagem();
    }
}
