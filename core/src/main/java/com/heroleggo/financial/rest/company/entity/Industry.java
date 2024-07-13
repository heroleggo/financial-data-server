package com.heroleggo.financial.rest.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "industries")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Industry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "industry_id")
    private Long id;

    @Comment("섹터명")
    @Column(name = "sector")
    private String sector;

    @Comment("산업 그룹")
    @Column(name = "industry_group")
    private String industryGroup;

    @Comment("산업 분류")
    @Column(name = "industry")
    private String industry;

    @Comment("세부 산업 분류")
    @Column(name = "sub_industry")
    private String subIndustry;
}
