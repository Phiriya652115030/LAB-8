package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDTO(Event event);
    List<EventDTO> getEventDTO(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDTO getParticipantDTO(Participant participant);
    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);

    // Add mappings for EventParticipantDTO
    EventParticipantDTO getEventParticipantDTO(Participant participant);
    List<EventParticipantDTO> getEventParticipantDTO(List<Participant> participants);

    AuctionItemDTO getAuctionItemDTO(AuctionItem auctionItem);
    List<AuctionItemDTO> getAuctionItemDTO(List<AuctionItem> auctionItems);
}