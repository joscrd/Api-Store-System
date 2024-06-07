package com.storesystem.api.controller;

import com.storesystem.api.collection.Item;
import com.storesystem.api.service.StoreSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreSystemController {

    @Autowired
    private  StoreSystemService storeSystemService;


    @GetMapping("/getItems")
    public ResponseEntity<List<Item>> getItems() {

        try {
            List<Item> itemList = storeSystemService.getItems();
            return new ResponseEntity<>(itemList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveItem")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        try {
            Item savedItem = storeSystemService.saveItem(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody Item item) {
        try {
            Item updatedItem = storeSystemService.updateItem(id, item);
            return ResponseEntity.ok(updatedItem);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        try {
            storeSystemService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
