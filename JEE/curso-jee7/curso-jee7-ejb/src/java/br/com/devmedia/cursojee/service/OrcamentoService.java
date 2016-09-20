package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.OrcamentoServico;
import br.com.devmedia.cursojee.service.repositories.OrcamentoRepository;
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
public class OrcamentoService extends BasicService {

    @PersistenceContext
    private EntityManager em;

    private OrcamentoRepository repository;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        repository = new OrcamentoRepository(em);
    }

    public Orcamento addOrcamento(Orcamento orcamento) {
        return repository.addOrcamento(orcamento);
    }

    public Orcamento setOrcamento(Orcamento orcamento) {
        return repository.setOrcamento(orcamento);
    }

    public void removeOrcamento(Orcamento orcamento) {
        repository.removeOrcamento(orcamento);
    }

    public Orcamento getOrcamento(int id) {
        return repository.getOrcamento(id);
    }
    
    public List<OrcamentoServico> getServico(int orcamentoId) {
        return repository.getServico(orcamentoId);
    }
    
    public OrcamentoServico addOrcamentoServico(OrcamentoServico orcamentoServico) {
        return repository.addOrcamentoServico(orcamentoServico);
    }

    public OrcamentoServico setOrcamentoServico(OrcamentoServico orcamentoServico) {
        return repository.setOrcamentoServico(orcamentoServico);
    }

    public OrcamentoServico getOrcamentoServico(int id) {
        return repository.getOrcamentoServico(id);
    }

    public void removeOrcamentoServico(OrcamentoServico orcamentoServico) {
        repository.removeOrcamentoServico(orcamentoServico);
    }
    
    public List<Orcamento> getOrcamentos(int clienteId) {
        return repository.getOrcamentos(clienteId);
    }
    
}
