package test;

import main.Main;
import org.junit.Before;
import org.junit.Test;
/*import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;*/

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculator_Test {
    private Main.StringCalculator cal;

    @Before
    public void setup() {
        cal = new Main.StringCalculator();
        System.out.println("Before");
    }
    @Test
    public void add_empty() {
        assertEquals(0,cal.add(null));
        assertEquals(0,cal.add(""));
    }
    @Test
    public void add_string() {
        assertEquals(3, cal.add("3"));
    }
    @Test
    public void add_seperate() {
        assertEquals(8,cal.add("6,2"));
        assertEquals(9,cal.add("3,2:4"));
    }
    @Test
    public void add_regx() {
        assertEquals(8, cal.add("//;\n3;4;1"));
    }
    @Test(expected = RuntimeException.class)
    public void add_minus() {
        cal.add("-1,2,3");
    }
}