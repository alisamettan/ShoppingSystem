package service;

import lombok.RequiredArgsConstructor;
import org.example.model.Company;
import org.example.model.Invoice;
import org.example.model.Order;
import org.example.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company save(Company company){
        return companyRepository.save(company);
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }


    //Haziran ayını faturalarını ortalaması 750 altı olan firmalarının hangi sektörde olduğunu listeliyor.
    public List<String> findCompanyNamesBelow750(){
        List<Company> companies =findAll();
        List<String> companyNames = new ArrayList<>();

        for (Company company : companies) {
            double totalAmount = 0;
            int invoiceCount = 0;

            for (Order order : company.getOrderList()) {
                Invoice invoice = order.getInvoice();
                if (invoice != null && invoice.getCreatedDate().getMonth() == Month.JUNE) {
                    totalAmount += invoice.getTotalAmount();
                    invoiceCount++;
                }
            }

            double averageAmount = invoiceCount > 0 ? totalAmount / invoiceCount : 0;
            if (averageAmount < 750.0) {
                companyNames.add(company.getName());
            }
        }

        return companyNames;
    }
}
