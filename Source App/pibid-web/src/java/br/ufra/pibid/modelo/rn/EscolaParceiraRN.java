/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.EscolaParceira;
import java.util.List;

/**
 *
 * @author marcos
 */
public class EscolaParceiraRN {
    private static final GenericDAOImpl<EscolaParceira> dao = new GenericDAOImpl<EscolaParceira>();

    public EscolaParceiraRN() {
    }

    public EscolaParceira novo() {
        return new EscolaParceira();
    }

    public boolean salvar(EscolaParceira x) {
        if (x.getEscolaParceiraPK() == null) {
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

    public boolean excluir(EscolaParceira x) {
        return dao.deletar(x);
    }

    public EscolaParceira buscar(Integer id){
        return dao.recuperar(EscolaParceira.class, id);
    }
    
    public List<EscolaParceira> listar() {
        return dao.listar(EscolaParceira.class);
    }
}
