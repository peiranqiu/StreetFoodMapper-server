package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import project.models.Favorite;
import project.models.Truck;
import project.models.User;
import project.repositories.FavoriteRepository;
import project.repositories.TruckRepository;
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
  TruckRepository truckRepository;
  @Autowired
  UserRepository userRepository;

  @PostMapping("/api/favorite/{truckId}")
  public void userLikesTruck(@PathVariable("truckId") int truckId,
                                      HttpServletRequest request, HttpServletResponse response) {
    // find truck by id
    Optional<Truck> truckOptional = truckRepository.findById(truckId);

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

    if (truckOptional.isPresent() && userOptional.isPresent()) {
      Truck truck = truckOptional.get();
      User user = userOptional.get();

      List<Favorite> favHistory = (List<Favorite>) favoriteRepository.findAll();
      for (Favorite favorite : favHistory) {
        if (favorite.getUser().getId() == user.getId()
                && favorite.getTruck().getId() == truck.getId()) {
          return;
        }
      }

      Favorite fav = new Favorite();
      fav.setTruck(truck);
      fav.setUser(user);
      favoriteRepository.save(fav);
      return;
    }
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
  }


  @DeleteMapping("/api/favorite/{truckId}")
  public void userUnlikesTruck(@PathVariable("truckId") int truckId,
                                        HttpServletRequest request, HttpServletResponse response) {
    // find truck by id
    Optional<Truck> truckOptional = truckRepository.findById(truckId);

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

    if (truckOptional.isPresent() && userOptional.isPresent()) {
      Truck truck = truckOptional.get();
      User user = userOptional.get();

      List<Favorite> favHistory = (List<Favorite>) favoriteRepository.findAll();
      for (Favorite favorite : favHistory) {
        if (favorite.getUser().getId() == user.getId()
                && favorite.getTruck().getId() == truck.getId()) {
          favoriteRepository.deleteById(favorite.getId());
        }
      }
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
  }


  @GetMapping("/api/favorite/{truckId}")
  public Favorite findFavorite(@PathVariable("truckId") int truckId,
                               HttpServletRequest request, HttpServletResponse response) {
    // find truck by id
    Optional<Truck> truckOptional = truckRepository.findById(truckId);

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

    if (truckOptional.isPresent() && userOptional.isPresent()) {
      Truck truck = truckOptional.get();
      User user = userOptional.get();

      List<Favorite> favHistory = (List<Favorite>) favoriteRepository.findAll();

      for (Favorite favorite : favHistory) {
        if (favorite.getUser().getId() == user.getId()
                && favorite.getTruck().getId() == truck.getId()) {
          return favorite;
        }
      }
    }
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }


  @GetMapping("/api/favorite/user/{userId}")
  public List<Truck> findFavoritesForUser(@PathVariable("userId") int userId) {
    List<Truck> trucks = new ArrayList<Truck>();
    List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();

    for (Favorite fav : favorites) {
      if (fav.getUser().getId() == userId) {
        trucks.add(fav.getTruck());
      }
    }
    return trucks;
  }

  @GetMapping("/api/favorite/truck/{truckId}")
  public List<User> findFollowersForTruck(@PathVariable("truckId") int truckId) {
    List<User> followers = new ArrayList<User>();
    List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();

    for (Favorite fav : favorites) {
      if (fav.getTruck().getId() == truckId) {
        followers.add(fav.getUser());
      }
    }
    return followers;
  }
}