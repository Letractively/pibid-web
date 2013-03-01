package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.AlunoColaboradorPK;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.Projeto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T19:52:52")
@StaticMetamodel(AlunoColaborador.class)
public class AlunoColaborador_ { 

    public static volatile SingularAttribute<AlunoColaborador, AlunoColaboradorPK> alunoColaboradorPK;
    public static volatile SingularAttribute<AlunoColaborador, Date> dataSaida;
    public static volatile SingularAttribute<AlunoColaborador, Discente> discente1;
    public static volatile SingularAttribute<AlunoColaborador, String> descricao;
    public static volatile SingularAttribute<AlunoColaborador, Projeto> projeto1;
    public static volatile SingularAttribute<AlunoColaborador, Date> dataEntrada;

}