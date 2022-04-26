package com.example.lab10java;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPostfixEvaluator {
    @Test
    public void PostfixEvaluator_CorrectExpression_EvaluateToANumber(){
        PostfixEvaluator evaluator = new PostfixEvaluator();
        evaluator.addToken(new Operand(3));
        evaluator.addToken(new Operand(2));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Operand(5));
        evaluator.addToken(new Addition());
        evaluator.addToken(new Operand(6));
        evaluator.addToken(new Operand(4));
        evaluator.addToken(new Multiplication());
        evaluator.addToken(new Addition());
        assertEquals(evaluator.evaluateExpression(), 35);
    }

    @Test
    public void
    PostfixEvaluator_ExpressionWithOneOperandOnlyAndOneOperator_ThrowsArithmeticException1()
    {
        Exception exception = assertThrows(ArithmeticException.class, ()->{
            PostfixEvaluator evaluator = new PostfixEvaluator();
            evaluator.addToken(new Operand(3));
            evaluator.addToken(new Multiplication());
            evaluator.evaluateExpression();
        });
        String expectedMessage = "Your expression is incomplete";
        String actualMessage = exception.getMessage();
        //asserting the exception message if it contains
        //our expected message
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void
    PostfixEvaluator_ExpressionWithOneOperandOnlyAndOneOperator_ThrowsArithmeticException2()
    {
        Exception exception = assertThrows(ArithmeticException.class, ()->{
            PostfixEvaluator evaluator = new PostfixEvaluator();
            evaluator.addToken(new Operand(3));
            evaluator.addToken(new Operand(5));
            evaluator.addToken(new Operand(8));
            evaluator.addToken(new Multiplication());

            evaluator.evaluateExpression();
        });
        String expectedMessage = "Something went wrong while trying to output the result of your expression";
        String actualMessage = exception.getMessage();
        //asserting the exception message if it contains
        //our expected message
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void PostfixEvaluator_TestOurTeacherAskedUsToWrite_WeDontKnowYet(){
        Exception exception = assertThrows(ArithmeticException.class, ()-> {
            PostfixEvaluator evaluator = new PostfixEvaluator();
            evaluator.evaluateExpression();
        });

        String expectedMessage = "Your expression could not be evaluated due to empty expression";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }



}
