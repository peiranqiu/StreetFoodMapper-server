package project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorite")
public class Favorite {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @OneToOne
  private Schedule schedule;
  @OneToOne
  private User user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Schedule getSchedule() {
	return schedule;
}

public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
}
}