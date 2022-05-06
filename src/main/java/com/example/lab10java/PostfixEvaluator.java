package com.example.lab10java;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class PostfixEvaluator {

    private ArrayList<Token> expression = new ArrayList<>();

    public void addToken(Token t)
    {
        expression.add(t);
    }

    public double evaluateExpression(){
        ArrayDeque<Operand> stackThatHoldOperand = new ArrayDeque<>();

        for (int i = 0; i < expression.size(); i++){
            if (expression.get(i).isOperand()){
                stackThatHoldOperand.push((Operand) expression.get(i));
            }
            else {
                if (stackThatHoldOperand.size() < 2){
                    throw new ArithmeticException("Your expression is incomplete");
                }
                Operand op1 = stackThatHoldOperand.pop();
                Operand op2 = stackThatHoldOperand.pop();
                Operator operator = (Operator) expression.get(i);

                Operand result = operator.evaluate(op2,op1);

                stackThatHoldOperand.push(result);

            }
        }
        if (stackThatHoldOperand.isEmpty()){
            throw new ArithmeticException("Your expression could not be evaluated due to empty expression");
        }
        else if (stackThatHoldOperand.size() > 1){
            throw new ArithmeticException("Something went wrong while trying to output the result of your expression");
        }
        else{

            return stackThatHoldOperand.getLast().getValue();
        }

    }




}
