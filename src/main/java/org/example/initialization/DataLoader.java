package org.example.initialization;

import lombok.RequiredArgsConstructor;
import org.example.model.*;
import service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;


public class DataLoader {
    private  CompanyService companyService;
    private  CustomerService customerService;
    private  InvoiceService invoiceService;
    private  OrderService orderService;
    private  ProductService productService;

    public DataLoader(CompanyService companyService, CustomerService customerService, InvoiceService invoiceService, OrderService orderService, ProductService productService) {
        this.companyService = companyService;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.orderService = orderService;
        this.productService = productService;
        loadData();
    }

    public void loadData(){

        //products added
        Product product1=productService.save(new Product("Kitap1", 1550.0, "Kitap"));
        Product product2=productService.save(new Product("Kalem1", 10.0, "Kırtasiye"));
        Product product3=productService.save(new Product("Defter1", 20.0, "Kırtasiye"));
        Product product4=productService.save(new Product("Bilgisayar1", 3000.0, "Teknoloji"));
        Product product5=productService.save(new Product("Telefon1", 2000.0, "Teknoloji"));

        Invoice invoice1=invoiceService.save(new Invoice(LocalDateTime.now()));

        Order order1= orderService.save(new Order(LocalDateTime.now(), Collections.singletonList(product1),invoice1));

        Customer customer=customerService.save(new Customer("Ali Camet Tan",24,"alisamet_tan@hotmail.com","124556", LocalDate.now(), Collections.singletonList(order1)));


    }


}