package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.InstituicaoEnsSuperior;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class InstituicaoEnsSuperiorRN {

    private static final GenericDAOImpl<InstituicaoEnsSuperior> dao = new GenericDAOImpl<InstituicaoEnsSuperior>();

    public InstituicaoEnsSuperiorRN() {
    }

    public InstituicaoEnsSuperior novo() {
        return new InstituicaoEnsSuperior();
    }

    public boolean salvar(InstituicaoEnsSuperior x) {
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

    public boolean excluir(InstituicaoEnsSuperior x) {
        return dao.deletar(x);
    }

    public InstituicaoEnsSuperior buscar(Integer id){
        return dao.recuperar(InstituicaoEnsSuperior.class, id);
    }
    
    public List<InstituicaoEnsSuperior> listar() {
        return dao.listar(InstituicaoEnsSuperior.class);
    }
}
