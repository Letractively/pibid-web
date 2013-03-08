package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.entidade.SupervisorPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-07T19:17:52")
@StaticMetamodel(Supervisor.class)
public class Supervisor_ { 

    public static volatile SingularAttribute<Supervisor, Date> dataIni;
    public static volatile SingularAttribute<Supervisor, DocenteEnsBasico> docenteEnsBasico;
    public static volatile SingularAttribute<Supervisor, Date> dateFim;
    public static volatile SingularAttribute<Supervisor, String> descricao;
    public static volatile SingularAttribute<Supervisor, SupervisorPK> supervisorPK;
    public static volatile SingularAttribute<Supervisor, Projeto> projeto1;

}