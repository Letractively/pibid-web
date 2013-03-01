package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.entidade.Usuario;
import java.util.List;

/**
 *
 * @author stelio
 */
public class Main {
    static UsuarioDAOImpl dao = new UsuarioDAOImpl();
    
    public static void main(String[] args) {
        Usuario admin = dao.findByCredencial("admin.pibidweb@ufra.edu.br", "admin");
        List<Usuario> listaUsuarios = dao.listar(Usuario.class);
        
        System.out.println("Usuario email: "+admin.getEmail());
        System.out.println("--------------------------------------------------");
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Usuario: "+usuario.getEmail());
            System.out.println("Papel: "+usuario.getPapel().getDescricao());
        }
    }
}
