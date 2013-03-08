package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.AlunoColaborador;
import br.ufra.pibid.modelo.entidade.Atividade;
import br.ufra.pibid.modelo.entidade.Bolsista;
import br.ufra.pibid.modelo.entidade.Cronograma;
import br.ufra.pibid.modelo.entidade.Curso;
import br.ufra.pibid.modelo.entidade.DocenteEnsSuperior;
import br.ufra.pibid.modelo.entidade.EscolaParceira;
import br.ufra.pibid.modelo.entidade.InstituicaoEnsSuperior;
import br.ufra.pibid.modelo.entidade.ProfessorColaborador;
import br.ufra.pibid.modelo.entidade.Supervisor;
import br.ufra.pibid.modelo.entidade.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-03-07T19:17:52")
@StaticMetamodel(Projeto.class)
public class Projeto_ { 

    public static volatile SingularAttribute<Projeto, Date> dataIni;
    public static volatile ListAttribute<Projeto, Supervisor> supervisorList;
    public static volatile SingularAttribute<Projeto, Usuario> usuario;
    public static volatile ListAttribute<Projeto, Bolsista> bolsistaList;
    public static volatile SingularAttribute<Projeto, DocenteEnsSuperior> coordenador;
    public static volatile SingularAttribute<Projeto, InstituicaoEnsSuperior> instituicao;
    public static volatile ListAttribute<Projeto, EscolaParceira> escolaParceiraList;
    public static volatile SingularAttribute<Projeto, String> acoesPrevista;
    public static volatile ListAttribute<Projeto, AlunoColaborador> alunoColaboradorList;
    public static volatile SingularAttribute<Projeto, Integer> id;
    public static volatile SingularAttribute<Projeto, Date> dataFim;
    public static volatile SingularAttribute<Projeto, String> titulo;
    public static volatile SingularAttribute<Projeto, Curso> curso;
    public static volatile SingularAttribute<Projeto, String> resultadosPretendido;
    public static volatile ListAttribute<Projeto, ProfessorColaborador> professorColaboradorList;
    public static volatile ListAttribute<Projeto, Atividade> atividadeList;
    public static volatile ListAttribute<Projeto, Cronograma> cronogramaList;
    public static volatile SingularAttribute<Projeto, String> situacao;
    public static volatile SingularAttribute<Projeto, String> apresentacaoProposta;

}