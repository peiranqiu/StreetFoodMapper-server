package project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String href;
    
    @ManyToOne
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Truck truck;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}


}
