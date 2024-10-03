package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;
import se331.lab.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuctionItemController {

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    @GetMapping("/search")
    public List<AuctionItem> searchAuctionItemsByDescription(@RequestParam String description) {
        return auctionItemRepository.findByDescriptionContainingIgnoreCase(description);
    }

    @GetMapping("/successfulBidLessThan")
    public List<AuctionItem> getAuctionItemsWithSuccessfulBidLessThan(@RequestParam Double amount) {
        return auctionItemRepository.findAuctionItemsBySuccessfulBidLessThan(amount);
    }

    public AuctionItemController(AuctionItemRepository auctionItemRepository) {
        this.auctionItemRepository = auctionItemRepository;
    }

    @GetMapping("/auctions")
    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemRepository.findAll();
    }


}
