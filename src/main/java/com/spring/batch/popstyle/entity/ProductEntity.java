package com.spring.batch.popstyle.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(value = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {
    private String id;
    private String productName;
    private String productDescription;
    private Double unitPrice;

}
