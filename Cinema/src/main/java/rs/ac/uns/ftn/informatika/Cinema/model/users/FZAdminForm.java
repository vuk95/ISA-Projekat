package rs.ac.uns.ftn.informatika.Cinema.model.users;

public class FZAdminForm {

	private Long id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String lastname;
	
	private String city;
	
	private String phone;
	
	public FZAdminForm() {
		
	}
	
	public FZAdminForm(Administrator user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.name = user.getName();
		this.lastname = user.getLastname();
		this.city = user.getCity();
		this.phone = user.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
