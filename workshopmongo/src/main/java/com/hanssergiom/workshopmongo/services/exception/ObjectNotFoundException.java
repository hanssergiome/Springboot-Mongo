package com.hanssergiom.workshopmongo.services.exception;

//Macete classe auxiliar pra tratar excess�o
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {

		super(msg);

	}
}