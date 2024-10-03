package se331.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/auctionItems")
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
}
