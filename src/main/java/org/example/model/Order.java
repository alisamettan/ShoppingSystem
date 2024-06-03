package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.RandomCodeGenerator;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class Order {
    private LocalDateTime createdDate;
    private String orderCode;
    private List<Product> productList;
    private Invoice invoice;


    public Order(LocalDateTime createdDate, List<Product> productList, Invoice invoice) {
        this.createdDate = createdDate;
        this.orderCode = RandomCodeGenerator.generateRandomCode();
        this.productList = productList;
        this.invoice = invoice;
    }
}