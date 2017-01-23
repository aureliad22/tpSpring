package fr.imie.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.imie.spring.entity.User;
import fr.imie.spring.repository.UserRepository;

@SpringBootApplication
public class Main implements CommandLineRunner{

	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
    	SpringApplication.run(Main.class, args);
	}

	@Override
	public void run (String...args) throws Exception{
		User user = new User("Toto", "toto22");
		user.setFirstName("Administrator");
		
		this.repository.save(user);
		
		for (User user1 : repository.findAll()) {
            System.out.println(user1.toString());
        }
	}
}
