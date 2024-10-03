package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.AuctionItem;
import se331.lab.entity.Participant;

import java.util.Optional;

public interface AuctionItemDao {
    Page<AuctionItem> getAuctionItem(String name,Pageable pageRequest);
    Page<AuctionItem> findByNameAndDescription(String name, String description, Pageable page);
}