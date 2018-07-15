package com.example.myapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Widget;
import com.example.myapp.models.Topic;
import com.example.myapp.repositories.WidgetRepository;
import com.example.myapp.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WidgetService {
	@Autowired
	WidgetRepository widgetRepository;
	@Autowired
	TopicRepository topicRepository;
	

	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") int widgetId)
	{
		widgetRepository.deleteById(widgetId);
	}
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets()
	{
		return (List<Widget>) widgetRepository.findAll();
	}
	
	@GetMapping("/api/widget/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/widget/{widgetId}")
	public Widget updateWidget(@PathVariable("widgetId") int widgetId, @RequestBody Widget newWidget) {
		Optional<Widget> data = widgetRepository.findById(widgetId);
		if (data.isPresent()) {
			Widget widget = data.get();
			widget.setId(newWidget.getId());
			widget.setText(newWidget.getText());

			widgetRepository.save(widget);
			return widget;
		}
		return null;
	}
	
	@GetMapping("/api/topic/{topicId}/widget")
	public List<Widget> findAllWidgetsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> optionalTopic = topicRepository.findById(topicId);
		if(optionalTopic.isPresent()) {
			Topic topic = optionalTopic.get();
			return topic.getWidgets();
		}
		return null;
	}
	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody
			List<Widget> widgets) {
		widgetRepository.deleteAll();
		for(Widget widget: widgets) {
			widgetRepository.save(widget);
		}
	}
}