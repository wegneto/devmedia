/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Usuarios;
import javax.persistence.EntityManager;

/**
 *
 * @author 43189334587
 */
public class UserRepository extends BasicRepository {

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public Usuarios getUsuario(int id) {
        return getEntityManager().find(Usuarios.class, id);
    }
    
}
