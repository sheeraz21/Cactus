package com.hackerrank.gevents.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.repository.EventRepository;
import com.hackerrank.gevents.utill.EventUtil;

@RestController()
public class EventController {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	EventUtil eventUtil;

	@PostMapping("/events")
	public ResponseEntity<Void> addEvent(@RequestBody Event event, UriComponentsBuilder builder) {

		boolean flag = eventUtil.getEventType(event.getType());

		if (flag == false) {

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(builder.path("/events/{id}").buildAndExpand(event.getId()).toUri());

		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllevents() {

		List<Event> events = eventRepository.findAll();

		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);

	}

	@GetMapping("/repos/{repoId}/events")
	public ResponseEntity<Optional<Event>> getEventByRepoId(@PathVariable("repoId") Integer repoId) {

		Optional<Event> events = eventRepository.findById(repoId);

		return new ResponseEntity<Optional<Event>>(events, HttpStatus.OK);

	}

	@GetMapping("/users/{userId}/events")
	public ResponseEntity<Optional<Event>> getEventByUserId(@PathVariable("userId") Integer userId) {

		Optional<Event> events = eventRepository.findById(userId);

		return new ResponseEntity<Optional<Event>>(events, HttpStatus.OK);

	}

	@GetMapping("/events/{eventId}")
	public ResponseEntity<Optional<Event>> getEventByEventId(@PathVariable("eventId") Integer eventId) {

		Optional<Event> events = eventRepository.findById(eventId);

		return new ResponseEntity<Optional<Event>>(events, HttpStatus.OK);

	}

	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<Void> deleteEventsByEventId(@PathVariable("eventId") Integer eventId) {

		eventRepository.deleteById(eventId);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}

}
