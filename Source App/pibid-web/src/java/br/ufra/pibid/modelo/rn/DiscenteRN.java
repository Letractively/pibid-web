package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.DiscenteDAOImpl;
import br.ufra.pibid.modelo.entidade.Discente;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class DiscenteRN {

    private static final DiscenteDAOImpl dao = new DiscenteDAOImpl();

    public DiscenteRN() {
    }

    public Discente novo() {
        return new Discente();
    }

    public boolean salvar(Discente x) {
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

    public boolean excluir(Discente x) {
        return dao.deletar(x);
    }

    public List<Discente> listar() {
        return dao.listar(Discente.class);
    }
    
    public List<Discente> buscarPorInstituicao(String instituicao){
        return dao.findByInstituicao(instituicao);
    }
    public List<Discente> buscarStatusProjeto(Integer status){
        return dao.findByStatus(status);
    }
    
    public List<Discente> buscarStatusAtividade(Integer status){
        return dao.findByStatusAtividade(status);
    }
    
    public Discente buscar(Integer id){
        return dao.recuperar(Discente.class, id);
    }
}
