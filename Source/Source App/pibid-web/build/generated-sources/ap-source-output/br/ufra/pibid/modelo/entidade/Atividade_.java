package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-03T09:34:19")
@StaticMetamodel(Atividade.class)
public class Atividade_ { 

    public static volatile SingularAttribute<Atividade, Integer> id;
    public static volatile SingularAttribute<Atividade, Date> dataIni;
    public static volatile SingularAttribute<Atividade, Date> dataConclusao;
    public static volatile SingularAttribute<Atividade, Date> dataFim;
    public static volatile SingularAttribute<Atividade, String> titulo;
    public static volatile SingularAttribute<Atividade, String> obsGerais;
    public static volatile SingularAttribute<Atividade, Projeto> projeto;
    public static volatile SingularAttribute<Atividade, Date> cadastro;
    public static volatile ListAttribute<Atividade, ResponsavelAtividade> responsavelAtividadeList;
    public static volatile SingularAttribute<Atividade, String> descricao;

}