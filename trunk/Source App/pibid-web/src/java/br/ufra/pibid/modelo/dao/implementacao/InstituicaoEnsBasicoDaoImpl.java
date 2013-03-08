/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.dao.InstituicaoEnsBasicoDAO;
import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marcos
 */
public class InstituicaoEnsBasicoDaoImpl extends GenericDAOImpl<InstituicaoEnsBasico> implements InstituicaoEnsBasicoDAO {

    @Override
    public List<InstituicaoEnsBasico> findByStatus(Integer status) {
        String query = "InstituicaoEnsBasico.findByStatus";
        final Query q = getEm().createNamedQuery(query);
        try {
            return q.setParameter("status", status).getResultList();
        } catch (Exception e) {
            System.out.println("Excessão findByStatus: " + e);
            return null;
        }
    }
}
