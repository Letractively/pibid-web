package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Discente;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.Projeto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-03T09:34:19")
@StaticMetamodel(Instituicao.class)
public class Instituicao_ { 

    public static volatile SingularAttribute<Instituicao, Integer> id;
    public static volatile ListAttribute<Instituicao, Projeto> projetoList;
    public static volatile SingularAttribute<Instituicao, String> sigla;
    public static volatile SingularAttribute<Instituicao, String> nome;
    public static volatile ListAttribute<Instituicao, Discente> discenteList;
    public static volatile ListAttribute<Instituicao, DocenteEnsSuperior> docenteEnsSuperiorList;

}