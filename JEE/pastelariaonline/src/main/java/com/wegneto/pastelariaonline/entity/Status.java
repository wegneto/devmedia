package com.wegneto.pastelariaonline.entity;

public enum Status {
	N("Novo"), A("Em atendimento"), C("Cancelado"), F("Finalizado");

	private String descricao;

	Status(final String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return descricao;
	}
}