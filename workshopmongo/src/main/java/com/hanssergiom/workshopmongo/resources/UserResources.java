package com.hanssergiom.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hanssergiom.workshopmongo.domain.User;
import com.hanssergiom.workshopmongo.dto.UserDTO;
import com.hanssergiom.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>>findAll() {
		//DATA TRANSFER OBJECT Camada de visão (view layer) e outra de persistência dos dados (model layer).
		List<User> list =service.findAll();
		List<UserDTO> listDto=list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

}
