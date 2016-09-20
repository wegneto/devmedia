package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.service.repositories.ClienteRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ClienteService extends BasicService{

    @PersistenceContext
    private EntityManager em;
    
    private ClienteRepository repository;
    
    @PostConstruct
    @PostActivate
    private void postConstruct() {
        repository = new ClienteRepository(em);
    }

    public Cliente addCliente(Cliente cliente) {
        return repository.addCliente(cliente);
    }

    public Cliente setCliente(Cliente cliente) {
        return repository.setCliente(cliente);
    }

    public void removeCliente(Cliente cliente) {
        repository.removeCliente(cliente);
    }

    public Cliente getCliente(int id) {
        return repository.getCliente(id);
    }

    public List<Cliente> getClientesComPagamentoEmAberto() {
        return repository.getClientesComPagamentoEmAberto();
    }
    
    public List<Cliente> getClienteByName(String nome) {
        return repository.getClienteByNome(nome);
    }
    
    public List<Cliente> getClienteParaLigar(int mes, int ano) {
        return repository.getClienteParaLigar(mes, ano);
    }
    
}
