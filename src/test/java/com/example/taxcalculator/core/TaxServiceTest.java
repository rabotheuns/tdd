package com.example.taxcalculator.core;

import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.example.taxcalculator.core.model.TaxResult;
import static org.assertj.core.api.Assertions.assertThat;

class TaxServiceTest {

    @Test
    void testCalculate_with_zero_income()  {
        // Arrange
        TaxService taxService = new TaxService();

        // Act
        TaxResult result = taxService.calculateTax(ZERO);

        // Assert
        assertThat(result.annualTaxAmount()).isEqualByComparingTo(ZERO);
    }
  
}