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
import org.hibernate.annotations.Comment;

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

    @Comment("재무제표 보고 주기")
    @Column(name = "reporting_period")
    private Date reportingPeriod;

    @Comment("재무제표 유형")
    @Column(name = "statement_type")
    private StatementType type;

    @Comment("생성일자")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
