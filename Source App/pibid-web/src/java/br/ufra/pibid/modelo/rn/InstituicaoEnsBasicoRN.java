package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class InstituicaoEnsBasicoRN {

    private static final GenericDAOImpl<InstituicaoEnsBasico> dao = new GenericDAOImpl<InstituicaoEnsBasico>();

    public InstituicaoEnsBasicoRN() {
    }

    public InstituicaoEnsBasico novo() {
        return new InstituicaoEnsBasico();
    }

    public boolean salvar(InstituicaoEnsBasico x) {
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

    public boolean excluir(InstituicaoEnsBasico x) {
        return dao.deletar(x);
    }

    public InstituicaoEnsBasico buscar(Integer id){
        return dao.recuperar(InstituicaoEnsBasico.class, id);
    }
    
    public List<InstituicaoEnsBasico> listar() {
        return dao.listar(InstituicaoEnsBasico.class);
    }
}
