package project.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "FAVORITES")
	@OneToMany(mappedBy="customer")
	private List<Truck> favorites;
	
	public List<Truck> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Truck> favorites) {
		this.favorites = favorites;
	}

}
