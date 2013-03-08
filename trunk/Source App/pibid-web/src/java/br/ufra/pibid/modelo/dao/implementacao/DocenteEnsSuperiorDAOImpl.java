package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.dao.DocenteEnsSuperiorDAO;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author stelio
 */
public class DocenteEnsSuperiorDAOImpl extends GenericDAOImpl<DocenteEnsSuperior> implements DocenteEnsSuperiorDAO {

    @Override
    public List<DocenteEnsSuperior> findByInstituicao(String instituicao) {
        String query = "DocenteEnsSuperior.findByInstituicao";
        final Query q = getEm().createNamedQuery(query);
        try {
            return q.setParameter("instituicao", instituicao).getResultList();
        } catch (Exception e) {
            System.out.println("Excessão findByEmail: " + e);
            return null;
        }
    }
    
    @Override
    public List<DocenteEnsSuperior> findByStatus(Integer status) {
        String query = "DocenteEnsSuperior.findByStatus";
        final Query q = getEm().createNamedQuery(query);
        try {
            return q.setParameter("status", status).getResultList();
        } catch (Exception e) {
            System.out.println("Excessão findByStatus: " + e);
            return null;
        }
    }
}
