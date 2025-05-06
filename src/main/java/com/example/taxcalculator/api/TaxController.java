package com.example.taxcalculator.api;

import com.example.taxcalculator.core.model.TaxResult;
import com.example.taxcalculator.api.model.TaxResultDto;
import com.example.taxcalculator.api.mapper.TaxResultMapper;
import com.example.taxcalculator.core.TaxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/tax")
public class TaxController {

    private final TaxService taxService;
    private final TaxResultMapper taxResultMapper;

    public TaxController(TaxResultMapper taxResultMapper, TaxService taxService) {
        this.taxResultMapper = taxResultMapper;
        this.taxService = taxService;
    }

    @GetMapping("/calculate")
    public TaxResultDto calculateTax(@RequestParam BigDecimal income) {
        TaxResult taxResult = taxService.calculateTax(income);
        return taxResultMapper.toDto(taxResult);
    }
}
