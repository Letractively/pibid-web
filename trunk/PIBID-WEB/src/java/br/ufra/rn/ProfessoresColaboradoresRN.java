/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.ProfColaboradoresDAO;
import br.ufra.modelo.ProfessoresColaboradores;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ProfessoresColaboradoresRN {
  
    private final ProfColaboradoresDAO dao = new ProfColaboradoresDAO();

    public ProfessoresColaboradores novo() {
        return new ProfessoresColaboradores();
    }

    public boolean salvar(ProfessoresColaboradores x) {
        if (x.getId() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public ProfessoresColaboradores buscar(Integer id) {
        return dao.obter(ProfessoresColaboradores.class,id);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(ProfessoresColaboradores.class, x);
    }

    public List listarTodos() {
        return dao.obterTodos(ProfessoresColaboradores.class);
    }

  
}
