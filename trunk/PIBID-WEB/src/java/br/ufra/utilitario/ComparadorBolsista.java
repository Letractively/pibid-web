/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.utilitario;

import br.ufra.modelo.Bolsistas;

/**
 *
 * @author victorperes
 */
public class ComparadorBolsista implements java.util.Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        Bolsistas c1 = (Bolsistas) o1;
        Bolsistas c2 = (Bolsistas) o2;

        return c1.getNome().compareTo(c2.getNome());
    }
}
