package service;

import lombok.RequiredArgsConstructor;
import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final OrderService orderService;
    private final CustomerService customerService;


    public Invoice save(Invoice invoice){
        List<Order> orders = orderService.findAll();
        double totalAmount = 0.0;

        for (Order order : orders) {
            if (order.getInvoice() != null && order.getInvoice().getInvoiceNo().equals(invoice.getInvoiceNo())) {
                totalAmount += orderService.calculateOrderTotal(order.getOrderCode());
            }
        }

        invoice.setTotalAmount(totalAmount);
        return invoiceRepository.save(invoice);
    }

    //Sistemdeki tüm faturalar listeleniyor.
    public List<Invoice> findAll(){
        return invoiceRepository.findAll();
    }


    //Sistemdeki 1500Tl üstündeki faturaları listeliyor.
    public List<Invoice> findInvoicesAbove1500(){
        return invoiceRepository.findAll().stream()
                .filter(invoice -> invoice.getTotalAmount()>1500.0)
                .collect(Collectors.toList());
    }


    //1500 Tl üstündeki faturaların ortalaması hesaplanıyor.
    public double calculateAverageAbove1500() {
        List<Invoice> above1500Invoices = findInvoicesAbove1500();
        double totalAmount = above1500Invoices.stream()
                .mapToDouble(Invoice::getTotalAmount)
                .sum();
        return totalAmount / above1500Invoices.size();
    }

    //Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı.
    public double calculateTotalAmountJanuary(){
        List<Customer> customerList=customerService.findAll().stream()
                .filter(customer -> customer.getRegistrationDate().getMonth()== Month.JUNE)
                .collect(Collectors.toList());

        double totalAmount = customerList.stream()
                .flatMap(customer -> customer.getOrderList().stream())
                .flatMap(order -> order.getProductList().stream())
                .mapToDouble(Product::getPrice)
                .sum();

        return totalAmount;

    }


    //Sistemdeki 500 Tl altındaki faturalara sahip müşterilerin isimleri listeleniyor.
    public List<String> findNamesByInvoicesBelow500(){
       List<Invoice> invoices = invoiceRepository.findAll().stream()
                .filter(invoice -> invoice.getTotalAmount()<500.0)
                .collect(Collectors.toList());

        List<String> customerNames = customerService.findAll().stream()
                .filter(customer -> customer.getOrderList().stream()
                        .map(Order::getInvoice)
                        .anyMatch(invoice -> invoice != null && invoice.getTotalAmount() < 500.0))
                .map(Customer::getFullName)
                .toList();

        return customerNames;
    }

}













