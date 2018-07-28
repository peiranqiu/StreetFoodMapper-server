package project.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.models.Photo;
import project.models.Review;
import project.models.Truck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins =  "*", maxAge = 3600, allowCredentials = "true")
// @CrossOrigin(origins = "https://foodtruckmapper.herokuapp.com",
// allowCredentials = "true")
public class YelpService {

	ObjectMapper mapper = new ObjectMapper();
	OkHttpClient client = new OkHttpClient();
	String YELP_API_KEY = "apR1p2KGGz8v52Q1KxImt4xNsJ04-MARDS7ssayXkXx8EksSZxOLa1Wfa4"
			+ "Fo29v6G0ftWYT6CsWyaknfttuSdu9n14iXEpomQ6-l3ExoZf7ra3kUVYNKeAq3EKpaW3Yx";

	@ResponseBody
	@GetMapping("/api/yelp/truck/phone/{phone}")
	String findYelpIdByMatching(@PathVariable("phone") String phone, HttpServletResponse responsebody)
			throws IOException, JSONException {
		String url = "https://api.yelp.com/v3/businesses/search/phone";
		url = url + "?phone=" + phone;

		Request request = new Request.Builder().url(url).get().addHeader("authorization", "Bearer " + YELP_API_KEY)
				.addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();

		JSONObject jsonObject = new JSONObject(response.body().string().trim());
		JSONArray myResponse = (JSONArray) jsonObject.get("businesses");

		if (myResponse.length() < 1) {
			responsebody.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}

		return myResponse.getJSONObject(0).getString("id");
	}

	@GetMapping("/api/yelp/truck/{yelpId}")
	Truck findTruckByYelpId(@PathVariable("yelpId") String yelpId) throws IOException, JSONException {
		Request request = new Request.Builder().url("https://api.yelp.com/v3/businesses/" + yelpId).get()
				.addHeader("authorization", "Bearer " + YELP_API_KEY).addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();

		JSONObject jsonObject = new JSONObject(response.body().string().trim());

		return jsonToTruck(jsonObject);
	}

	@GetMapping("/api/yelp/truck/{yelpId}/review")
	List<Review> findTruckReviewsByYelpId(@PathVariable("yelpId") String yelpId) throws IOException, JSONException {
		Request request = new Request.Builder().url("https://api.yelp.com/v3/businesses/" + yelpId + "/reviews").get()
				.addHeader("authorization", "Bearer " + YELP_API_KEY).addHeader("cache-control", "no-cache").build();

		Response response = client.newCall(request).execute();

		JSONObject jsonObject = new JSONObject(response.body().string().trim());
		JSONArray myResponse = (JSONArray) jsonObject.get("reviews");
		List<Review> reviews = new ArrayList<Review>();
		for (int i = 0; i < 3; i++) {
			JSONObject temp = myResponse.getJSONObject(i);
			Review review = jsonToReview(temp);
			reviews.add(review);
		}

		return reviews;
	}

	Review jsonToReview(JSONObject object) throws JSONException {

		Review review = new Review();

		review.setUserName(object.getJSONObject("user").getString("name"));
		review.setText(object.getString("text"));
		review.setTimeCreated(object.getString("time_created"));
		review.setRating(object.getInt("rating"));

		return review;
	}

	Truck jsonToTruck(JSONObject object) throws JSONException {

		Truck truck = new Truck();

		truck.setYelpId(object.getString("id"));
		truck.setName(object.getString("name"));
		truck.setUrl(object.getString("url"));
		truck.setPhone(object.getString("phone"));
		truck.setRating(object.getInt("rating"));
		JSONArray myResponse = object.getJSONArray("photos");
		List<Photo> photos = new ArrayList<Photo>();
		for (int i = 0; i < 3; i++) {
			Photo photo = new Photo();
			photo.setHref(myResponse.get(i).toString());
			photos.add(photo);
		}
		truck.setPhotos(photos);

		return truck;
	}
}