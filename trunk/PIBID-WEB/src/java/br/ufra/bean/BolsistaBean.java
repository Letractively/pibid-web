/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufra.bean;

import br.ufra.modelo.Bolsistas;
import br.ufra.rn.BolsistaRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author victorperes
 */
@ManagedBean
@RequestScoped
public class BolsistaBean {

    /**
     * Creates a new instance of cargoBean
     */
    private Bolsistas bolsista = new Bolsistas();
    private BolsistaRN rn = new BolsistaRN();
    private List<Bolsistas> bolsistas;
    
    public BolsistaBean() {
    }
    
    public String salvar() {
        
        FacesMessage msg = new FacesMessage("Cadastrado com Sucesso",
                "Cadastrado :" + bolsista.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/cadastro/cargos/lista-cargos.xhtml";
    }
    
    public Bolsistas getBolsista() {
        return bolsista;
    }
    
    public void setBolsista(Bolsistas bolsista) {
        this.bolsista = bolsista;
    }
    
   // public List<Bolsistas> getBolsistas() {
        
   //     return bolsistaRN.listarAtivos(true);
   // }
    
    public void setBolsistas(List<Bolsistas> bolsistas) {
        this.bolsistas = bolsistas;
    }
    
    public String novo() {
        bolsista = rn.novo();
        return "/cadastro/cargos/novo-cargos.xhtml";
    }
}
