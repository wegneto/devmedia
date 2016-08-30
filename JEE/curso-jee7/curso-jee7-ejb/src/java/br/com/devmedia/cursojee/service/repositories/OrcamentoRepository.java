package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.Orcamento;
import br.com.devmedia.cursojee.entities.OrcamentoServico;
import java.util.List;
import javax.persistence.EntityManager;

public class OrcamentoRepository extends BasicRepository {
    
    public OrcamentoRepository(EntityManager entityManager) {
        super(entityManager);
    }
   
    public Orcamento addOrcamento(Orcamento orcamento) {
        return addEntity(orcamento);
    }

    public Orcamento setOrcamento(Orcamento orcamento) {
        return setEntity(orcamento);
    }

    public Orcamento getOrcamento(int id) {
        return getEntity(Orcamento.class, id);
    }

    public void removeOrcamento(Orcamento orcamento) {
        removeEntity(orcamento);
    }
    
    public List<OrcamentoServico> getServico(int orcamentoId) {
        String query = "select os from OrcamentoServico os where os.orcamento.id = ?1";
        return getList(OrcamentoServico.class, query, orcamentoId);
    }
    
    public OrcamentoServico addOrcamentoServico(OrcamentoServico orcamentoServico) {
        return addEntity(orcamentoServico);
    }

    public OrcamentoServico setOrcamentoServico(OrcamentoServico orcamentoServico) {
        return setEntity(orcamentoServico);
    }

    public OrcamentoServico getOrcamentoServico(int id) {
        return getEntity(OrcamentoServico.class, id);
    }

    public void removeOrcamentoServico(OrcamentoServico orcamentoServico) {
        removeEntity(orcamentoServico);
    }
    
    public List<Orcamento> getOrcamentos(int clienteId) {
        String query = "select o from Orcamento o where o.cliente.id = ?1";
        return getList(Orcamento.class, query, clienteId);
    }
    
    
}
