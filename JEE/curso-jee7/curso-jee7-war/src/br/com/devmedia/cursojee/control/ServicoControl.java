/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Servico;
import br.com.devmedia.cursojee.service.ServicoService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author wegneto
 */
@Named
@SessionScoped
public class ServicoControl extends BasicControl {

    @EJB
    private ServicoService service;

    private String localizar;

    private List<Servico> filtrado;

    private Servico selected;

    public List<Servico> getServicos() {
        return service.getServicos();
    }

    public String getLocalizar() {
        return localizar;
    }

    public void setLocalizar(String localizar) {
        this.localizar = localizar;
    }

    public List<Servico> getFiltrado() {
        if (filtrado == null) {
            return getServicos();
        }
        return filtrado;
    }

    public void setFiltrado(List<Servico> filtrado) {
        this.filtrado = filtrado;
    }

    public Servico getSelected() {
        return selected;
    }

    public void setSelected(Servico selected) {
        this.selected = selected;
    }

    public String doLocalizar() {
        filtrado = service.getServicoByNome(getLocalizar());
        return "servicos.faces";
    }

    public String addServico() {
        setSelected(new Servico());
        return "/restrito/addServico.faces";
    }

    public String createServico() {
        setFiltrado(null);
        service.addServico(selected);
        return "/restrito/servicos.faces";
    }
    
    public String removeServico() {
        filtrado = null;
        service.removeServico(selected);
        return "/restrito/servicos.faces";
    }
    
    public String editServico() {
        return "/restrito/editServico.faces";
    }
    
    public String updateServico() {
        filtrado = null;
        service.setServico(selected);
        return "/restrito/servicos.faces";
    }

}
