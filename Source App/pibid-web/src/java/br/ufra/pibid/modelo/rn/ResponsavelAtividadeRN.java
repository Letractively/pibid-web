package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import java.util.List;

/**
 *
 * @author marcos
 */

public class ResponsavelAtividadeRN {

    private static final GenericDAOImpl<ResponsavelAtividade> dao = new GenericDAOImpl<ResponsavelAtividade>();

    public ResponsavelAtividadeRN() {
    }

    public ResponsavelAtividade novo() {
        return new ResponsavelAtividade();
    }

    public boolean salvar(ResponsavelAtividade x) {
        if (x.getResponsavelAtividadePK() == null) {
            try {
                return dao.registrar(x);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
                return false;
            }
        } else {
            try {
                return dao.atualizar(x);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
                return false;
            }
        }
    }

    public boolean excluir(ResponsavelAtividade x) {
        return dao.deletar(x);
    }

    public ResponsavelAtividade buscar(Integer id){
        return dao.recuperar(ResponsavelAtividade.class, id);
    }
    
    public List<ResponsavelAtividade> listar() {
        return dao.listar(ResponsavelAtividade.class);
    }
}
