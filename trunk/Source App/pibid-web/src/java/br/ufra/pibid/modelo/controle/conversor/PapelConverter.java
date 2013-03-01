package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Papel;
import br.ufra.pibid.modelo.rn.PapelRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("papelConverter")
public class PapelConverter implements Converter {

    private PapelRN rn = new PapelRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Papel papel = null;
        try {
            papel = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return papel;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Papel) {
            if (((Papel) o).getId() != null) {
                resultado = ((Papel) o).getId().toString();
            }
        }
        return resultado;
    }
}
