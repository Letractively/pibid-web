package br.ufra.pibid.modelo.controle.conversor;

import br.ufra.pibid.modelo.entidade.Curso;
import br.ufra.pibid.modelo.rn.CursoRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author steliocorrea
 */
@FacesConverter("cursoConverter") 
public class CursoConverter implements Converter {

    private CursoRN rn = new CursoRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Curso curso = null;
        try {
            curso = rn.buscar(Integer.valueOf(string));
        } catch (Exception e) {
            System.out.println(e);
        }
        return curso;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        String resultado = "";

        if (o != null && o instanceof Curso) {
            if (((Curso) o).getId() != null) {
                resultado = ((Curso) o).getId().toString();
            }
        }
        return resultado;
    }
}
