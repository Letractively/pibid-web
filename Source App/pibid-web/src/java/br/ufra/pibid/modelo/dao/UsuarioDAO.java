package br.ufra.pibid.modelo.dao;

import br.ufra.pibid.modelo.entidade.Usuario;

/**
 *
 * @author stelio
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {
    Usuario findByEmail(String email);
    Usuario findByCredencial(String email, String senha);
}
