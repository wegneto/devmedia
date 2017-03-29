package com.wegneto.pastelariaonline.vo;

import java.io.Serializable;

public class Resultado implements Serializable {

	private static final long serialVersionUID = 2170294401108447645L;
	private boolean success;
	private String message;

	public Resultado() {
	}

	public Resultado(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}