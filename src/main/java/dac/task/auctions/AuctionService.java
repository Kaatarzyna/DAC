package dac.task.auctions;

import dac.task.auctions.mappers.AuctionFullDTO;
import dac.task.auctions.mappers.AuctionMapper;
import dac.task.auctions.mappers.AuctionSlimDTO;
import dac.task.exceptions.AuctionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuctionService {

    final AuctionRepository auctionRepository;
    final AuctionMapper auctionMapper;

    public AuctionService(AuctionRepository auctionRepository, AuctionMapper auctionMapper) {
        this.auctionRepository = auctionRepository;
        this.auctionMapper = auctionMapper;
    }

    List<AuctionSlimDTO> findAll() {
        List<Auction> auctions = auctionRepository.findAll();
        return auctionMapper.auctionsToDtos(auctions);
    }

    AuctionFullDTO find(UUID id) {
        Auction auction = auctionRepository.findById(id).orElseThrow(AuctionNotFoundException::new);
        return auctionMapper.auctionToDto(auction);
    }

    Auction save(AuctionFullDTO auctionDTO) {
        Auction auction = auctionMapper.dtoToAuction(auctionDTO);
        return auctionRepository.save(auction);
    }

}
