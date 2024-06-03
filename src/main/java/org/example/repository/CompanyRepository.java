package org.example.repository;

import org.example.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository implements ICompanyRepository {

    private List<Company> companies;
    @Override
    public Company save(Company company) {
        companies.add(company);
        return company;
    }

    @Override
    public List<Company> findAll() {
        return companies;
    }
}
