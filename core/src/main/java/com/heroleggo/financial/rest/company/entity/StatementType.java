package com.heroleggo.financial.rest.company.entity;

import lombok.Getter;

@Getter
public enum StatementType {
    BALANCE_SHEET("BALANCE_SHEET"),
    INCOME_STATEMENT("INCOME_STATEMENT"),
    CASH_FLOW_STATEMENT("CASH_FLOW_STATEMENT"),
    EQUITY_STATEMENT("EQUITY_STATEMENT");

    private final String value;

    StatementType(String value) {
        this.value = value;
    }
}
