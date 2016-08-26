/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 43189334587
 */
public class ServicoRepository extends BasicRepository{
    
    public ServicoRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    public Servico addServico(Servico servico) {
        return addEntity(servico);
    }
    
    public Servico setServico(Servico servico) {
        return setEntity(servico);
    }
    
    public void removeServico(Servico servico) {
        removeEntity(servico);
    }
    
    public Servico getServico(int id) {
        return getEntity(Servico.class, id);
    }
    
    public List<Servico> getServicos() {
        String query = "select s from Servico s";
        return getList(Servico.class, query);
    }
    
    public List<Servico> getServicoByNome(String nome) {
        String query = "select s from Servico s where s.nome like ?1";
        return getList(Servico.class, query, nome+"%");
    }
    
}
