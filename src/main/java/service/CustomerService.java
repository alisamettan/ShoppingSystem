package service;

import lombok.RequiredArgsConstructor;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.util.PasswordHasher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    //Yeni müşteri oluşturuluyor.
    public Customer save(Customer customer){
        List<Customer> customerList=findAll();
        if(customerList.stream().anyMatch(customer1 -> customer1.getEmail().equalsIgnoreCase(customer.getEmail()))){
            throw new RuntimeException("Customer with given email already exist.");
        }
        String hashedPassword= PasswordHasher.encrypt(customer.getPassword());
        customer.setPassword(hashedPassword);
        return customerRepository.save(customer);
    }


    //Tüm müşteriler listeleniyor.
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }


    //İçerisinde 'C' harfi olan müşteriler listeleniyor.
    public List<Customer> findCustomersIncludeC(){
        List<Customer> customerList= findAll().stream()
                .filter(customer->customer.getFullName().toLowerCase().contains("c")).toList();

        return customerList;
    }

}
