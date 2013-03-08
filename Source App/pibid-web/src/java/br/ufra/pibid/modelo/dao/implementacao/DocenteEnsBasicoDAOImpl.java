/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.dao.DocenteEnsBasicoDAO;
import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marcos
 */
public class DocenteEnsBasicoDAOImpl extends GenericDAOImpl<DocenteEnsBasico> implements DocenteEnsBasicoDAO{

    public List<DocenteEnsBasico> findByStatus(Integer status) {
        String query = "DocenteEnsBasico.findByStatus";
        final Query q = getEm().createNamedQuery(query);
        try {
            return q.setParameter("status", status).getResultList();
        } catch (Exception e) {
            System.out.println("Excessão findByStatus: " + e);
            return null;
        }
    }
}
