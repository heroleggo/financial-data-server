package com.heroleggo.financial.rest.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Company {
    @Id
    @Column(name = "company_id")
    private Long id;

    @Comment("기업명")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("기업 상장여부")
    @Column(name = "is_public", nullable = false)
    private boolean isPublic;

    @Comment("기업 산업군")
    @Column(name = "industry")
    private String industry;
}
