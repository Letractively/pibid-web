/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.SupervisoresDAO;
import br.ufra.modelo.Supervisores;
import java.util.List;

/**
 *
 * @author marcos
 */
public class SupervisoresRN {
    private final SupervisoresDAO dao = new SupervisoresDAO();

    public Supervisores novo() {
        return new Supervisores();
    }

    public boolean salvar(Supervisores x) {
        if (x.getId() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public Supervisores buscar(Integer id) {
        return dao.obter(Supervisores.class,id);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(Supervisores.class, x);
    }


}
