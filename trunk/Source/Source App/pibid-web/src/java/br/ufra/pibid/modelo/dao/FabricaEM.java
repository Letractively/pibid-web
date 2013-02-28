package br.ufra.pibid.modelo.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author stelio
 */
public class FabricaEM {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWPU");

    private FabricaEM() {
    }

    public static EntityManagerFactory getFabrica() {
        return emf;
    }

    public static EntityManagerFactory getFabrica(String unidadePersistencia) {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        emf = Persistence.createEntityManagerFactory(unidadePersistencia);
        return emf;
    }
}
