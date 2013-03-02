package br.ufra.pibid.modelo.dao;

import br.ufra.pibid.modelo.entidade.Discente;
import java.util.List;

/**
 *
 * @author stelio
 */
public interface DiscenteDAO extends GenericDAO<Discente> {
    List<Discente> findByInstituicao(String instituicao);
    List<Discente> findByStatus(Integer status);
}
