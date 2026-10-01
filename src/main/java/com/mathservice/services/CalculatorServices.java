package com.mathservice.services;

import com.mathservice.models.Operation;

public class CalculatorServices {

    public Operation calculate(Operation operation) {
        switch (operation.getOperationType()) {
            case "sum":
                return addition(operation);
            case "rest":
                return subtract(operation);
            case "mult":
                return multiply(operation);
            case "div":
                return divide(operation);
            default:
                return null;
        }
    }
    
    public Operation addition(Operation operation) {
        operation.setResult(operation.getNumber1() + operation.getNumber2());
        return operation;
    }

    public Operation subtract(Operation operation) {
        operation.setResult(operation.getNumber1() - operation.getNumber2());
        return operation;
    }


    public Operation multiply(Operation operation) {
        operation.setResult(operation.getNumber1() * operation.getNumber2());
        return operation;
    }

    public Operation divide(Operation operation) {

        if (operation.getNumber2() == 0) {
            operation.setResult(0);
        } else {
            operation.setResult(operation.getNumber1() / operation.getNumber2());
        }
        return operation;
    }

}
