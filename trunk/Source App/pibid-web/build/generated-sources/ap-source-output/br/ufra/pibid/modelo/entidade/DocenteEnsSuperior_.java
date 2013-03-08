package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.InstituicaoEnsSuperior;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import br.ufra.pibid.modelo.entidade.Projeto;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-07T19:17:52")
@StaticMetamodel(DocenteEnsSuperior.class)
public class DocenteEnsSuperior_ { 

    public static volatile SingularAttribute<DocenteEnsSuperior, Integer> id;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> emailSecudario;
    public static volatile ListAttribute<DocenteEnsSuperior, Projeto> projetoList;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> lattes;
    public static volatile ListAttribute<DocenteEnsSuperior, ProfessorColaborador> professorColaboradorList;
    public static volatile SingularAttribute<DocenteEnsSuperior, Integer> status;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> telResidencial;
    public static volatile SingularAttribute<DocenteEnsSuperior, InstituicaoEnsSuperior> instituicao;
    public static volatile SingularAttribute<DocenteEnsSuperior, Integer> statusAtividade;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> situacao;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> nome;
    public static volatile ListAttribute<DocenteEnsSuperior, ResponsavelAtividade> responsavelAtividadeList;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> endereco;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> telCelular;
    public static volatile SingularAttribute<DocenteEnsSuperior, String> emailPrincipal;

}