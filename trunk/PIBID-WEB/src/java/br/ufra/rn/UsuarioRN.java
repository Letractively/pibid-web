/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;


import br.ufra.dao.UsuarioDAO;
import br.ufra.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class UsuarioRN {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario login(String login, String senha) {
        return dao.login(login, senha);
    }

    public Usuario obter(String login) {
        return dao.obterLogin(login);
    }

    public List<Usuario> obterTodos() {
        return dao.obterTodos(Usuario.class);
    }

    public boolean salvar(Usuario t) {
        return dao.criar(t);

    }

    public boolean alterar(Usuario t) {
        return dao.alterar(t);

    }

    public void remover(Usuario novoUsuario) {
        dao.excluir(novoUsuario);
    }
}
