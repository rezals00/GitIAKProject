package com.example.rezab.iakproject.presenter;


import com.example.rezab.iakproject.CalculatorActivity;
import com.example.rezab.iakproject.interactor.CalcInterface;
import com.example.rezab.iakproject.interactor.CalculatorInterface;


public class CalculatorPresenter implements CalculatorInterface {
    private Integer ValOne = 0;
    private Integer ValTwo = 0;
    private String Action = "";
    private Integer result = 0;
    private Integer TempNumber = 0;
    private CalcInterface calcInterface;

    public CalculatorPresenter(CalculatorActivity calculatorActivity) {
        this.calcInterface = calculatorActivity;
    }

    @Override
    public Integer set(Integer data) {
        if(Action.isEmpty()){
                ValOne = Integer.parseInt(ValOne+""+data);
                TempNumber = ValOne;
        } else {
                ValTwo = Integer.parseInt(ValTwo+""+data);
               TempNumber = ValTwo;
        }
        return TempNumber;
    }

    @Override
    public void act(String action) {
        if(!ValOne.toString().isEmpty()){
            if(!ValTwo.toString().isEmpty()) {
                if(!Action.equals(action)){
                    Action = action;
                } else {
                    hitung();
                }
            } else {
                Action = action;
            }
        } else  {
            ValOne = TempNumber;
            TempNumber = 0;
        }
    }

    @Override
    public void hitung() {
        String tempact = Action;
        switch (Action) {
            case "*":
                result = ValOne * ValTwo;
                break;
            case "+":
                result = ValOne + ValTwo;
                break;
            case "-":
               result = ValOne - ValTwo;
                break;
            case "/":
                result = ValOne / ValTwo;
                break;
        }
        ValOne = result;
        calcInterface.setTextEdt(result.toString() + "");
        //calcInterface.setTextEdt(ValOne + "|" + Action + "|" +ValTwo);
        c();
        ValOne = result;
        Action = tempact;
    }

    @Override
    public void c() {
        Action = "";
        ValOne = 0;
        ValTwo = 0;
    }

    @Override
    public String back() {
        String txt =  TempNumber.toString().length() > 1  ? TempNumber.toString().substring(0,TempNumber.toString().length() - 1) : "0";
        TempNumber = Integer.parseInt(txt);
        return txt;
    }

    @Override
    public Integer getOne(Integer data) {
        return (ValTwo.equals(0) ? ValOne: ValOne+data);
    }

}
