package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Curso;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.CursoRN;
import br.ufra.pibid.modelo.rn.DocenteEnsSuperiorRN;
import br.ufra.pibid.modelo.rn.InstituicaoRN;
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
public class ProjetoBean {

    private static final ProjetoRN rn = new ProjetoRN();
    
    private Projeto projeto = new Projeto();
    private List<Projeto> projetos;
    private List<Instituicao> instituicoes;
    private List<DocenteEnsSuperior> professores;
    private List<Curso> cursos;
    
    public ProjetoBean() {
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        if (projetos == null){
            projetos = rn.listar();
        }
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public List<Curso> getCursos() {
        if (cursos == null){
            cursos = new CursoRN().listar();
        }
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
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

    public List<DocenteEnsSuperior> getProfessores() {
        if (professores == null){
            professores = new DocenteEnsSuperiorRN().listar();
        }
        return professores;
    }

    public void setProfessores(List<DocenteEnsSuperior> professores) {
        this.professores = professores;
    }
    
    
    public String novo(){
        projeto = null;
        projeto =  rn.novo();
        return "/restrito/projeto/cadastro.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        return "/restrito/projeto/cadastro.xhtml";
    }
    
    public String listagem(){
        return "/restrito/projeto/listagem.xhtml?faces-redirect=true";
    }
    
    public String atribuir(){
      return "/restrito/projeto/movimentacao/bolsista/cadastro.xhtml";  
    }
    
    public String salvar(){
        
        rn.salvar(projeto);
        
        projeto  = null;
        projetos = null;
        
        return listagem();
    }
}
