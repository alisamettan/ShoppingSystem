package org.example.repository;

import org.example.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository implements IInvoiceRepository{
    private List<Invoice> invoices=new ArrayList<>();
    @Override
    public Invoice save(Invoice invoice) {
         invoices.add(invoice);
         return invoice;
    }

    @Override
    public List<Invoice> findAll() {
        return invoices;
    }
}