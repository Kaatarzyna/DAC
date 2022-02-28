package dac.task.items;

import dac.task.items.mappers.ItemCreateDTO;
import dac.task.items.mappers.ItemFullDTO;
import dac.task.items.mappers.ItemSlimDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemRESTController {

    final ItemService itemService;

    public ItemRESTController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Item create(@RequestBody ItemCreateDTO itemDTO) {
        return itemService.save(itemDTO);
    }

    @GetMapping("/onAuction/{id}")
    List<ItemSlimDTO> index(@PathVariable UUID id) {
        return itemService.findItemsOnAuction(id);
    }

    @GetMapping("{id}")
    ItemFullDTO show(@PathVariable UUID id) {
        return itemService.find(id);
    }

}
