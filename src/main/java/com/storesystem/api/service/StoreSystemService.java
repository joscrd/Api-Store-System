package com.storesystem.api.service;

import com.storesystem.api.collection.Item;
import com.storesystem.api.repository.StoreSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StoreSystemService {

    @Autowired
    private  StoreSystemRepository storeSystemRepository;

    public List<Item> getItems() {

        try {
            return storeSystemRepository.findAll();
        } catch (Exception e) {
            //logger.error("Error occurred: ", e);
            throw new RuntimeException("A specific error occurred", e);
        }
    }

    public Item saveItem(Item item) {
        try {
            item.setCreatedAt(new Date());
            item.setUpdatedAt(new Date());
            return storeSystemRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Error saving item", e);
        }
    }

    public Item updateItem(String id, Item updatedItem) {
        try {
            Optional<Item> existingItemOptional = storeSystemRepository.findById(id);
            if (existingItemOptional.isPresent()) {
                Item existingItem = existingItemOptional.get();
                existingItem.setName(updatedItem.getName());
                existingItem.setDescription(updatedItem.getDescription());
                existingItem.setPrice(updatedItem.getPrice());
                existingItem.setStock(updatedItem.getStock());
                existingItem.setUpdatedAt(new Date());
                return storeSystemRepository.save(existingItem);
            } else {
                throw new RuntimeException("Item not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating item", e);
        }
    }

    public void deleteItem(String id) {
        try {
            storeSystemRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting item", e);
        }
    }
}
