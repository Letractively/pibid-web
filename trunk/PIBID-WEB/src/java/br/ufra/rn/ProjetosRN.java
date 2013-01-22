/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.ProjetosDAO;
import br.ufra.modelo.Projetos;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ProjetosRN {
   
    private final ProjetosDAO dao = new ProjetosDAO();

    public Projetos novo() {
        return new Projetos();
    }

    public boolean salvar(Projetos x) {
        if (x.getId() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public Projetos buscar(Integer id) {
        return dao.obter(Projetos.class,id);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(Projetos.class, x);
    }

    public List listarAtivos(String ativo, String status) {
        return dao.obterTodosAtivoLivre(Projetos.class, ativo, status);
    }
}
