package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizerService;

import java.util.List;

@RestController  // <-- Use @RestController
@RequiredArgsConstructor
@RequestMapping("/organizers")
public class OrganizerController {
    final OrganizerService organizerService;

    @PostMapping
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer) {
        Organizer savedOrganizer = organizerService.save(organizer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrganizer);
    }

    @GetMapping
    public ResponseEntity<?> getOrganizerList(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {

        Integer organizerSize = organizerService.getOrganizerSize();

        perPage = perPage == null ? organizerSize : perPage;
        page = page == null ? 1 : page;

        List<Organizer> output = organizerService.getOrganizers(perPage, page);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizer(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizer not found");
        }
    }
}
