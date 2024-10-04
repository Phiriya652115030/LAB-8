package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuctionItemDaoImpl implements AuctionItemDao {
    final AuctionItemRepository auctionItemRepository;

    @Override
    public Page<AuctionItem> getAuctionItem(String name, Pageable pageRequest) {
        return auctionItemRepository.findAll(pageRequest);
    }

    @Override
    public Page<AuctionItem> findByNameAndDescription(String name, String description, Pageable page) {
        return auctionItemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(name, description, page);
    }
}