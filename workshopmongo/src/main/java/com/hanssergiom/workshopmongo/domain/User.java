package com.hanssergiom.workshopmongo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//integrando com o banco MONGO, collection = pasta no banco"
@Document(collection = "user")

// Serializable - objetos convertidos em bytes para serem trafegados em redes ou gravados em arquivo.
public class User implements Serializable {
	// User setado como Serial Padrão
	private static final long serialVersionUID = 1L;
	//
	@Id
	private String id;
	private String name;
	private String email;

	public User() {

	}

// Source Construtores
	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// Source Gets and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Source Hash/Equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
