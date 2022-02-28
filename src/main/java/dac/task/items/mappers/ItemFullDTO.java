package dac.task.items.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemFullDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("startAmountInCents")
    Integer startAmountInCents;

    @JsonProperty("bidAmountInCents")
    Integer bidAmountInCents;

    @JsonProperty("startAmountInPLN")
    Integer startAmountInPLN;

    @JsonProperty("bidAmountInPLN")
    Integer bidAmountInPLN;
}
