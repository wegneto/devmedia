package com.wegneto.pastelariaonline.domain;

import java.util.List;

import com.google.gson.Gson;

public class Pedidos {
	private List<Pedido> pedidos;

	public Pedidos(final List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public String asJson() {
		final Gson gson = new Gson();
		final String json = gson.toJson(this);
		return json;
	}
}
