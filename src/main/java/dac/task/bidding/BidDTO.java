package dac.task.bidding;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@BidConstraint
public class BidDTO {

    @NotNull
    Integer amount;

    UUID itemId;

}
