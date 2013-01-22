/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.AtividadeDAO;
import br.ufra.modelo.Atividades;
import java.util.List;

/**
 *
 * @author marcos
 */
public class AtividadesRN {

    private final AtividadeDAO dao = new AtividadeDAO();

    public Atividades novo() {
        return new Atividades();
    }

    public boolean salvar(Atividades x) {
        if (x.getId() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public Atividades buscar(Integer id) {
        return dao.obter(Atividades.class, id);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(Atividades.class, x);
    }

    public List listarAtivos(String ativo, String status) {
        return dao.obterTodosAtivoLivre(Atividades.class, ativo, status);
    }
}
