/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 43189334587
 */
public abstract class BasicRepository {

    private final EntityManager entityManager;

    public BasicRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected <T> T addEntity(Object entity) {
        getEntityManager().persist(entity);
        return (T) entity;
    }

    protected <T> T getEntity(Class<T> classToCast, Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }

    protected <T> T setEntity(Object entity) {
        Object updatedObj = getEntityManager().merge(entity);
        return (T) updatedObj;
    }

    protected void removeEntity(Object entity) {
        Object removedObj = getEntityManager().merge(entity);
        getEntityManager().remove(removedObj);
    }

    protected <T> List<T> getList(Class<T> classToCast, String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }

    protected <T> T getPojo(Class<T> classToCast, String query, Object... values) {
        Query qr = createQuery(query, values);
        return (T) qr.getSingleResult();
    }

    protected int executeCommand(String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }

    private Query createQuery(String query, Object... values) {
        Query qr = getEntityManager().createQuery(query);
        for (int i = 0; i < values.length; i++) {
            qr.setParameter(i, values[i]);
        }

        return qr;
    }

}
