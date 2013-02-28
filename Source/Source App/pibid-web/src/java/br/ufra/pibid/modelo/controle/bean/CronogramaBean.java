package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Cronograma;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.CronogramaRN;
import br.ufra.pibid.modelo.rn.ProjetoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@RequestScoped
public class CronogramaBean {

    private static final CronogramaRN rn = new CronogramaRN();
    
    private Cronograma cronograma = new Cronograma();
    private List<Cronograma> cronogramas;
    private List<Projeto> projetos;
    
    public CronogramaBean() {
    }

    public Cronograma getCronograma() {
        return cronograma;
    }

    public void setCronograma(Cronograma cronograma) {
        this.cronograma = cronograma;
    }

    public List<Cronograma> getCronogramas() {
        if(cronogramas==null){
            cronogramas = rn.listar();
        }
        return cronogramas;
    }

    public void setCronogramas(List<Cronograma> cronogramas) {
        this.cronogramas = cronogramas;
    }

    public List<Projeto> getProjetos() {
        if (projetos == null){
            projetos = new ProjetoRN().listar();
        }
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    
    public String novo(){
        cronograma = null;
        cronograma = rn.novo();
        return "/restrito/projeto/cronograma/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/projeto/cronograma/cadastro.xhtml";
    }
    
    public String listagem(){
        return "/restrito/projeto/cronograma/listagem.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        
        rn.salvar(cronograma);
        
        cronograma  = null;
        cronogramas = null;
        
        return listagem();
    }
}
