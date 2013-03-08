/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.rn.AtividadeRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcos
 */
@FacesConverter("atividadeConverter")
public class AtividadeConverter implements Converter {

   private AtividadeRN rn = new AtividadeRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Atividade atividade = null;
        try {
            atividade = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return atividade;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Atividade) {
            if (((Atividade) o).getId() != null) {
                resultado = ((Atividade) o).getId().toString();
            }
        }
        return resultado;
    }
}
