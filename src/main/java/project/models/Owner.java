package project.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "OWNER")
public class Owner extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "TRUCKS")
	@OneToMany(mappedBy="owner")
	private List<Truck> trucks;
	
	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

}
