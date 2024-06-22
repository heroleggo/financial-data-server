package com.heroleggo.financial.rest.company.repository;

import com.heroleggo.financial.rest.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
