/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.rn.DiscenteRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcos
 */
@FacesConverter("discenteConverter")
public class DiscenteConverter implements Converter {

    private DiscenteRN rn = new DiscenteRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Discente discente = null;
        try {
            discente = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return discente;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Discente) {
            if (((Discente) o).getId() != null) {
                resultado = ((Discente) o).getId().toString();
            }
        }
        return resultado;
    }
}
