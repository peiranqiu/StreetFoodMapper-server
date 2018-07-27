package project.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Truck {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int yelpId;
	
	private String name;
	private String url;
	private String menu;
	private String phone;
	private String twitter;
	private float rating;
	
	@OneToMany(mappedBy="truck", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Review> reviews;
	
	@ElementCollection
	@CollectionTable(name = "images")
	@Column(name = "imagesOfTruck", nullable = false)
	private List<String> images;
	
	@ElementCollection
	@CollectionTable(name = "holidays")
	@Column(name = "holidaysOfTruck", nullable = false)
	private List<String> holidays;
	
	@ElementCollection(targetClass = Category.class)
	@CollectionTable(name = "categories")
	@Column(name = "categoriesOfTruck", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Category> categories;
	
	@OneToMany(mappedBy="truck", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Schedule> schedules;
	
	@ManyToOne
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Owner owner;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "user_truck", joinColumns = @JoinColumn(name = "truck_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYelpId() {
		return yelpId;
	}

	public void setYelpId(int yelpId) {
		this.yelpId = yelpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public List<String> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<String> holidays) {
		this.holidays = holidays;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}