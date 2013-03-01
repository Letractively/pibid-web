package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.Papel;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class PapelRN {

    private static final GenericDAOImpl<Papel> dao = new GenericDAOImpl<Papel>();

    public PapelRN() {
    }

    public Papel novo() {
        return new Papel();
    }

    public boolean salvar(Papel x) {
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

    public boolean excluir(Papel x) {
        return dao.deletar(x);
    }

    public Papel buscar(Integer id){
        return dao.recuperar(Papel.class, id);
    }
    
    public List<Papel> listar() {
        return dao.listar(Papel.class);
    }
}
