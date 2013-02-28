package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.Bolsista;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class AlunoColaboradorRN {

    private static final GenericDAOImpl<AlunoColaborador> dao = new GenericDAOImpl<AlunoColaborador>();

    public AlunoColaboradorRN() {
    }

    public AlunoColaborador novo() {
        return new AlunoColaborador();
    }

    public boolean salvar(AlunoColaborador x) {
        if (x.getAlunoColaboradorPK() == null) {
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

    public boolean excluir(AlunoColaborador x) {
        return dao.deletar(x);
    }

    public AlunoColaborador buscar(Integer id){
        return dao.recuperar(AlunoColaborador.class, id);
    }
    
    public List<AlunoColaborador> listar() {
        return dao.listar(AlunoColaborador.class);
    }
}
