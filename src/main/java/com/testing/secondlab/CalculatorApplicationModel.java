package com.testing.secondlab;

import com.testing.secondlab.interfaces.Calculator;

public class CalculatorApplicationModel implements Calculator {
    @Override
    public double sum(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException {
        double result = 0.0;
        if (Math.abs(b) < Math.pow(10, -8))
            throw new ArithmeticException("Делить должен быть больше");
        result = a / b;
        return result;
    }
}
