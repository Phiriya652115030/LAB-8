package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se331.lab.entity.AuctionItem;

import java.util.List;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findByDescriptionContainingIgnoreCase(String description);
    @Query("SELECT a FROM AuctionItem a JOIN a.bids b WHERE b.successful = true AND b.bidAmount < :amount")
    List<AuctionItem> findAuctionItemsBySuccessfulBidLessThan(@Param("amount") Double amount);
}
