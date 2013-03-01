package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.CronogramaDAOImpl;
import br.ufra.pibid.modelo.entidade.Cronograma;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class CronogramaRN {
    private static final CronogramaDAOImpl dao = new CronogramaDAOImpl();

    public CronogramaRN() {
    }

    public Cronograma novo() {
        return new Cronograma();
    }

    public boolean salvar(Cronograma x) {
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

    public boolean excluir(Cronograma x) {
        return dao.deletar(x);
    }

    public Cronograma buscar(Integer id){
        return dao.recuperar(Cronograma.class, id);
    }
    
    public List<Cronograma> listar() {
        return dao.listar(Cronograma.class);
    }
}
