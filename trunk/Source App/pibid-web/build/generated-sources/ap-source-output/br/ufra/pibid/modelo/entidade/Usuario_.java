package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Papel;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T19:52:52")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> id;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Papel> papel;

}