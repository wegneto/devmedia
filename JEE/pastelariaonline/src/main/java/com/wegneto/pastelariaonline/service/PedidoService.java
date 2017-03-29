package com.wegneto.pastelariaonline.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.google.common.base.Preconditions;
import com.wegneto.pastelariaonline.entity.Pedido;
import com.wegneto.pastelariaonline.entity.Status;
import com.wegneto.pastelariaonline.vo.Pedidos;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PedidoService {

	@PersistenceContext
	private EntityManager entityManager;

	public void registrar(final Pedido pedido) {
		entityManager.persist(pedido);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Pedidos pendentes() {
		final TypedQuery<Pedido> namedQuery = entityManager.createNamedQuery("Pedido.buscarNovosEemAtendimento",
				Pedido.class);
		namedQuery.setParameter("novo", Status.N);
		namedQuery.setParameter("atendimento", Status.A);
		final List<Pedido> pedidos = namedQuery.getResultList();
		return new Pedidos(pedidos);
	}

	public void atender(final Long id, final String atendente) {
		final Pedido p = entityManager.find(Pedido.class, id);
		Preconditions.checkState(p.getStatus() == Status.N, "Pedido ja em atendimento");
		p.setStatus(Status.A);
		p.setDataAtendimento(new Date());
		p.setAtendente(atendente);
	}
}