package rs.ac.uns.ftn.informatika.Cinema.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name ="Korisnici")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name="Ime",columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(name="Prezime",columnDefinition="VARCHAR(40)")
	private String lastname;
	
	@Column(name="Email",columnDefinition="VARCHAR(50)", unique = true)
	private String email;
	
	@Column(name="Lozinka",columnDefinition="VARCHAR(30)")
	private String password;
	
	@Column(name="Grad",columnDefinition="VARCHAR(40)")
	private String city;
	
	@Column(name="Telefon",columnDefinition="VARCHAR(15)")
	private String phone;
	
	//Konstruktori
	
	public User() {
	}
	
	public User(String name,String lastname,String email,String password,String city,String phone) {
		
		this.name     = name;
		this.lastname = lastname;
		this.email    = email;
		this.password = password;
		this.city     = city;
		this.phone    = phone;
	}
	
	//Geteri i Seteri
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	} 
	
}
