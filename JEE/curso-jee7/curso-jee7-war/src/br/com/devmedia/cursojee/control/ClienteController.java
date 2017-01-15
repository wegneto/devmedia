/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.service.ClienteService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author wegneto
 */
public class ClienteController extends BasicControl {
    
    @EJB
    private ClienteService service;
    
    private String localizar;

    private List<Cliente> clientes;

    private Cliente selected;

    public String getLocalizar() {
        return localizar;
    }

    public void setLocalizar(String localizar) {
        this.localizar = localizar;
    }

    public List<Cliente> getFiltrado() {
        return clientes;
    }

    public void setFiltrado(List<Cliente> filtrado) {
        this.clientes = filtrado;
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }
    
    public String doLocalizar() {
        clientes = service.getClienteByName(localizar);
        return "/restrito/clientes.faces";
    }
    
    public String getUltimoAtendimento(Integer id) {
        
        return null;
    }
    
}
