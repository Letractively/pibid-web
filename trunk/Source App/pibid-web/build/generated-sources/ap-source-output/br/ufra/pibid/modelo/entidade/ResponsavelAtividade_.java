package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividadePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-07T19:17:52")
@StaticMetamodel(ResponsavelAtividade.class)
public class ResponsavelAtividade_ { 

    public static volatile SingularAttribute<ResponsavelAtividade, DocenteEnsBasico> docenteEnsBasico;
    public static volatile SingularAttribute<ResponsavelAtividade, DocenteEnsSuperior> docenteEnsSuperior;
    public static volatile SingularAttribute<ResponsavelAtividade, Discente> discente1;
    public static volatile SingularAttribute<ResponsavelAtividade, Atividade> atividade1;
    public static volatile SingularAttribute<ResponsavelAtividade, ResponsavelAtividadePK> responsavelAtividadePK;
    public static volatile SingularAttribute<ResponsavelAtividade, Discente> discente2;

}