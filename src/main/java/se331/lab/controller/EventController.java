package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Event;

import jakarta.annotation.PostConstruct;
import se331.lab.service.EventService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {
    final EventService eventService;

    @GetMapping("events")
    public ResponseEntity<?> getEventLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        // Getting the event size from the service
        Integer eventSize = eventService.getEventSize();

        // Setting default values if necessary
        perPage = perPage == null ? eventSize : perPage;
        page = page == null ? 1 : page;

        // Creating HttpHeaders to include the total count of events
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("X-Total-Count", String.valueOf(eventSize));

        try {
            // Fetching paginated events from the service
            List<Event> output = eventService.getEvents(perPage, page);
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(null, responseHeader, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        // Fetching a single event by id using the service
        Event output = eventService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}