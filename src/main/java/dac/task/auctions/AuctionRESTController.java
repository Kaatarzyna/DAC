package dac.task.auctions;

import dac.task.auctions.mappers.AuctionFullDTO;
import dac.task.auctions.mappers.AuctionSlimDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auctions")
public class AuctionRESTController {

    final AuctionService auctionService;

    public AuctionRESTController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Auction create(@RequestBody @Valid AuctionFullDTO auctionDTO) {
        return auctionService.save(auctionDTO);
    }

    @GetMapping
    List<AuctionSlimDTO> index() {
        return auctionService.findAll();
    }

    @GetMapping("{id}")
    AuctionFullDTO show(@PathVariable UUID id) {
        return auctionService.find(id);
    }


}
