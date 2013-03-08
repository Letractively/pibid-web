/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.Supervisor;
import java.util.List;

/**
 *
 * @author marcos
 */
public class SupervisorRN {
    private static final GenericDAOImpl<Supervisor> dao = new GenericDAOImpl<Supervisor>();

    public SupervisorRN() {
    }

    public Supervisor novo() {
        return new Supervisor();
    }

    public boolean salvar(Supervisor x) {
        if (x.getSupervisorPK() == null) {
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

    public boolean excluir(Supervisor x) {
        return dao.deletar(x);
    }

    public Supervisor buscar(Supervisor id){
        return dao.recuperar(Supervisor.class, id);
    }
    
    public List<Supervisor> listar() {
        return dao.listar(Supervisor.class);
    }
}
