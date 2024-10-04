package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Page<AuctionItemDTO>> getAllAuctionItems(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Boolean successfulBid,
            Pageable pageable) {  // Add pagination

        // Call the service method with search parameters
        Page<AuctionItem> auctionItems = auctionItemService.findByNameAndDescription(name, description, pageable);

        // Convert the Page of auction items to a Page of DTOs
        Page<AuctionItemDTO> auctionItemDTOs = auctionItems.map(item -> LabMapper.INSTANCE.getAuctionItemDTO(item));

        return ResponseEntity.ok(auctionItemDTOs); // Return the DTOs
    }
}
