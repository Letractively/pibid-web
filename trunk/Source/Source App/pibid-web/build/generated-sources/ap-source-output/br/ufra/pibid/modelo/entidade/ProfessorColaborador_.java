package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.ProfessorColaboradorPK;
import br.ufra.pibid.modelo.entidade.Projeto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T17:23:42")
@StaticMetamodel(ProfessorColaborador.class)
public class ProfessorColaborador_ { 

    public static volatile SingularAttribute<ProfessorColaborador, DocenteEnsSuperior> docenteEnsSuperior;
    public static volatile SingularAttribute<ProfessorColaborador, Date> dataSaida;
    public static volatile SingularAttribute<ProfessorColaborador, String> descricao;
    public static volatile SingularAttribute<ProfessorColaborador, Projeto> projeto1;
    public static volatile SingularAttribute<ProfessorColaborador, ProfessorColaboradorPK> professorColaboradorPK;
    public static volatile SingularAttribute<ProfessorColaborador, Date> dataEntrada;

}