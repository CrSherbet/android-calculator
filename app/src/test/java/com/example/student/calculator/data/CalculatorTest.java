package com.example.student.calculator.data;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by jittat on 30/3/2560.
 */

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnZeroAfterReset() {
        calculator.reset();
        assertEquals(0, calculator.getResult());
    }

    @Test
    public void shouldReturnValueAfterSet() {
        calculator.reset();
        calculator.setResult(1234);
        assertEquals(1234, calculator.getResult());
    }

    @Test
    public void shouldAddTwoNumbers() {
        calculator.reset();
        calculator.setFirst(1234);
        assertEquals(1334, calculator.operate(calculator.OPERATOR_ADD,100));
    }

    @Test
    public void shouldAddThreeNumbers() {
        calculator.reset();
        calculator.setFirst(1234);
        calculator.setFirst(calculator.operate(calculator.OPERATOR_ADD,100));
        assertEquals(1834, calculator.operate(calculator.OPERATOR_ADD,500));
    }

    @Test
    public void shouldSubtractTwoNumber(){
        calculator.reset();
        calculator.setFirst(1000);
        calculator.operate(calculator.OPERATOR_SUB,99);
        assertEquals(901,calculator.getResult());
    }

    @Test
    public void shouldMultiplyTwoNumber(){
        calculator.reset();
        calculator.setFirst(17);
        calculator.operate(calculator.OPERATOR_MUL,2);
        assertEquals(34,calculator.getResult());
    }

    @Test
    public void shouldDivideTwoNumber(){
        calculator.reset();
        calculator.setFirst(108);
        calculator.operate(calculator.OPERATOR_DIV,9);
        assertEquals(12,calculator.getResult());
    }

    /*@Test
    public void shouldReturnErrorWhenDivideByZero(){
        calculator.reset();
        calculator.setSecond(1);
        calculator.operate(calculator.OPERATOR_DIV,0);
        assertTrue(calculator.isError());
    }*/

   /* @Test
    public void shouldKeepErrorStateUntilReset(){
        calculator.reset();
        assertFalse(calculator.isError());

        calculator.setResult(1);
        calculator.operate(calculator.OPERATOR_DIV,0);
        assertTrue(calculator.isError());

        calculator.operate(calculator.OPERATOR_ADD,10);
        assertTrue(calculator.isError());
    }*/
}
