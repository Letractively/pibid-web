package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.Instituicao;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class InstituicaoRN {

    private static final GenericDAOImpl<Instituicao> dao = new GenericDAOImpl<Instituicao>();

    public InstituicaoRN() {
    }

    public Instituicao novo() {
        return new Instituicao();
    }

    public boolean salvar(Instituicao x) {
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

    public boolean excluir(Instituicao x) {
        return dao.deletar(x);
    }

    public Instituicao buscar(Integer id){
        return dao.recuperar(Instituicao.class, id);
    }
    
    public List<Instituicao> listar() {
        return dao.listar(Instituicao.class);
    }
}
