/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.converter;

import br.ufra.modelo.Bolsistas;
import br.ufra.rn.BolsistaRN;
import com.sun.org.apache.xml.internal.resolver.helpers.Namespaces;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author victorperes
 */
@FacesConverter(value="bolsistaConverter", forClass=Bolsistas.class)
public class BolsistaConversor implements Converter {

    private final BolsistaRN cargoRN = new BolsistaRN();

    public Object getAsObject(FacesContext fc, UIComponent uic, String valor) {
        return cargoRN.buscar(valor);

    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Bolsistas local = (Bolsistas) o;
        return local.getMatricula().toString();
    }
}
