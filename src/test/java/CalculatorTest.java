import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {

    Calculator calculator = Calculator.instance.get();
    @Test
    public void testPlus() {
        int x = 3, y = 2;
        Assertions.assertEquals(5, calculator.plus.apply(x, y));
    }

    @Test
    public void testMultiply() {
        int x = 4, y = 4;
        Assertions.assertEquals(16, calculator.multiply.apply(x, y));
    }
    
    @ParameterizedTest
    @MethodSource("testSource")
    public void testDivide(int x, int y, int expected) {
        Assertions.assertEquals(expected, calculator.divide.apply(x, y));
    }

    private static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(10, 5, 2),
                Arguments.of(4, 0, 0)
        );
    }
}
