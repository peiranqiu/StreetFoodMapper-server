package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import project.models.Favorite;
import project.models.Schedule;
import project.models.User;
import project.repositories.FavoriteRepository;
import project.repositories.ScheduleRepository;
import project.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(origins =  "*", maxAge = 3600, allowCredentials = "true")
public class FavoriteService {
  @Autowired
  FavoriteRepository favoriteRepository;
  @Autowired
  ScheduleRepository scheduleRepository;
  @Autowired
  UserRepository userRepository;

  @PostMapping("/api/favorite/{scheduleId}")
  public void userLikesSchedule(@PathVariable("scheduleId") int scheduleId,
                                      HttpServletRequest request, HttpServletResponse response) {
    // find schedule by id
    Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);

    // retrieve user by session
    HttpSession session = request.getSession(false);
    User currentUser = null;
    Optional<User> userOptional = null;
    if (session == null) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    } else {
      currentUser = (User) session.getAttribute("user");
      userOptional = userRepository.findById(currentUser.getId());
    }

    if (scheduleOptional.isPresent() && userOptional.isPresent()) {
      Schedule schedule = scheduleOptional.get();
      User user = userOptional.get();

      List<Favorite> favHistory = (List<Favorite>) favoriteRepository.findAll();
      for (Favorite favorite : favHistory) {
        if (favorite.getUser().getId() == user.getId()
                && favorite.getSchedule().getId() == schedule.getId()) {
          return;
        }
      }

      Favorite fav = new Favorite();
      fav.setSchedule(schedule);
      fav.setUser(user);
      favoriteRepository.save(fav);
      return;
    }
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
  }


  @DeleteMapping("/api/favorite/{scheduleId}")
  public void userUnlikesSchedule(@PathVariable("scheduleId") int scheduleId,
                                        HttpServletRequest request, HttpServletResponse response) {
    // find schedule by id
    Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);

    // retrieve user by session
    HttpSession session = request.getSession(false);
    User currentUser = null;
    Optional<User> userOptional = null;
    if (session == null) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return;
    } else {
      currentUser = (User) session.getAttribute("user");
      userOptional = userRepository.findById(currentUser.getId());
    }

    if (scheduleOptional.isPresent() && userOptional.isPresent()) {
      Schedule schedule = scheduleOptional.get();
      User user = userOptional.get();

      List<Favorite> favHistory = (List<Favorite>) favoriteRepository.findAll();
      for (Favorite favorite : favHistory) {
        if (favorite.getUser().getId() == user.getId()
                && favorite.getSchedule().getId() == schedule.getId()) {
          favoriteRepository.deleteById(favorite.getId());
        }
      }
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
  }


  @GetMapping("/api/favorite/{scheduleId}")
  public Favorite findFavorite(@PathVariable("scheduleId") int scheduleId,
                               HttpServletRequest request, HttpServletResponse response) {
    // find schedule by id
    Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);

    // retrieve user by session
    HttpSession session = request.getSession(false);
    User currentUser = null;
    Optional<User> userOptional = null;
    if (session == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    } else {
      currentUser = (User) session.getAttribute("user");
      userOptional = userRepository.findById(currentUser.getId());
    }

    if (scheduleOptional.isPresent() && userOptional.isPresent()) {
      Schedule schedule = scheduleOptional.get();
      User user = userOptional.get();

      List<Favorite> favHistory = (List<Favorite>) favoriteRepository.findAll();

      for (Favorite favorite : favHistory) {
        if (favorite.getUser().getId() == user.getId()
                && favorite.getSchedule().getId() == schedule.getId()) {
          return favorite;
        }
      }
    }
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }


  @GetMapping("/api/favorite/user/{userId}")
  public List<Schedule> findFavoritesForUser(@PathVariable("userId") int userId) {
    List<Schedule> schedules = new ArrayList<Schedule>();
    List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();

    for (Favorite fav : favorites) {
      if (fav.getUser().getId() == userId) {
        schedules.add(fav.getSchedule());
      }
    }
    return schedules;
  }

  @GetMapping("/api/favorite/schedule/{scheduleId}")
  public List<User> findFollowersForSchedule(@PathVariable("scheduleId") int scheduleId) {
    List<User> followers = new ArrayList<User>();
    List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();

    for (Favorite fav : favorites) {
      if (fav.getSchedule().getId() == scheduleId) {
        followers.add(fav.getUser());
      }
    }
    return followers;
  }
}