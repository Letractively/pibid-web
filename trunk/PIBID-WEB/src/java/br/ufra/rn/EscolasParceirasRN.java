/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.rn;

import br.ufra.dao.EscolasParceirasDAO;
import br.ufra.modelo.Bolsistas;
import br.ufra.modelo.EscolasParceiras;
import java.util.List;

/**
 *
 * @author marcos
 */
public class EscolasParceirasRN {
   
    private final EscolasParceirasDAO dao = new EscolasParceirasDAO();

    public EscolasParceiras novo() {
        return new EscolasParceiras();
    }

    public boolean salvar(EscolasParceiras x) {
        if (x.getId() == null) {
            return dao.criar(x);
        } else {
            return dao.alterar(x);
        }
    }

    public EscolasParceiras buscar(Integer id) {
        return dao.obter(EscolasParceiras.class,id);
    }

    public List listarAtivos(String x) {
        return dao.obterTodosAtivo(EscolasParceiras.class, x);
    }

 
}
