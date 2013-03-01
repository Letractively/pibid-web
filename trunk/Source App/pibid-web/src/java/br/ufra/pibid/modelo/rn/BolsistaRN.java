package br.ufra.pibid.modelo.rn;

import br.ufra.pibid.modelo.dao.implementacao.GenericDAOImpl;
import br.ufra.pibid.modelo.entidade.Bolsista;
import java.util.List;

/**
 *
 * @author steliocorrea
 */
public class BolsistaRN {

    private static final GenericDAOImpl<Bolsista> dao = new GenericDAOImpl<Bolsista>();

    public BolsistaRN() {
    }

    public Bolsista novo() {
        return new Bolsista();
    }

    public boolean salvar(Bolsista x) {
        if (x.getBolsistaPK() == null) {
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

    public boolean excluir(Bolsista x) {
        return dao.deletar(x);
    }

    public Bolsista buscar(Integer id){
        return dao.recuperar(Bolsista.class, id);
    }
    
    public List<Bolsista> listar() {
        return dao.listar(Bolsista.class);
    }
}
