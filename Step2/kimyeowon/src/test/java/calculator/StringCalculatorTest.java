package calculator;

import calculator.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private StringCalculator stCal;

    @BeforeEach
    public void setUp() throws Exception {
        stCal = new StringCalculator();
    }

    @Test
    public void add_null_or_emptyText() throws Exception {
        assertEquals(0, stCal.add(""));
        assertEquals(0, stCal.add(null));
    }

    @Test
    public void add_oneNum() throws Exception {
        assertEquals(1, stCal.add("1"));
    }

    @Test
    public void add_delimiter_comma() throws Exception {
        assertEquals(3, stCal.add("2, 3"));
    }

    @Test
    public void add_delimiter_commaOrColon() throws Exception {
        assertEquals(3, stCal.add("2:3"));
        assertEquals(6, stCal.add("1,2:3"));
    }

    @Test
    public void add_delimiter_customed() throws Exception {
        assertEquals(6, stCal.add("//;\n1;2:3"));
    }

    @Test
    public void add_negative_num() throws Exception {
        stCal.add("-2, 2; 3");
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

}
