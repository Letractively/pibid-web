package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.rn.InstituicaoRN;
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

    private InstituicaoRN rn = new InstituicaoRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Instituicao instituicao = null;
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

        if (o != null && o instanceof Instituicao) {
            if (((Instituicao) o).getId() != null) {
                resultado = ((Instituicao) o).getId().toString();
            }
        }
        return resultado;
    }
}
