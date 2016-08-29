/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.cursojee.service.repositories;

import br.com.devmedia.cursojee.entities.Cliente;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    public List<Cliente> getClienteByName(String nome) {
        String query = "select c from Cliente c where c.nome like ?!";
        return getList(Cliente.class, query, nome + "%");
    }

    public List<Cliente> getClienteParaLigar(int mes, int ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        Date dataInicial = cal.getTime();

        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);

        Date dataFinal = cal.getTime();

        String query = "select o.cliente from Orcamento o where o.data >= ?1 and o.data <= ?2";

        return getList(Cliente.class, query, dataInicial, dataFinal);
    }

    public List<Cliente> getClientesComPagamentoEmAberto() {
        String query = "select p.orcamento.cliente from Parcela p where p.pago = ?1";
        return getList(Cliente.class, query, Boolean.FALSE);
    }

}
