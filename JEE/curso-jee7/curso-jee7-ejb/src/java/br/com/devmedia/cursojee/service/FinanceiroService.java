package br.com.devmedia.cursojee.service;

import br.com.devmedia.cursojee.entities.Parcela;
import br.com.devmedia.cursojee.service.repositories.FinanceiroRepository;
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
public class FinanceiroService extends BasicService {

    @PersistenceContext
    private EntityManager em;

    private FinanceiroRepository repository;

    @PostConstruct
    @PostActivate
    private void postConstruct() {
        repository = new FinanceiroRepository(em);
    }

    public Parcela getParcela(int id) {
        return repository.getParcela(id);
    }

    public Parcela setParcela(Parcela parcela) {
        return repository.setParcela(parcela);
    }

    public Parcela addParcela(Parcela parcela) {
        return repository.addParcela(parcela);
    }

    public void removeParcela(Parcela parcela) {
        repository.removeParcela(parcela);
    }

    public List<Parcela> getParcelasByOrcamento(int idOrcamento) {
        return repository.getParcelasByOrcamento(idOrcamento);
    }

    public List<Parcela> getParcelasEmAberto(int idOrcamento) {
        return repository.getParcelasEmAberto(idOrcamento);
    }

    public List<Parcela> getParcelasPagas(int idOrcamento) {
        return repository.getParcelasPagas(idOrcamento);
    }

    public List<Parcela> getParcelasByCliente(int idCliente) {
        return repository.getParcelasByCliente(idCliente);
    }

    public List<Parcela> getParcelasEmAbertoByCliente(int idCliente) {
        return repository.getParcelasEmAbertoByCliente(idCliente);
    }

    public List<Parcela> getParcelasPagasByCliente(int idCliente) {
        return repository.getParcelasPagasByCliente(idCliente);
    }

    public Parcela setPagamentoParcela(int ipParcela) {
        return repository.setPagamentoParcela(ipParcela);
    }
}
