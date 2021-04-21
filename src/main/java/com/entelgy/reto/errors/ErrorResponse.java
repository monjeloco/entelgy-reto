package com.entelgy.reto.errors;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 2632145854787557720L;

	private String codigo;
	private String mensaje;

	public ErrorResponse(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
