package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionItemService {

    final AuctionItemRepository auctionItemRepository;

    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemRepository.findAll();
    }
}
