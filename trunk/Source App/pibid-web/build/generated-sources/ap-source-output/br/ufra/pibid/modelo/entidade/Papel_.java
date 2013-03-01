package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T19:52:52")
@StaticMetamodel(Papel.class)
public class Papel_ { 

    public static volatile SingularAttribute<Papel, Integer> id;
    public static volatile ListAttribute<Papel, Usuario> usuarioList;
    public static volatile SingularAttribute<Papel, String> descricao;

}