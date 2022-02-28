package dac.task.auctions;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Auction {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;
}
