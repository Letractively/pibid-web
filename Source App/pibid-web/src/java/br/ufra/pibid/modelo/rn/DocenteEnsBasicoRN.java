package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.DocenteEnsBasicoDAOImpl;
import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class DocenteEnsBasicoRN {

    private static final DocenteEnsBasicoDAOImpl dao = new DocenteEnsBasicoDAOImpl();

    public DocenteEnsBasicoRN() {
    }

    public DocenteEnsBasico novo() {
        return new DocenteEnsBasico();
    }

    public boolean salvar(DocenteEnsBasico x) {
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

    public boolean excluir(DocenteEnsBasico x) {
        return dao.deletar(x);
    }

    public DocenteEnsBasico buscar(Integer id){
        return dao.recuperar(DocenteEnsBasico.class, id);
    }
    
    public List<DocenteEnsBasico> listar() {
        return dao.listar(DocenteEnsBasico.class);
    }

    public List<DocenteEnsBasico> buscarPorStatus(Integer status) {
        return dao.findByStatus(status);
    }
}
