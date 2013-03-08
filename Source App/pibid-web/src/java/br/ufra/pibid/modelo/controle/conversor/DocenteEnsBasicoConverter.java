/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import br.ufra.pibid.modelo.rn.DocenteEnsBasicoRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcos
 */
@FacesConverter("docenteEnsBasicoConverter") 
public class DocenteEnsBasicoConverter implements Converter {

    private DocenteEnsBasicoRN rn = new DocenteEnsBasicoRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        DocenteEnsBasico docente = null;
        try {
            docente = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return docente;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof DocenteEnsBasico) {
            if (((DocenteEnsBasico) o).getId() != null) {
                resultado = ((DocenteEnsBasico) o).getId().toString();
            }
        }
        return resultado;
    }
}
