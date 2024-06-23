package com.heroleggo.financial.rest.company.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GetCompanyQuery {
    private Boolean listed;
    private String industry = "all";
    private String name = "";
    private int page = 1;
    private int offset = 16;

    public GetCompanyQuery(Boolean listed, String industry, String name, Integer page, Integer offset) {
        this.listed = listed;
        this.industry = industry == null ? "all" : industry;
        this.name = name == null ? "" : name;
        this.page = page == null ? 1 : page;
        this.offset = offset == null ? 16 : offset;
    }
}
