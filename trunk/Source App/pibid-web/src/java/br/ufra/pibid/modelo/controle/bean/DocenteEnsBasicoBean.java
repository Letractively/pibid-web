package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import br.ufra.pibid.modelo.rn.InstituicaoEnsBasicoRN;
import br.ufra.pibid.modelo.rn.DocenteEnsBasicoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@RequestScoped
public class DocenteEnsBasicoBean {

    private static final DocenteEnsBasicoRN rn = new DocenteEnsBasicoRN();
    
    private DocenteEnsBasico docenteEnsBasico = new DocenteEnsBasico();
    private List<DocenteEnsBasico> docentesEnsBasico;
    private List<InstituicaoEnsBasico> escolas;
    
    public DocenteEnsBasicoBean() {
    }

    public DocenteEnsBasico getDocenteEnsBasico() {
        return docenteEnsBasico;
    }

    public void setDocenteEnsBasico(DocenteEnsBasico docenteEnsBasico) {
        this.docenteEnsBasico = docenteEnsBasico;
    }

    public List<DocenteEnsBasico> getDocentesEnsBasico() {
        if (docentesEnsBasico == null){
            docentesEnsBasico = rn.listar();
        }
        return docentesEnsBasico;
    }

    public void setDocentesEnsBasico(List<DocenteEnsBasico> docentesEnsBasico) {
        this.docentesEnsBasico = docentesEnsBasico;
    }

    public List<InstituicaoEnsBasico> getEscolas() {
        if (escolas == null){
            escolas = new InstituicaoEnsBasicoRN().listar();
        }
        return escolas;
    }

    public void setEscolas(List<InstituicaoEnsBasico> escolas) {
        this.escolas = escolas;
    }
    
    
    public String novo(){
        docenteEnsBasico = null;
        docenteEnsBasico =  rn.novo();
        return "/restrito/docente-ensino-basico/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/docente-ensino-basico/cadastro.xhtml";
    }
    
    public String excluir(){
        rn.excluir(docenteEnsBasico);
        return listagem();
    }
    
    public String listagem(){
        return "/restrito/docente-ensino-basico/listagem.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        rn.salvar(docenteEnsBasico);
        
        docenteEnsBasico  = null;
        docentesEnsBasico = null;
        
        return listagem();
    }
}
