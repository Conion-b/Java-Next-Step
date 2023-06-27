package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("before");
    }

    @Test
    public void add() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void substract() {
        assertEquals(5, calculator.substract(10, 5));
    }

    @AfterEach
    public void teardown() {
        System.out.println("teardown");
    }

}
