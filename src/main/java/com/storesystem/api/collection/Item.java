package com.storesystem.api.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Builder
@Document(collection = "product")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Item {

    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Date createdAt;
    private Date updatedAt;

}
