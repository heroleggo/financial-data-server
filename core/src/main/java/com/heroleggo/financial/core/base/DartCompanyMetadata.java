package com.heroleggo.financial.core.base;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DartCompanyMetadata {
    private String corporationCode;
    private String corporationName;
    private String stockCode;
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
