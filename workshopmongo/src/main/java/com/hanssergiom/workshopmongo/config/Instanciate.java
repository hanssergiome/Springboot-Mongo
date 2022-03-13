package com.hanssergiom.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hanssergiom.workshopmongo.domain.User;
import com.hanssergiom.workshopmongo.repository.UserRepository;

@Configuration
public class Instanciate implements CommandLineRunner {
	
	
	@Autowired
	private UserRepository userrepository;
	
	@Override
	public void run(String...arg0) throws Exception {
		
		userrepository.deleteAll();
		User maria = new User(null, "Maria", "maria@gmail.com");
		User alex = new User(null, "Alex", "alex@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");	
		
		userrepository.saveAll(Arrays.asList(maria, alex, bob));
	}
	
		

}
