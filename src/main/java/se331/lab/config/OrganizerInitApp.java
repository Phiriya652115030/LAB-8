package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;
import se331.lab.repository.OrganizerRepository;

@Repository
@RequiredArgsConstructor
public class OrganizerInitApp implements ApplicationListener<ApplicationReadyEvent> {
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .organizationName("Animal Welfare Organization")
                .address("123 Meow Town")
                .build());

        organizerRepository.save(Organizer.builder()
                .organizationName("Community Gardeners")
                .address("456 Flora City")
                .build());

        organizerRepository.save(Organizer.builder()
                .organizationName("Art Collective")
                .address("789 Art Street")
                .build());

        organizerRepository.save(Organizer.builder()
                .organizationName("Tech Innovators")
                .address("1010 Silicon Valley")
                .build());

        // Add more organizers as needed
    }
}
