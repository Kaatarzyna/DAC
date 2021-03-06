package dac.task.auctions.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuctionSlimDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;

}
