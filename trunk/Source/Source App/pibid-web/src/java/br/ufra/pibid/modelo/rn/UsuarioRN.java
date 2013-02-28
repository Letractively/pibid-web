package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.UsuarioDAOImpl;
import br.ufra.pibid.modelo.entidade.Usuario;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class UsuarioRN {

    private static final UsuarioDAOImpl dao = new UsuarioDAOImpl();

    public UsuarioRN() {
    }

    public Usuario novo() {
        return new Usuario();
    }

    public boolean salvar(Usuario x) {
        if (x.getId() == null) {
            try {
                return dao.registrar(x);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
                return false;
            }
        } else {
            return dao.atualizar(x);
        }
    }

    public boolean excluir(Usuario x) {
        return dao.deletar(x);
    }

    public List<Usuario> listar() {
        return dao.listar(Usuario.class);
    }
    
    public Usuario buscarPorEmail(String email){
        return dao.findByEmail(email);
    }
    
    public Usuario buscarPorCredencial(String email, String senha){
        return dao.findByCredencial(email, senha);
    }
}
