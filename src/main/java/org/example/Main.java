package org.example;

import org.example.initialization.DataLoader;
import org.example.repository.*;
import service.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CompanyService companyService=new CompanyService(new CompanyRepository());
        CustomerService customerService=new CustomerService(new CustomerRepository());
        OrderService orderService=new OrderService(new OrderRepository());
        InvoiceService invoiceService=new InvoiceService(new InvoiceRepository(),orderService,customerService);
        ProductService productService=new ProductService(new ProductRepository());

        DataLoader loader=new DataLoader(companyService,customerService,invoiceService,orderService,productService);


        System.out.println(productService.findAll());
        System.out.println(customerService.findCustomersIncludeC());
        System.out.println(invoiceService.calculateAverageAbove1500());
    }
}