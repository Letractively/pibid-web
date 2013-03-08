/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.dao;

import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import java.util.List;

/**
 *
 * @author marcos
 */
public interface DocenteEnsBasicoDAO extends GenericDAO<DocenteEnsBasico> {
   List<DocenteEnsBasico> findByStatus(Integer status); 
}
