package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by mstarosta on 04.01.17.
 */

@Getter
@AllArgsConstructor
@Setter
public class Product {
    private Integer  PK;
    private String name;
    private BigDecimal price;
    public Product(String name,BigDecimal price)
    {
        this.name = name;
        this.price = price;
    }
}
