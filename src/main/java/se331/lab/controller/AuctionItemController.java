package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.entity.AuctionItem;
import se331.lab.entity.AuctionItemDTO; // Import the AuctionItemDTO
import se331.lab.service.AuctionItemService;
import se331.lab.util.LabMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auctions")
@RequiredArgsConstructor
public class AuctionItemController {

    final AuctionItemService auctionItemService; // Use a service for business logic

    @GetMapping
    public ResponseEntity<List<AuctionItemDTO>> getAllAuctionItems() {
        List<AuctionItem> auctionItems = auctionItemService.getAllAuctionItems(); // Call the service method

        // Convert the list of auction items to DTOs
        List<AuctionItemDTO> auctionItemDTOs = auctionItems.stream()
                .map(item -> LabMapper.INSTANCE.getAuctionItemDTO(item)) // Convert to DTO
                .collect(Collectors.toList());

        return ResponseEntity.ok(auctionItemDTOs); // Return the DTOs
    }
}
