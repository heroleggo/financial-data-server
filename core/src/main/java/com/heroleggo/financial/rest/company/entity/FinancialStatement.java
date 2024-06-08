package com.heroleggo.financial.rest.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "financial_statements")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialStatement {
    @Id
    @Column(name = "statement_id")
    private Long id;

    @Column(name = "reporting_period")
    private Date reportingPeriod;

    @Column(name = "statement_type")
    private StatementType type;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
