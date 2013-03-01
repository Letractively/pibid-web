package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.Curso;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class CursoRN {

    private static final GenericDAOImpl<Curso> dao = new GenericDAOImpl<Curso>();

    public CursoRN() {
    }

    public Curso novo() {
        return new Curso();
    }

    public boolean salvar(Curso x) {
        if (x.getId() == null) {
            try {
                return dao.registrar(x);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
                return false;
            }
        } else {
            return dao.atualizar(x);
        }
    }

    public boolean excluir(Curso x) {
        return dao.deletar(x);
    }

    public Curso buscar(Integer id){
        return dao.recuperar(Curso.class, id);
    }
    
    public List<Curso> listar() {
        return dao.listar(Curso.class);
    }
}
