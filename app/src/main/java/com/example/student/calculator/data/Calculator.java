package com.example.student.calculator.data;

import android.os.DeadSystemException;

/**
 * Created by jittat on 30/3/2560.
 */

public class Calculator {
    private int first;
    private int second;
    private int result;
    private int operator;
    private boolean firstTime;
    private boolean errorOccured;

    public static final int OPERATOR_ADD = 1;
    public static final int OPERATOR_SUB = 2;
    public static final int OPERATOR_MUL = 3;
    public static final int OPERATOR_DIV = 4;


    public Calculator() {
        reset();
    }

    public void reset() {
        result = 0;
        first = 0;
        second = 0;
        operator = 0;
        firstTime = true;
        errorOccured = false;
    }

    public int setResult(int r) {
        result = r;
        return result;
    }
    public boolean isFirstTime(){
        return firstTime ;
    }

    public void setFirstTime(boolean b){
        this.firstTime = b;
    }

    public int operate(int op, int a) {
       /* if(errorOccured){
            return 0;
        }*/
        switch(op) {
            case OPERATOR_ADD:
                result = first + a;
                break;
            case OPERATOR_SUB:
                result = first - a;
                break;
            case OPERATOR_MUL:
                result = first * a;
                break;
            case OPERATOR_DIV:
                if(a!=0)
                    result = first / a;
                else {
                    errorOccured = true;
                    return 0;
                }
                break;
        }
        return result;
    }
    public void setFirst(int value){
        this.first = value;
    }
    public void setOperator(int op){
        this.operator = op;
    }
    public int getOperator(){
        return operator;
    }
    public boolean isError() {
        return false;
    }

    public int getResult() {
        return result;
    }

    public int getSecond() { return second; }

    public void setSecond(int second){ this.second = second; }

    public int getFirst() { return first; }
}
