package com.example.lab10java;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class InfixExpression {

    private ArrayList<Token> expression = new ArrayList<>();

    public void addToken(Token t){
        expression.add(t);
    }
    public double evaluate(){
        PostfixEvaluator postfix = new PostfixEvaluator();
        ArrayDeque<Operator> operators = new ArrayDeque<>();

        for (int i=0; i < expression.size(); i++){

            if (expression.get(i).isOperand()){
                postfix.addToken(expression.get(i));
            }
            else {
                Operator t = (Operator) expression.get(i);

                if (operators.isEmpty()){
                    operators.push(t);
                }
                else {
                    if (t.priority() >= operators.getFirst().priority()){
                        operators.push(t);
                    }
                    else if (t.priority() <= operators.getFirst().priority()){

                        while ((!(operators.isEmpty())) && (t.priority() <= operators.getFirst().priority())){
                           postfix.addToken(operators.pop());
                        }
                        operators.push(t);
                    }
                }
            }
        }

        //pop all operators from stack and add them to the postfix expression
        while (!(operators.isEmpty())){
            postfix.addToken(operators.pop());
        }

        return postfix.evaluateExpression();

    }
}
