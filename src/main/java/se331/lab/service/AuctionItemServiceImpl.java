package se331.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.dao.AuctionItemDao;
import se331.lab.entity.AuctionItem;
import se331.lab.repository.AuctionItemRepository;

import java.util.List;
@Service // Make sure this class is recognized as a service
public class AuctionItemServiceImpl implements AuctionItemService {
    final AuctionItemDao auctionItemDao;

    // Constructor to initialize auctionItemDao
    public AuctionItemServiceImpl(AuctionItemDao auctionItemDao) {
        this.auctionItemDao = auctionItemDao; // Initializing the final variable
    }

    @Override
    public Page<AuctionItem> findByNameAndDescription(String title, String description, Pageable pageable) {
        // Correct the method call to utilize name and description
        return auctionItemDao.findByNameAndDescription(title, description, pageable); // Ensure this method is defined properly in AuctionItemDao
    }
}

