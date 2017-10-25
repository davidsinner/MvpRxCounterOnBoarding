package com.globant.counter.android.mvp.model;

/**
 * Created by david.casas on 10/25/2017.
 */

public class CalculatorModel {

    public int calculateResult(int firstValue, int secondValue, String operator){

        int result = 0;
        switch (operator) {

            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    result = 0;
                }
                break;
            default:
                break;

        }

        return  result;
    }


}
