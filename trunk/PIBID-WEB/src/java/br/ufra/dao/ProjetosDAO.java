/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.dao;

import br.ufra.definicao.GenericDAO;
import br.ufra.modelo.Projetos;
import javax.persistence.Query;

/**
 *
 * @author marcos
 */
public class ProjetosDAO extends GenericDAO<Projetos> {
    
        public Projetos obter(Projetos p) {
        String query = "findByTituloProjeto";
        final Query q = getEntityManager().createQuery(query);
        try {
            Projetos resultado = (Projetos) q.getSingleResult();
            return resultado;
        } catch (Exception e) {
            return null;
        }
    }
    
}
