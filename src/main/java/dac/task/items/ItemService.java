package dac.task.items;

import dac.task.auctions.Auction;
import dac.task.auctions.AuctionRepository;
import dac.task.exceptions.AuctionNotFoundException;
import dac.task.exceptions.ItemNotFoundException;
import dac.task.integrations.CurrencyService;
import dac.task.items.mappers.ItemCreateDTO;
import dac.task.items.mappers.ItemFullDTO;
import dac.task.items.mappers.ItemMapper;
import dac.task.items.mappers.ItemSlimDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    final ItemRepository itemRepository;
    final ItemMapper itemMapper;

    final AuctionRepository auctionRepository;

    final CurrencyService currencyService;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, AuctionRepository auctionRepository, CurrencyService currencyService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.auctionRepository = auctionRepository;
        this.currencyService = currencyService;
    }

    List<ItemSlimDTO> findItemsOnAuction(UUID id) {
        Auction auction = auctionRepository.findById(id).orElseThrow(AuctionNotFoundException::new);

        List<Item> items = itemRepository.findAllByAuction(auction);
        return itemMapper.itemsToSlimDtos(items);
    }

    ItemFullDTO find(UUID id) {
        Item item = itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
        return itemMapper.itemToDto(item);
    }

    ItemFullDTO save(ItemCreateDTO itemDTO) {
        Auction auction = auctionRepository.findById(itemDTO.getAuctionId()).orElseThrow(AuctionNotFoundException::new);

        Item item = itemMapper.createDtoToItem(itemDTO);
        item.auction = auction;
        item.startAmountInPln = currencyService.convertToPln(item.startAmountInCents);

        return itemMapper.itemToDto(itemRepository.save(item));
    }
}
