/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author 43189334587
 */
public class ClienteRepository extends BasicRepository {

    public ClienteRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Cliente addCliente(Cliente cliente) {
        return addEntity(cliente);
    }

    public Cliente setCliente(Cliente cliente) {
        return setEntity(cliente);
    }

    public Cliente getCliente(int id) {
        return getEntity(Cliente.class, id);
    }

    public void removeCliente(Cliente cliente) {
        removeEntity(cliente);
    }

}
