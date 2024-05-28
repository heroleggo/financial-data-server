package com.heroleggo.financial.core.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity(name = "DART_COMPANY_METADATA")
@Table
@NoArgsConstructor
@AllArgsConstructor
public class DartCompanyMetadata {
    @Id
    @Column(name = "DART_COMPANY_METADATA_ID")
    private Long id;

    @Column(name = "CORPORATION_CODE", nullable = false)
    private String corporationCode;

    @Column(name = "CORPORATION_NAME", nullable = false)
    private String corporationName;

    @Column(name = "STOCK_CODE", nullable = true)
    private String stockCode;

    @Column(name = "MODIFIED_AT")
    private Date modifiedAt;

    public static DartCompanyMetadata of(String corporationCode, String corporationName, String stockCode, Date modifiedAt) {
        return DartCompanyMetadata.builder()
            .corporationCode(corporationCode)
            .corporationName(corporationName)
            .stockCode(stockCode)
            .modifiedAt(modifiedAt)
            .build();
    }
}
