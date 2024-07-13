package com.heroleggo.financial.rest.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "financial_statement_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialStatementItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Comment("재무제표 상세 항목명")
    @Column(name = "item_name")
    private String name;

    @Comment("재무제표 상세 항목값")
    @Column(name = "item_value")
    private Long value;

    @ManyToOne
    @JoinColumn(name = "statement_id")
    private FinancialStatement statement;
}
