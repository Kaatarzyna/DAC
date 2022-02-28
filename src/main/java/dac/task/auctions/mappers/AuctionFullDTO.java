package dac.task.auctions.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class AuctionFullDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @JsonProperty("description")
    @NotBlank(message = "Description is mandatory")
    private String description;

}
