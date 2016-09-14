/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Anaminese;
import br.com.devmedia.cursojee.entities.Cliente;
import br.com.devmedia.cursojee.entities.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

public class AnamineseRepository extends BasicRepository {

    public AnamineseRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Anaminese addAnaminese(Anaminese anaminese) {
        return addEntity(anaminese);
    }

    public Anaminese setAnaminese(Anaminese anaminese) {
        return setEntity(anaminese);
    }

    public Anaminese getAnaminese(int id) {
        return getEntity(Anaminese.class, id);
    }

    public void removeAnaminese(Anaminese anaminese) {
        removeEntity(anaminese);
    }
    
    public List<Anaminese> getAnaminesesByCliente(Cliente cliente) {
        String query = "select a from Anaminese a where a.cliente.id = ?1";
        return getList(Anaminese.class, query, cliente.getId());
    }
    
    public List<Anaminese> getAnaminesesByOrcamento(Orcamento orcamento) {
        String query = "select a from Anaminese a where a.orcamento.id = ?1";
        return getList(Anaminese.class, query, orcamento.getId());
    }
    
}
