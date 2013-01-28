package br.ufra.bean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.ufra.modelo.Usuario;
import br.ufra.rn.UsuarioRN;
import br.ufra.utilitario.ConnectionFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpSession;

/**
 *
 * @author victorperes
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private String user;
    private String pass;
    private String logout;
    private UsuarioRN rn = new UsuarioRN();
    private List<Usuario> usuarios;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    public String login() {
        new ConnectionFactory().getConnection();
        if (rn.login(user, pass) != null) {
            usuario = rn.login(user, pass);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            logout = usuario.getLogin();
            return "/faces/sistema/home.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Usuário ou senha inválidos", ""));  
      //      FacesMessage message = new FacesMessage("Usuário ou senha inválidos");
        //    message.setSeverity(FacesMessage.SEVERITY_ERROR);
         //   FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    }

    public String sair() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.removeAttribute("usuario");
        session.invalidate();
        usuario = null;
        return "/sistema/publico/login.xhtml";
    }

    public String getBomDia() {
        String msg = "Bom dia ";
        DateFormat df = new SimpleDateFormat("HH");
        if (Integer.parseInt(df.format(new Date())) >= 12 && Integer.parseInt(df.format(new Date())) <= 18 ) {
            msg = "Boa tarde ";
        }else{
            msg = "Boa noite ";
        }
        return msg;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }
    
        public Usuario getUsuario() {

        return usuario;
    }

    /*
        public boolean menuConfiguracao() {
        try {

            if (usuario.getPapel().getDescricao().equals("MASTER") || usuario.getPapel().getDescricao().equals("FINANCEIRO")) {
                return true;

            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    * 
    
    */
}
