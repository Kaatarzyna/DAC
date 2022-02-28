package dac.task.auctions;

import dac.task.auctions.mappers.AuctionFullDTO;
import dac.task.auctions.mappers.AuctionSlimDTO;
import org.springframework.web.bind.annotation.*;

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
    Auction create(@RequestBody AuctionFullDTO auctionDTO) {
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
