package dac.task.items;

import dac.task.auctions.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    List<Item> findAllByAuction(Auction auction);
}
