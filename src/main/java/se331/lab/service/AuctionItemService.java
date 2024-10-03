package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

import java.util.List;


public interface AuctionItemService {

    Page<AuctionItem> findByNameAndDescription(String name, String description, Pageable page);



}
