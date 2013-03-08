/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.dao;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import java.util.List;

/**
 *
 * @author marcos
 */
public interface InstituicaoEnsBasicoDAO extends GenericDAO<InstituicaoEnsBasico>{
  List<InstituicaoEnsBasico> findByStatus(Integer status);  
}
