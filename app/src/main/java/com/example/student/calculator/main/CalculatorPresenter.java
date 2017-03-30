package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    public static final int OPERATOR_ADD = Calculator.OPERATOR_ADD;
    public static final int OPERATOR_SUB = Calculator.OPERATOR_SUB;
    public static final int OPERATOR_MUL = Calculator.OPERATOR_MUL;
    public static final int OPERATOR_DIV = Calculator.OPERATOR_DIV;
    public static final int OPERATOR_EQ = 5;

    public CalculatorPresenter(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void reset() {
        calculator.reset();
        view.setCalculatorResult(0);
    }

    public void onNumberClick(int num) {
        int number = calculator.getSecond() *10;
        number += num;
        calculator.setSecond(number);
        view.setCalculatorResult(number);
    }

    public void updateCalculator(){
        int result = calculator.operate(calculator.getOperator(), calculator.getSecond());
        calculator.setFirst(result);
        calculator.setSecond(0);
    }

    public void onOpClick(int op) {
        if(op != OPERATOR_EQ) {
            view.setBlank();
            if(calculator.isFirstTime()) {
                calculator.setFirstTime(false);
                calculator.setFirst(calculator.getSecond());
                calculator.setOperator(op);
                if(op == OPERATOR_DIV ||op == OPERATOR_MUL)
                    calculator.setSecond(1);
                else
                    calculator.setSecond(0);
            }
            updateCalculator();
            calculator.setOperator(op);
        }
        else {
            updateCalculator();
            calculator.setSecond(calculator.getFirst());
            calculator.setFirstTime(true);
            view.setCalculatorResult(calculator.getFirst());
        }
    }

    public void onResetClick() {
       reset();
    }

    public void onBackClick() {
        int number = calculator.getSecond()/10;
        calculator.setSecond( number );
        view.setCalculatorResult( number );

    }
}
