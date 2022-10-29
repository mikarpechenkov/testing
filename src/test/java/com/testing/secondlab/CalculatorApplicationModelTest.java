package com.testing.secondlab;

import com.testing.secondlab.CalculatorApplicationModel;
import com.testing.secondlab.interfaces.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorApplicationModelTest {
    static Calculator model;

    @BeforeAll
    public static void setUp() {
        model=new CalculatorApplicationModel();
    }

    @Test
    void sum() {
        try{
            assertEquals(5, model.sum(2,3));
            assertEquals(Double.POSITIVE_INFINITY,model.sum(Double.MAX_VALUE,Double.MAX_VALUE));
            assertEquals(Double.MIN_VALUE,model.sum(Double.MIN_VALUE,0.0));
            assertEquals(2*Double.MIN_VALUE,model.sum(Double.MIN_VALUE,Double.MIN_VALUE));
            assertEquals(Double.NEGATIVE_INFINITY,model.sum(-Double.MAX_VALUE,-Double.MAX_VALUE));
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void subtract() {
        try{
            assertEquals(5,model.subtract(10,5));
            assertEquals(-Double.MAX_VALUE,model.subtract(0,Double.MAX_VALUE));
            assertEquals(Double.NEGATIVE_INFINITY,model.subtract(-Double.MAX_VALUE,Double.MAX_VALUE));
            assertEquals(Double.POSITIVE_INFINITY,model.subtract(Double.MAX_VALUE,-Double.MAX_VALUE));
            assertEquals(Double.MIN_VALUE,model.subtract(Double.MIN_VALUE,0.0));
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void multiply() {
        try{
            assertEquals(5,model.multiply(2.5,2));
            assertEquals(0, model.multiply(Double.MAX_VALUE,0.0));
            assertEquals(Double.POSITIVE_INFINITY,model.multiply(Double.MAX_VALUE,Double.MAX_VALUE));
            assertEquals(Double.NEGATIVE_INFINITY,model.multiply(Double.MAX_VALUE,-Double.MAX_VALUE));
            assertEquals(Double.POSITIVE_INFINITY,model.multiply(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY));
            assertEquals(0.0,model.multiply(Double.MIN_VALUE,Double.MIN_VALUE));
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void divide() {
        try{
            assertEquals(5,model.divide(15,3));
            assertEquals(Double.NaN,model.divide(0.0,0.0));
            assertEquals(0.0,model.divide(Double.MIN_VALUE,Double.MIN_VALUE));
            assertEquals(Double.MIN_VALUE,model.divide(1.0,Double.MAX_VALUE));
            assertEquals(Double.POSITIVE_INFINITY,model.divide(Double.MAX_VALUE,Math.pow(Double.MIN_VALUE,-1)));
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }
}