package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.DocenteEnsSuperiorDAOImpl;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class DocenteEnsSuperiorRN {

    private static final DocenteEnsSuperiorDAOImpl dao = new DocenteEnsSuperiorDAOImpl();

    public DocenteEnsSuperiorRN() {
    }

    public DocenteEnsSuperior novo() {
        return new DocenteEnsSuperior();
    }

    public boolean salvar(DocenteEnsSuperior x) {
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

    public boolean excluir(DocenteEnsSuperior x) {
        return dao.deletar(x);
    }

    public List<DocenteEnsSuperior> listar() {
        return dao.listar(DocenteEnsSuperior.class);
    }
    
    public DocenteEnsSuperior buscar(Integer id) {
        return dao.recuperar(DocenteEnsSuperior.class, id);
    }
    
    public List<DocenteEnsSuperior> buscarPorInstituicao(String instituicao){
        return dao.findByInstituicao(instituicao);
    }
    
    public List<DocenteEnsSuperior> buscarPorStatus(Integer status){
        return dao.findByStatus(status);
    }
}
