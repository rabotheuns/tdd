package com.example.taxcalculator.api;

import com.example.taxcalculator.api.mapper.TaxResultMapper;
import com.example.taxcalculator.api.model.TaxRequest;
import com.example.taxcalculator.api.model.TaxResultDto;
import com.example.taxcalculator.core.TaxService;
import com.example.taxcalculator.core.model.TaxResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tax")
public class TaxController {

    private final TaxService taxService;
    private final TaxResultMapper taxResultMapper;

    public TaxController(TaxResultMapper taxResultMapper, TaxService taxService) {
        this.taxResultMapper = taxResultMapper;
        this.taxService = taxService;
    }

    @PostMapping("/calculate")
    public TaxResultDto calculateTax(@RequestBody TaxRequest taxRequest) {
        TaxResult taxResult = taxService.calculateTax(taxRequest.income());
        return taxResultMapper.toDto(taxResult);
    }
}
