package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.ProjetoDAOImpl;
import br.ufra.pibid.modelo.entidade.Projeto;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class ProjetoRN {
    private static final ProjetoDAOImpl dao = new ProjetoDAOImpl();

    public ProjetoRN() {
    }

    public Projeto novo() {
        return new Projeto();
    }

    public boolean salvar(Projeto x) {
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

    public boolean excluir(Projeto x) {
        return dao.deletar(x);
    }

    public Projeto buscar(Integer id){
        return dao.recuperar(Projeto.class, id);
    }
    
    public List<Projeto> listar() {
        return dao.listar(Projeto.class);
    }
}
