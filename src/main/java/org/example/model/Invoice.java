package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.InvoiceNoGenerator;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Invoice {
    private LocalDateTime createdDate;
    private Double totalAmount;
    private String invoiceNo;

    public Invoice(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        this.invoiceNo= InvoiceNoGenerator.generateInvoiceNo();
    }
}
