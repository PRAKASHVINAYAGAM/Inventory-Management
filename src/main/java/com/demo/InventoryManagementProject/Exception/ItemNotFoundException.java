package com.demo.InventoryManagementProject.Exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String message) {
        super(message);  
    }
}