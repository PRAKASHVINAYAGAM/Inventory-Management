package com.demo.InventoryManagementProject.Repository;
import org.springframework.stereotype.Repository;

import com.demo.InventoryManagementProject.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}