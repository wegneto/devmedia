/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.control;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.service.ClienteService;
import java.util.Date;
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> filtrado) {
        this.clientes = filtrado;
    }

    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }
    
    public String doLocalizar() {
        cleanCache();
        clientes = service.getClienteByName(localizar);
        return "/restrito/clientes.faces";
    }
    
    private void cleanCache() {
        clientes = null;
        setSelected(new Cliente());
    }
    
    public String getUltimoAtendimento(Integer id) {
        Date data = service.getUltimoAtendimento(id);
        if (data == null) {
            return "Sem informação.";
        } else {
            return getSfd().format(data);
        }
    }
    
    public int getCustomerCount() {
        return service.getCustomerCount();
    }
    
    public String addCliente() {
        cleanCache();
        return "/restrito/addCliente.faces";
    }
    
    public String createCliente() {
        if (checkViolations(selected)) {
            return "/restrito/addCliente.faces";
        }
        service.addCliente(selected);
        doLocalizar();
        
        return "/restrito/clientes.faces";
    }
    
}
