package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsBasico;
import br.ufra.pibid.modelo.entidade.Supervisor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-03T09:34:19")
@StaticMetamodel(DocenteEnsBasico.class)
public class DocenteEnsBasico_ { 

    public static volatile SingularAttribute<DocenteEnsBasico, Integer> id;
    public static volatile SingularAttribute<DocenteEnsBasico, String> emailSecudario;
    public static volatile ListAttribute<DocenteEnsBasico, Supervisor> supervisorList;
    public static volatile SingularAttribute<DocenteEnsBasico, String> telResidencial;
    public static volatile SingularAttribute<DocenteEnsBasico, String> nome;
    public static volatile SingularAttribute<DocenteEnsBasico, String> situacao;
    public static volatile SingularAttribute<DocenteEnsBasico, InstituicaoEnsBasico> escola;
    public static volatile SingularAttribute<DocenteEnsBasico, String> endereco;
    public static volatile SingularAttribute<DocenteEnsBasico, String> telCelular;
    public static volatile SingularAttribute<DocenteEnsBasico, String> emailPrincipal;

}