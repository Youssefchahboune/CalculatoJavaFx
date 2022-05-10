package com.example.lab10java;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArithmeticExpression {
    @Test
    public void ArithmeticExpression_CorrectExpression_EvaluateToANumber(){
        ArithmeticExpression expression = new ArithmeticExpression("12+6*2");
        assertEquals(expression.evaluate(), 24);
    }
}
