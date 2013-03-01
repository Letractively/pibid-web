package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Papel;
import br.ufra.pibid.modelo.entidade.Usuario;
import br.ufra.pibid.modelo.rn.PapelRN;
import br.ufra.pibid.modelo.rn.UsuarioRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@RequestScoped
public class UsuarioBean {

    private static final UsuarioRN rn = new UsuarioRN();
    private boolean externo;
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private List<Papel> papeis;

    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = rn.listar();
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Papel> getPapeis() {
        if (papeis == null) {
            papeis = new PapelRN().listar();
        }

        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public String userNovo() {
        externo = true;

        return "/publico/novo-usuario.xhtml";
    }

    public String novo() {
        usuario = null;
        usuario = rn.novo();
        return "/restrito/usuario/cadastro.xhtml?faces-redirect=true";
    }

    public String alterar() {
        return "/restrito/usuario/cadastro.xhtml";
    }

    public String listagem() {
        return "/restrito/usuario/listagem.xhtml?faces-redirect=true";
    }

    public String salvar() {
        usuario.setPapel(new PapelRN().buscar(2));
        rn.salvar(usuario);

        usuario = null;
        usuarios = null;
        return listagem();
    }
}
