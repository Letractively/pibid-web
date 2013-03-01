package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.rn.BolsistaRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("bolsistaConverter")
public class BolsistaConverter implements Converter {

    private BolsistaRN rn = new BolsistaRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Bolsista bolsista = null;
        try {
            bolsista = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return bolsista;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Bolsista) {
            if (((Bolsista) o).getBolsistaPK() != null) {
                resultado = ((Bolsista) o).getBolsistaPK().toString();
            }
        }
        return resultado;
    }
}
