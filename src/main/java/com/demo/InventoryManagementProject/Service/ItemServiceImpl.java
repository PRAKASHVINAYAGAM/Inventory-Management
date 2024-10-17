package com.demo.InventoryManagementProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.InventoryManagementProject.Entity.Item;
import com.demo.InventoryManagementProject.Exception.ItemNotFoundException;
import com.demo.InventoryManagementProject.Repository.ItemRepository;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        
        item.setCreatedDate(LocalDateTime.now());
        item.setUpdatedDate(LocalDateTime.now()); 
        return itemRepository.save(item);
    }

    @Override
    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Long id, Item updatedItem) {
    	
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));

       
        existingItem.setName(updatedItem.getName());
        existingItem.setQuantity(updatedItem.getQuantity());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setSku(updatedItem.getSku());
        existingItem.setUpdatedDate(LocalDateTime.now()); 

        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long id) 
    {
        if (!itemRepository.existsById(id)) 
        {
            throw new ItemNotFoundException("Item with ID " + id + " not found");
        }
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }
}

