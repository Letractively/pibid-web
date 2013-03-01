package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.AtividadeDAOImpl;
import br.ufra.pibid.modelo.entidade.Atividade;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class AtividadeRN {
    private static final AtividadeDAOImpl dao = new AtividadeDAOImpl();

    public AtividadeRN() {
    }

    public Atividade novo() {
        return new Atividade();
    }

    public boolean salvar(Atividade x) {
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

    public boolean excluir(Atividade x) {
        return dao.deletar(x);
    }

    public Atividade buscar(Integer id){
        return dao.recuperar(Atividade.class, id);
    }
    
    public List<Atividade> listar() {
        return dao.listar(Atividade.class);
    }
}
