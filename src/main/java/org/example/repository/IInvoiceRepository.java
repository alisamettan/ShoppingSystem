package org.example.repository;

import org.example.model.Invoice;

import java.util.List;

public interface IInvoiceRepository{
    Invoice save(Invoice invoice);
    List<Invoice> findAll();
}