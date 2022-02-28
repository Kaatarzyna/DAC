package dac.task.items.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemSlimDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    String name;

}
