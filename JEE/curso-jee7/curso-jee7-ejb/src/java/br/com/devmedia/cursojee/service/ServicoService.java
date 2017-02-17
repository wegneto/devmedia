package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Servico;
import br.com.devmedia.cursojee.service.repositories.ServicoRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
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
public class ServicoService extends BasicService {

    @PersistenceContext
    private EntityManager em;

    private ServicoRepository repository;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        repository = new ServicoRepository(em);
    }

    public Servico addServico(Servico servico) {
        return repository.addServico(servico);
    }

    public Servico setServico(Servico servico) {
        return repository.setServico(servico);
    }

    public void removeServico(Servico servico) {
        repository.removeServico(servico);
    }

    public Servico getServico(int id) {
        return repository.getServico(id);
    }

    public List<Servico> getServicos() {
        return repository.getServicos();
    }

    public List<Servico> getServicoByNome(String nome) {
        return repository.getServicoByNome(nome);
    }

    public Servico getServicoByExactName(String nome) {
        return repository.getServicoByExactName(nome);
    }
    
}
