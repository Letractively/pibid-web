package br.ufra.pibid.modelo.dao;

import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import java.util.List;

/**
 *
 * @author stelio
 */
public interface DocenteEnsSuperiorDAO extends GenericDAO<DocenteEnsSuperior> {
    List<DocenteEnsSuperior> findByInstituicao(String instituicao);
    List<DocenteEnsSuperior> findByStatus(Integer status);
}
