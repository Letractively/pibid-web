package br.ufra.pibid.modelo.dao.implementacao;

import br.ufra.pibid.modelo.dao.FabricaEM;
import br.ufra.pibid.modelo.dao.GenericDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author stelio
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    private EntityManager em = FabricaEM.getFabrica().createEntityManager();
    private EntityTransaction et;

    public GenericDAOImpl() {
        this.et = em.getTransaction();
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    public boolean registrar(T o) {
        try {
            et.begin();
            em.persist(o);
            et.commit();
            return true;
        } catch (Exception e) {
            System.out.println("GenericDAOImpl: Execessão create -" + e);
            if (em.isOpen()) {
                et.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean atualizar(T o) {
        try {
            et.begin();
            em.merge(o);
            et.commit();
            return true;
        } catch (Exception e) {
            System.out.println("GenericDAOImpl: Execessão update -" + e);
            if (em.isOpen()) {
                et.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean deletar(T o) {
        try {
            et.begin();
            em.remove(o);
            et.commit();
            return true;
        } catch (Exception e) {
            System.out.println("GenericDAOImpl: Execessão delete -" + e);
            if (em.isOpen()) {
                et.rollback();
            }
            return false;
        }
    }

    @Override
    public T recuperar(Class<T> classe, Object id) {
        if (id == null) {
            return null;
        }
        String query = classe.getSimpleName() + ".findById";
        final Query q = em.createNamedQuery(query);
        try {
            return (T) q.setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<T> listar(Class<T> classe) {
        String query = classe.getSimpleName() + ".findAll";
        Query q = em.createNamedQuery(query);
        return (List<T>) q.getResultList();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (this.em != null && this.em.isOpen()) {
            this.em.flush();
            this.em.clear();
            this.em.close();
        }
    }
}
