package com.storesystem.api.repository;

import com.storesystem.api.collection.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreSystemRepository extends MongoRepository <Item, String> {

}