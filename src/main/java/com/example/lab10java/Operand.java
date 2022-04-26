package com.example.lab10java;

 public final class  Operand  implements Token{

    private double value;

    public Operand(double v){
        this.value = v;
    }

    @Override
    public boolean isOperand(){
        return true;
    }

    public double getValue() {
        return value;
    }
}
