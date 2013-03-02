package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.dao.DiscenteDAO;
import br.ufra.pibid.modelo.entidade.Discente;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author stelio
 */
public class DiscenteDAOImpl extends GenericDAOImpl<Discente> implements DiscenteDAO {

    @Override
    public List<Discente> findByInstituicao(String instituicao) {
        String query = "Discente.findByInstituicao";
        final Query q = getEm().createNamedQuery(query);
        try {
            return q.setParameter("instituicao", instituicao).getResultList();
        } catch (Exception e) {
            System.out.println("Excessão findByEmail: " + e);
            return null;
        }
    }

    @Override
    public List<Discente> findByStatus(Integer status) {
        String query = "Discente.findByStatus";
        final Query q = getEm().createNamedQuery(query);
        try {
            return q.setParameter("status", status).getResultList();
        } catch (Exception e) {
            System.out.println("Excessão findByStatus: " + e);
            return null;
        }

    }
}
