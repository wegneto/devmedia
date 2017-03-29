package com.wegneto.pastelariaonline.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Item implements Serializable {

	private static final long serialVersionUID = -3778397739515571369L;

	@Column(name = "sabor", nullable = false, length = 150)
	private String sabor;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}