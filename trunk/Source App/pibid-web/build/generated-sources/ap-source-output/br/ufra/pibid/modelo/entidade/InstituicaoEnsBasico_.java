package br.ufra.pibid.modelo.entidade;

import br.ufra.pibid.modelo.entidade.DocenteEnsBasico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-02-28T19:52:52")
@StaticMetamodel(InstituicaoEnsBasico.class)
public class InstituicaoEnsBasico_ { 

    public static volatile SingularAttribute<InstituicaoEnsBasico, String> emailDirecao;
    public static volatile ListAttribute<InstituicaoEnsBasico, DocenteEnsBasico> docenteEnsBasicoList;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> diretor;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> viceDiretorTarde;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> emailViceDirecao;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> viceDiretorManha;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> matricula;
    public static volatile SingularAttribute<InstituicaoEnsBasico, Integer> id;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> emailEscola;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> telefone;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> esfera;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> situacao;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> nome;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> endereco;
    public static volatile SingularAttribute<InstituicaoEnsBasico, String> viceDiretorNoite;

}