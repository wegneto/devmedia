/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Parcela;
import br.com.devmedia.cursojee.entities.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 43189334587
 */
public class FinanceiroRepository extends BasicRepository {
    
    public FinanceiroRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Parcela getParcela(int id) {
        return getEntity(Parcela.class, id);
    }
    
    public Parcela setParcela(Parcela parcela) {
        return setEntity(parcela);
    }
    
    public Parcela addParcela(Parcela parcela) {
        return addEntity(parcela);
    }
    
    public void removeParcela(Parcela parcela) {
        removeEntity(parcela);
    }
    
    public List<Parcela> getParcelasByOrcamento(int idOrcamento) {
        String query = "select p from Parcela p where p.idOrcamento.id = ?1";
        return getList(Parcela.class, query, idOrcamento);
    }
    
    public List<Parcela> getParcelasEmAberto(int idOrcamento) {
        String query = "select p from Parcela p where p.idOrcamento.id = ?1 and p.pago = ?2";
        return getList(Parcela.class, query, idOrcamento, Boolean.FALSE);
    }
    
    public List<Parcela> getParcelasPagas(int idOrcamento) {
        String query = "select p from Parcela p where p.idOrcamento.id = ?1 and p.pago = ?2";
        return getList(Parcela.class, query, idOrcamento, Boolean.TRUE);
    }
    
}
