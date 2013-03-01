package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import br.ufra.pibid.modelo.entidade.Projeto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T19:52:52")
@StaticMetamodel(DocenteEnsSuperior.class)
public class DocenteEnsSuperior_ { 

    public static volatile SingularAttribute<DocenteEnsSuperior, Integer> id;
    public static volatile ListAttribute<DocenteEnsSuperior, Projeto> projetoList;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> emailSecudario;
    public static volatile ListAttribute<DocenteEnsSuperior, ProfessorColaborador> professorColaboradorList;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> lattes;
    public static volatile SingularAttribute<DocenteEnsSuperior, Instituicao> instituicao;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> telResidencial;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> situacao;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> nome;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> endereco;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> telCelular;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> emailPrincipal;

}