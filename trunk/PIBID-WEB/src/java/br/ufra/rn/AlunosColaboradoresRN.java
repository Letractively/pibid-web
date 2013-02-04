/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.AlunosColaboradoresDAO;
import br.ufra.modelo.AlunosColaboradores;
import java.util.List;

/**
 *
 * @author marcos
 */
public class AlunosColaboradoresRN {
    
    private final AlunosColaboradoresDAO dao = new AlunosColaboradoresDAO();

    public AlunosColaboradores novo() {
        return new AlunosColaboradores();
    }

    public boolean salvar(AlunosColaboradores x) {
        if (x.getId() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public AlunosColaboradores buscar(Integer id) {
        return dao.obter(AlunosColaboradores.class,id);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(AlunosColaboradores.class, x);
    }

    public List listarTodos() {
        return dao.obterTodos(AlunosColaboradores.class);
    }

  
}
