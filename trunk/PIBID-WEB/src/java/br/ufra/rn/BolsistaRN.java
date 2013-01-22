/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.BolsistaDAO;
import br.ufra.modelo.Bolsistas;
import java.util.List;

/**
 *
 * @author marcos
 */
public class BolsistaRN {
   
    private final BolsistaDAO dao = new BolsistaDAO();

    public Bolsistas novo() {
        return new Bolsistas();
    }

    public boolean salvar(Bolsistas x) {
        if (x.getMatricula() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public Bolsistas buscar(String matricula) {
        return dao.obter(Bolsistas.class,matricula);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(Bolsistas.class, x);
    }

    public List listarAtivos(String ativo, String status) {
        return dao.obterTodosAtivoLivre(Bolsistas.class, ativo, status);
    }
}
