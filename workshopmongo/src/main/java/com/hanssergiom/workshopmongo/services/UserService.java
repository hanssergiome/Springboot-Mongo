package com.hanssergiom.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanssergiom.workshopmongo.domain.User;
import com.hanssergiom.workshopmongo.dto.UserDTO;
import com.hanssergiom.workshopmongo.repository.UserRepository;
import com.hanssergiom.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// instanciar automaticamente objeto autowired
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {

		return repo.findAll();

	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {

		return repo.insert(obj);

	}

	public User fromDTO(UserDTO objDto) {

		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

	}
}
