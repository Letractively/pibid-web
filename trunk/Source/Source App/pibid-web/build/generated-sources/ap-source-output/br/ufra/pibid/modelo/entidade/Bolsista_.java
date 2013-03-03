package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.BolsistaPK;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.Projeto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-03T09:34:19")
@StaticMetamodel(Bolsista.class)
public class Bolsista_ { 

    public static volatile SingularAttribute<Bolsista, Date> dataSaida;
    public static volatile SingularAttribute<Bolsista, BolsistaPK> bolsistaPK;
    public static volatile SingularAttribute<Bolsista, Discente> discente1;
    public static volatile SingularAttribute<Bolsista, String> descricao;
    public static volatile SingularAttribute<Bolsista, Projeto> projeto1;
    public static volatile SingularAttribute<Bolsista, Date> dataEntrada;

}