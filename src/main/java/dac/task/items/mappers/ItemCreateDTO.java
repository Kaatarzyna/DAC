package dac.task.items.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemCreateDTO {

    @JsonProperty("auctionId")
    UUID auctionId;

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("startAmountInCents")
    Integer startAmountInCents;

}
