package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.rn.DocenteEnsSuperiorRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("docenteEnsSuperiorConverter") 
public class DocenteEnsSuperiorConverter implements Converter {

    private DocenteEnsSuperiorRN rn = new DocenteEnsSuperiorRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        DocenteEnsSuperior docente = null;
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

        if (o != null && o instanceof DocenteEnsSuperior) {
            if (((DocenteEnsSuperior) o).getId() != null) {
                resultado = ((DocenteEnsSuperior) o).getId().toString();
            }
        }
        return resultado;
    }
}
