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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data = ");
        sb.append("Code : ");
        sb.append(corporationCode);
        sb.append(", Name : ");
        sb.append(corporationName);
        sb.append(", StockCode : ");
        sb.append(stockCode == null ? "NOT REGISTERED" : stockCode);
        sb.append(", ModifiedAt : ");
        sb.append(modifiedAt.toString());

        return sb.toString();
    }
}
