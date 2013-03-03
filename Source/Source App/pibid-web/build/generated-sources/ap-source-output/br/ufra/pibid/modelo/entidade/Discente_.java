package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.Instituicao;
import br.ufra.pibid.modelo.entidade.ResponsavelAtividade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-03T09:34:19")
@StaticMetamodel(Discente.class)
public class Discente_ { 

    public static volatile ListAttribute<Discente, Bolsista> bolsistaList;
    public static volatile SingularAttribute<Discente, Instituicao> instituicao;
    public static volatile SingularAttribute<Discente, String> telResidencial;
    public static volatile ListAttribute<Discente, AlunoColaborador> alunoColaboradorList;
    public static volatile SingularAttribute<Discente, String> matricula;
    public static volatile SingularAttribute<Discente, String> emailPrincipal;
    public static volatile SingularAttribute<Discente, Integer> id;
    public static volatile SingularAttribute<Discente, String> emailSecudario;
    public static volatile SingularAttribute<Discente, String> lattes;
    public static volatile SingularAttribute<Discente, String> nome;
    public static volatile SingularAttribute<Discente, String> situacao;
    public static volatile ListAttribute<Discente, ResponsavelAtividade> responsavelAtividadeList;
    public static volatile SingularAttribute<Discente, String> endereco;
    public static volatile SingularAttribute<Discente, String> telCelular;

}