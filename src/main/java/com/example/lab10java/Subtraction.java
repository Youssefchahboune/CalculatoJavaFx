package com.example.lab10java;

public class Subtraction extends Operator{
    @Override
    public Operand evaluate(Operand op1, Operand op2) {

        double r = (op1.getValue() - op2.getValue());

        Operand result = new Operand(r);

        return result;
    }

    @Override
    public int priority() {
        return 1;
    }
}
