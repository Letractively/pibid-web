package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Projeto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-02T00:35:56")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Integer> id;
    public static volatile ListAttribute<Curso, Projeto> projetoList;
    public static volatile SingularAttribute<Curso, String> curso;

}