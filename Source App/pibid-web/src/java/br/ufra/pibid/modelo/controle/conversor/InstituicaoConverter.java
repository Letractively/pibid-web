package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsSuperior;
import br.ufra.pibid.modelo.rn.InstituicaoEnsSuperiorRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("instituicaoConverter")
public class InstituicaoConverter implements Converter {

    private InstituicaoEnsSuperiorRN rn = new InstituicaoEnsSuperiorRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        InstituicaoEnsSuperior instituicao = null;
        try {
            instituicao = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return instituicao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof InstituicaoEnsSuperior) {
            if (((InstituicaoEnsSuperior) o).getId() != null) {
                resultado = ((InstituicaoEnsSuperior) o).getId().toString();
            }
        }
        return resultado;
    }
}
