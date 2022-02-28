package dac.task.bidding;

import dac.task.items.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bid")
public class BidRESTController {

    final ItemService itemService;

    public BidRESTController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PutMapping
    String bid(@RequestBody @Valid BidDTO bid) {
        itemService.bid(bid);
        return HttpStatus.OK.toString();
    }

}
