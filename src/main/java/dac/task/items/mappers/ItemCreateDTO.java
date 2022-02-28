package dac.task.items.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class ItemCreateDTO {

    @JsonProperty("auctionId")
    @NotNull(message = "AuctionId is mandatory")
    UUID auctionId;

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    String name;

    @JsonProperty("description")
    @NotBlank(message = "Description is mandatory")
    String description;

    @JsonProperty("startAmountInCents")
    @NotNull(message = "StartAmountInCents is mandatory")
    Integer startAmountInCents;

}
