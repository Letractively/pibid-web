/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ProfessorColaboradorRN {

    private static final GenericDAOImpl<ProfessorColaborador> dao = new GenericDAOImpl<ProfessorColaborador>();

    public ProfessorColaboradorRN() {
    }

    public ProfessorColaborador novo() {
        return new ProfessorColaborador();
    }

    public boolean salvar(ProfessorColaborador x) {
        if (x.getProfessorColaboradorPK() == null) {
            try {
                return dao.registrar(x);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
                return false;
            }
        } else {
            return dao.atualizar(x);
        }
    }

    public boolean excluir(ProfessorColaborador x) {
        return dao.deletar(x);
    }

    public ProfessorColaborador buscar(ProfessorColaborador id){
        return dao.recuperar(ProfessorColaborador.class, id);
    }
    
    public List<ProfessorColaborador> listar() {
        return dao.listar(ProfessorColaborador.class);
    }
}
