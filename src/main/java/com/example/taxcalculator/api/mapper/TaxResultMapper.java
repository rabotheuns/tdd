package com.example.taxcalculator.api.mapper;

import com.example.taxcalculator.core.model.TaxResult;
import com.example.taxcalculator.api.model.TaxResultDto;
import org.springframework.stereotype.Component;

@Component
public class TaxResultMapper {

    public TaxResultDto toDto(TaxResult taxResult) {
        return new TaxResultDto(taxResult.annualTaxAmount());
    }
}
