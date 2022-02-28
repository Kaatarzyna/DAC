package dac.task.items.mappers;

import dac.task.auctions.AuctionRepository;
import dac.task.items.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuctionRepository.class})
public interface ItemMapper {

    ItemFullDTO itemToDto(Item item);

    Item createDtoToItem(ItemCreateDTO itemDTO);

    List<ItemSlimDTO> itemsToSlimDtos(List<Item> items);

    @SuppressWarnings("unused")
    ItemSlimDTO itemToSlimDto(Item item);

}
