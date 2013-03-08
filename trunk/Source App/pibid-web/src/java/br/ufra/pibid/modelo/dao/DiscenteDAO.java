package br.ufra.pibid.modelo.dao;

import br.ufra.pibid.modelo.entidade.Discente;
import java.util.List;

/**
 *
 * @author stelio
 */
public interface DiscenteDAO extends GenericDAO<Discente> {
    List<Discente> findByInstituicao(String instituicao);
    List<Discente> findByStatus(Integer status);                    //CÓDIGO 0 NÃO PERTENCE A PROJETO, 1 BOLSISTA, 2 COLABORADOR
    List<Discente> findByStatusAtividade(Integer statusAtividade);  //CÓDIGO 0 NÃO ESTÁ VINCULADO A UMA ATIVIDADE, 1 ESTÁ VINCULADO A UMA ATIVIDADE
}
