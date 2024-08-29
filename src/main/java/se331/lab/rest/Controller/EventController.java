package se331.lab.rest.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.lab.rest.entity.Event;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {

    List<Event> eventList;

    @GetMapping("events")
    public ResponseEntity<?> getEventLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {
        perPage = perPage == null ? eventList.size() : perPage;
        page = page == null ? 1 : page;
        Integer firstIndex = (page - 1) * perPage;
        List<Event> output = new ArrayList<>();

        try {
            for (int i = firstIndex; i < firstIndex + perPage && i < eventList.size(); i++) {
                output.add(eventList.get(i));
            }
            return ResponseEntity.ok(output);
        } catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.ok(output);  // Return the events found up to the exception
        }
    }
    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();

        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petsAllowed(true)
                .organizer("Kat Laydee")
                .build());

        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petsAllowed(true)
                .organizer("Fern Pollin")
                .build());

        // Adding the rest of the events from db.json
        eventList.add(Event.builder()
                .id(5928101L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petsAllowed(true)
                .organizer("Kat Laydee")
                .build());

        eventList.add(Event.builder()
                .id(4582797L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petsAllowed(true)
                .organizer("Fern Pollin")
                .build());

        eventList.add(Event.builder()
                .id(8419988L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petsAllowed(false)
                .organizer("Carey Wales")
                .build());

        eventList.add(Event.builder()
                .id(8175648L)
                .category("sport")
                .title("Swimming")
                .description("Let's be the first who can swim in the ocean.")
                .location("Phuket")
                .date("July 12, 2022")
                .time("15:00")
                .petsAllowed(false)
                .organizer("Ned")
                .build());

        eventList.add(Event.builder()
                .id(1002L)
                .category("food")
                .title("Canned Food Drive")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .date("September 14, 2022")
                .time("3:00")
                .petsAllowed(true)
                .organizer("Kahn Opiner")
                .build());

        eventList.add(Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petsAllowed(false)
                .organizer("Brody Kill")
                .build());
    }
}
