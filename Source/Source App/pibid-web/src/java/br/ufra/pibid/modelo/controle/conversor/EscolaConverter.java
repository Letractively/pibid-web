package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import br.ufra.pibid.modelo.rn.InstituicaoEnsBasicoRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("escolaConverter") 
public class EscolaConverter implements Converter {

    private InstituicaoEnsBasicoRN rn = new InstituicaoEnsBasicoRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        InstituicaoEnsBasico escola = null;
        try {
            escola = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return escola;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof InstituicaoEnsBasico) {
            if (((InstituicaoEnsBasico) o).getId() != null) {
                resultado = ((InstituicaoEnsBasico) o).getId().toString();
            }
        }
        return resultado;
    }
}
