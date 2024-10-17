package com.demo.InventoryManagementProject.Service;


import com.demo.InventoryManagementProject.Entity.Item;
import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    List<Item> listItems();
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item getItemById(Long id);
}

