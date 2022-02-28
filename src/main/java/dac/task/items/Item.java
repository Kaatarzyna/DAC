package dac.task.items;

import dac.task.auctions.Auction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "auction_id")
    Auction auction;

    String name;

    String description;

    Integer startAmountInCents;

    Integer bidAmountInCents;

    Integer startAmountInPln;

    Integer bidAmountInPln;
}
