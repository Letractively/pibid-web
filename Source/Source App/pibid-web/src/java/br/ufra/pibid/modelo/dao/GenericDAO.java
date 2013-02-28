package br.ufra.pibid.modelo.dao;

import java.util.List;

/**
 *
 * @author stelio
 */
public interface GenericDAO<T> {
    boolean registrar(T object);
    boolean atualizar(T object);
    boolean deletar(T object);
    T recuperar(Class<T> classe, Object id);
    List<T> listar(Class<T> classe);
}
