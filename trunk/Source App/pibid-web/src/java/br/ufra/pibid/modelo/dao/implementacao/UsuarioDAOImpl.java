package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.dao.UsuarioDAO;
import br.ufra.pibid.modelo.entidade.Usuario;
import javax.persistence.Query;

/**
 *
 * @author stelio
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO{

    @Override
    public Usuario findByEmail(String email) {
        String query = "Usuario.findByEmail";
        final Query q = getEm().createNamedQuery(query);
        try {
            return (Usuario) q.setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            System.out.println("Excessão findByEmail: "+e);
            return null;
        }
    }

    @Override
    public Usuario findByCredencial(String email, String senha) {
        String query = "Usuario.findByCredencial";
        final Query q = getEm().createNamedQuery(query);
        try {
            q.setParameter("email", email);
            q.setParameter("senha", senha);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Excessão findByCreadencial: "+e);
            return null;
        }
    }
    
}
