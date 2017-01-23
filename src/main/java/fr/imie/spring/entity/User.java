package fr.imie.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sys_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="fname")
	@NotNull
	private String firstName;
	
	@Column(name="lname")
	@NotNull
	private String lastName;
	
	@Column(name="login")
	@NotNull
	private String login;
	
	@Column(name="password")
	@NotNull
	private String password;

	protected User(){
	//nécessaire pour certains ORM.	
	}
	
	public User(Long id) {
		this.id = id;
	}
	
	public User(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	@Override
	public String toString(){
		return String.format("User[id=%d, login='%s'", 
				this.id, 
				this.login);
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param username the username to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
