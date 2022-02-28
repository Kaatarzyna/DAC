package dac.task.auctions.mappers;

import dac.task.auctions.Auction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuctionMapper {

    AuctionFullDTO auctionToDto(Auction auction);

    Auction dtoToAuction(AuctionFullDTO auctionDTO);

    List<AuctionSlimDTO> auctionsToDtos(List<Auction> auctions);

    AuctionSlimDTO auctionToSlimDto(Auction auction);

}
