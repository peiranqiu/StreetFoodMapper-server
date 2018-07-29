package project.models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Truck {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String yelpId;
	private Boolean isOpen;
	private String name;
	private String url;
	private String website;
	private String menu;
	private String phone;
	private String twitter;
	private int rating;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "category1")
	private Category category1;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "category2")
	private Category category2;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "category3")
	private Category category3;
	
	@OneToMany(mappedBy="truck", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Review> reviews;
	
	@OneToMany(mappedBy="truck", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Photo> photos;
	
	@OneToMany(mappedBy="truck", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Holiday> holidays;
	
	@OneToMany(mappedBy="truck", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private List<Schedule> schedules;
	
	@ManyToOne
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Owner owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYelpId() {
		return yelpId;
	}

	public void setYelpId(String yelpId) {
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public Category getCategory1() {
		return category1;
	}

	public void setCategory1(Category category1) {
		this.category1 = category1;
	}

	public Category getCategory2() {
		return category2;
	}

	public void setCategory2(Category category2) {
		this.category2 = category2;
	}

	public Category getCategory3() {
		return category3;
	}

	public void setCategory3(Category category3) {
		this.category3 = category3;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
	
}