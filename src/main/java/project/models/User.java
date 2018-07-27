package project.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import project.models.Truck;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	
	@ManyToMany(mappedBy="users")
	private Set<Truck> trucks = new HashSet<>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(Set<Truck> trucks) {
		this.trucks = trucks;
	}
}
