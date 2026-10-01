package com.mathservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    
    private String operationType;
    private double number1;
    private double number2;
    private double result;

    
    public Operation(String operationType, double number1, double number2) {
        this.operationType = operationType;
        this.number1 = number1;
        this.number2 = number2;
    }
}
