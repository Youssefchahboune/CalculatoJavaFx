package com.example.lab10java;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void AdditionEvaluate_TwoPositiveOperands_AddTheNumbers(){

        Operand op1 = new Operand(3);
        Operand op2 = new Operand(2);
        Addition add = new Addition();
        Operand result = add.evaluate(op1,op2);

        assertEquals(result.getValue(),5);

    }

    @Test
    public void SubtractionEvaluate_TwoPositiveOperands_subtractTheNumbers(){

        Operand op1 = new Operand(3);
        Operand op2 = new Operand(2);
        Subtraction sub = new Subtraction();
        Operand result = sub.evaluate(op1,op2);

        assertEquals(result.getValue(),1);

    }

    @Test
    public void MultiplicationEvaluate_TwoPositiveOperands_MultiplyTheNumbers(){

        Operand op1 = new Operand(5);
        Operand op2 = new Operand(20);
        Multiplication mul = new Multiplication();
        Operand result = mul.evaluate(op1,op2);

        assertEquals(result.getValue(),100);

    }

    @Test
    public void DivisionEvaluate_TwoPositiveOperands_divideTheNumbers(){

        Operand op1 = new Operand(10);
        Operand op2 = new Operand(2);
        Division div = new Division();
        Operand result = div.evaluate(op1,op2);

        assertEquals(result.getValue(),5);

    }

}

