package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Projeto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T19:52:52")
@StaticMetamodel(Cronograma.class)
public class Cronograma_ { 

    public static volatile SingularAttribute<Cronograma, Integer> id;
    public static volatile SingularAttribute<Cronograma, String> codigo;
    public static volatile SingularAttribute<Cronograma, Date> dataIni;
    public static volatile SingularAttribute<Cronograma, Date> dataFim;
    public static volatile SingularAttribute<Cronograma, Projeto> projeto;
    public static volatile SingularAttribute<Cronograma, String> atividade;

}