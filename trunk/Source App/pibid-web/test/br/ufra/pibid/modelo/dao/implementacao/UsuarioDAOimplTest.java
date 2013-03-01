package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.entidade.Papel;
import br.ufra.pibid.modelo.entidade.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mysql.jdbc.exceptions.jdbc4.*;

/**
 *
 * @author stelio
 */
public class UsuarioDAOimplTest {

    UsuarioDAOImpl dao = new UsuarioDAOImpl();

    public UsuarioDAOimplTest() {
    }

    @Test
    public void testeRecuperarUsuarioPorEmail() {
        Usuario recuperado = dao.findByEmail("admin.pibidweb@ufra.edu.br");
        assertTrue(recuperado != null);
    }
    
    @Test(expected = MySQLIntegrityConstraintViolationException.class)
    public void testeIserirUsuario() {
        Papel papel = (Papel) new GenericDAOImpl().recuperar(Papel.class, 1);
        
        Usuario operador = new Usuario();
        operador.setEmail("operador@ufra.edu.br");
        operador.setSenha("123");
        operador.setPapel(papel);

        assertTrue(dao.registrar(operador));
    }
    
    @Test
    public void testeAlterarUsuario() {
        Usuario operador = dao.findByEmail("operador@ufra.edu.br");
        
        operador.setSenha("456");

        assertTrue(dao.atualizar(operador));
    }
    
    @Test
    public void testeListarUsuarios() {
        List<Usuario> lista = dao.listar(Usuario.class);
        assertEquals(lista.size(), 2);
    }
}
