package org.example.repository;

import org.example.model.Company;

import java.util.List;

public interface ICompanyRepository {
    Company save(Company company);
    List<Company> findAll();
}
