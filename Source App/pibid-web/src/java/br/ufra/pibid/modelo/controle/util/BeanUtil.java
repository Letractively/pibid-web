package br.ufra.pibid.modelo.controle.util;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author steliocorrea
 */
public class BeanUtil { 
    public static void encerrarSessao() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Object session = externalContext.getSession(true);
        if (session instanceof HttpSession) {
            ((HttpSession) session).invalidate();
        }
    }

    public static void naSessao(String chave, Object valor) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessao = externalContext.getSessionMap();
        //TODO Por que remover antes? Não sobreescreve?
        sessao.remove(chave);
        sessao.put(chave, valor);
    }

    public static Object daSessao(String chave) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessao = externalContext.getSessionMap();
        return sessao.get(chave);
    }

    private static void criarMensagem(FacesMessage.Severity s, String m, String d) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(s, m, d);
        facesContext.addMessage(null, facesMessage);
    }

    public static void criarMensagemDeInformacao(String sumario, String detalhe) {
        criarMensagem(FacesMessage.SEVERITY_INFO, sumario, detalhe);
    }

    public static void criarMensagemDeErro(String sumario, String detalhe) {
        criarMensagem(FacesMessage.SEVERITY_ERROR, sumario, detalhe);
    }

    public static void criarMensagemDeAlerta(String sumario, String detalhe) {
        criarMensagem(FacesMessage.SEVERITY_WARN, sumario, detalhe);
    }
}
