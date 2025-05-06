package com.example.taxcalculator.api.model;

import java.math.BigDecimal;

public record TaxRequest(BigDecimal income) {
}
