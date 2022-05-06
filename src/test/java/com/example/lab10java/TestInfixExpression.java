package com.example.lab10java;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInfixExpression {

    @Test
    public void InfixExpression_CorrectExpression_EvaluateToANumber(){
        InfixExpression evaluator = new InfixExpression();
        evaluator.addToken(new Operand(3));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(2));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(5));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(6));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(4));
        assertEquals(35, evaluator.evaluate());
    }

    @Test
    public void InfixExpression_CorrectExpression2_EvaluateToANumber(){
        InfixExpression evaluator = new InfixExpression();
        evaluator.addToken(new Operand(1));
        evaluator.addToken(new Subtraction());
        evaluator.addToken(new Operand(4));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(6));
        evaluator.addToken(new Division());
        evaluator.addToken(new Operand(24));
        assertEquals(0, evaluator.evaluate());
    }

    @Test
    public void InfixExpression_CorrectExpression3_EvaluateToANumber(){
        InfixExpression evaluator = new InfixExpression();
        evaluator.addToken(new Operand(1));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(4));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(6));
        evaluator.addToken(new Division());
        evaluator.addToken(new Operand(24));
        evaluator.addToken(new Division());
        evaluator.addToken(new Operand(1));
        assertEquals(1, evaluator.evaluate());
    }
}
