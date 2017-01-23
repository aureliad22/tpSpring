package fr.imie.spring.repository;

import org.springframework.data.repository.CrudRepository;

import fr.imie.spring.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByLogin(String login);
	
	User findById(Integer id);
}
