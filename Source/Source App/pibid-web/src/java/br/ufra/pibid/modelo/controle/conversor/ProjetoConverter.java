package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Papel;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.ProjetoRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("projetoConverter")
public class ProjetoConverter implements Converter {

    private ProjetoRN rn = new ProjetoRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Projeto projeto = null;
        try {
            projeto = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return projeto;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Projeto) {
            if (((Projeto) o).getId() != null) {
                resultado = ((Projeto) o).getId().toString();
            }
        }
        return resultado;
    }
}
