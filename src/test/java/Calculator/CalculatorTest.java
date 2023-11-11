package Calculator;

import org.junit.Test;

import static Calculator.Check.checking;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testExpression() {
        String data = "(2 + 2) * 10 *(5 + 7 - 2)/ 4";
        Calculator temp = new Calculator(checking(data));
        assertEquals(100, temp.expression());
    }

    @Test
    public void testWrongExpressionFirst() {
        String data = "2 ++ 2";
        Calculator temp = new Calculator(checking(data));
        assertThrows(Exception.class, temp::expression);
    }

    @Test
    public void testWrongExpressionSecond() {
        String data = "* 2";
        Calculator temp = new Calculator(checking(data));
        assertThrows(Exception.class, temp::expression);
    }
}