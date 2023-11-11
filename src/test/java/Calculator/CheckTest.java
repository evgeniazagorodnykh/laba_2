package Calculator;

import org.junit.Test;

import static Calculator.Check.checking;
import static org.junit.Assert.*;

public class CheckTest {

    @Test
    public void testWrongBasketsRight() {
        String data = "(2 + 2))";
        assertThrows(Exception.class, () -> checking(data));
    }

    @Test
    public void testWrongBasketsLeft() {
        String data = "((2 + 2)";
        assertThrows(Exception.class, () -> checking(data));
    }

    @Test
    public void testWrongElements() {
        String data = "2 * k";
        assertThrows(Exception.class, () -> checking(data));
    }
}