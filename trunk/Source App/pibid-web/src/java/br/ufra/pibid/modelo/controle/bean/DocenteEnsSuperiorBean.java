package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.rn.DocenteEnsSuperiorRN;
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
public class DocenteEnsSuperiorBean {

    private static final DocenteEnsSuperiorRN rn = new DocenteEnsSuperiorRN();
    
    private DocenteEnsSuperior docente = new DocenteEnsSuperior();
    private List<DocenteEnsSuperior> docentes;
    private List<Instituicao> instituicoes;
    
    public DocenteEnsSuperiorBean() {
    }

    public DocenteEnsSuperior getDocente() {
        return docente;
    }

    public void setDocente(DocenteEnsSuperior docente) {
        this.docente = docente;
    }

    public List<DocenteEnsSuperior> getDocentes() {
        if (docentes == null){
            docentes = rn.listar();
        }
        return docentes;
    }

    public void setDocentes(List<DocenteEnsSuperior> docentes) {
        this.docentes = docentes;
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
        docente = null;
        docente =  rn.novo();
        return "/restrito/docente-ensino-superior/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/docente-ensino-superior/cadastro.xhtml";
    }
    
    public String listagem(){
        return "/restrito/docente-ensino-superior/listagem.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        
        Instituicao inst = new InstituicaoRN().buscar(1);
        docente.setInstituicao(inst);
        docente.setStatus(0);
        rn.salvar(docente);
        
        docente  = null;
        docentes = null;
        
        return listagem();
    }
}
