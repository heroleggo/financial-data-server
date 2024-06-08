package com.heroleggo.financial.rest.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "financial_statement_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialStatementItem {
    @Id
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_value")
    private Long value;

    @ManyToOne
    @JoinColumn(name = "statement_id")
    private FinancialStatement statement;
}
