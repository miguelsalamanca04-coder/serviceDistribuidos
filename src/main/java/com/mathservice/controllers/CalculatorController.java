package com.mathservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mathservice.models.Operation;
import com.mathservice.services.CalculatorServices;

@RestController
@RequestMapping("/math")
public class CalculatorController {

    private CalculatorServices calculatorServices;
    public CalculatorController() {
        this.calculatorServices = new CalculatorServices();
    }
    
    @GetMapping("/calculate")
    public Operation calculate(@RequestParam String type, @RequestParam double a , @RequestParam double b) {

        Operation operation = new Operation(type, a, b);
        return calculatorServices.calculate(operation);
    }

}
