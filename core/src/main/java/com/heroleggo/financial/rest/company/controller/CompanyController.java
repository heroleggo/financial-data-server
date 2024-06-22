package com.heroleggo.financial.rest.company.controller;

import com.heroleggo.financial.rest.company.dto.GetCompanyQuery;
import com.heroleggo.financial.rest.company.service.CompanyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getCompanyList(@ModelAttribute GetCompanyQuery query) {
        List<?> queryResult = companyService.getCompanyList();
        System.out.println(query.toString());
        return ResponseEntity.ok(queryResult);
    }

}
