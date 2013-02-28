package br.ufra.pibid.modelo.controle.bean;

import br.ufra.pibid.modelo.entidade.Usuario;
import br.ufra.pibid.modelo.rn.UsuarioRN;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author steliocorrea
 */
@ManagedBean
@SessionScoped
public class AutenticadorBean {

    private static final UsuarioRN rn = new UsuarioRN();
    private String email;
    private String senha;
    private Usuario usuario = new Usuario();

    public AutenticadorBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String logIn() {
        usuario = rn.buscarPorCredencial(email, senha);

        FacesContext fc = FacesContext.getCurrentInstance();
        if (usuario != null) {
            ExternalContext ec = fc.getExternalContext();
            HttpSession session = (HttpSession) ec.getSession(false);
            session.setAttribute("usuario", usuario);
            return "/publico/index.xhmtl";
        } else {
            FacesMessage fm = new FacesMessage("Usuário e/ou senha inválidos ");
            return "/publico/login.xhtml";
        }
    }

    public String logOut() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession session = (HttpSession) ec.getSession(false);
        session.removeAttribute("usuario");
        return "/publico/login.xhtml";
    }
}