/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.dao;


import br.ufra.definicao.GenericDAO;
import br.ufra.modelo.Usuario;
import javax.persistence.Query;


/**
 *
 * @author victorperes
 */
public class UsuarioDAO extends GenericDAO<Usuario> {
    public Usuario login(String login, String senha){
        String sql = "select u from Usuario u where u.login =:login and u.senha =:senha";
        Query q = super.getEntityManager().createQuery(sql);
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        try{
           return (Usuario) q.getSingleResult(); 
        }catch(Exception e){
           
            return null;
        }
    }
    
    public Usuario obterLogin(String login){
             String sql = "select u from Usuario u where u.login =:login";
        Query q = super.getEntityManager().createQuery(sql);
        q.setParameter("login", login);
        
        try{
           return (Usuario) q.getSingleResult(); 
        }catch(Exception e){
           
            return null;
        }
        
        
    }
    

}
