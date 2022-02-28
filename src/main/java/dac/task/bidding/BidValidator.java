package dac.task.bidding;

import dac.task.exceptions.ItemNotFoundException;
import dac.task.items.Item;
import dac.task.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BidValidator implements ConstraintValidator<BidConstraint, BidDTO> {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void initialize(BidConstraint constraintAnnotation) {}

    @Override
    public boolean isValid(BidDTO bid, ConstraintValidatorContext ctx) {
        Item item = itemRepository.findById(bid.getItemId()).orElseThrow(ItemNotFoundException::new);

        Integer currentBid = item.getBidAmountInCents() != null ? item.getBidAmountInCents() : item.getStartAmountInCents();
        return bid.getAmount() > currentBid;
    }
}
