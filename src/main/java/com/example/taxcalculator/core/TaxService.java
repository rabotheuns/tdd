package com.example.taxcalculator.core;

import com.example.taxcalculator.core.model.TaxResult;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TaxService {

    public TaxResult calculateTax(BigDecimal annualIncome) {
        BigDecimal taxRate = new BigDecimal("0.20");
        BigDecimal annualTaxAmount = annualIncome.multiply(taxRate);
        return new TaxResult(annualTaxAmount);
    }
}
