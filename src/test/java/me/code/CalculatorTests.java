package me.code;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CalculatorTests {

    @BeforeEach
    void setup() {
        System.out.println("BEFORE");
    }

    @AfterEach
    void cleanup() {
        System.out.println("AFTER");
    }

    @ParameterizedTest
    @MethodSource("testData")
    void test_add(int a, int b, int answer) {

        var result = Calculator.add(a, b);

        Assertions.assertEquals(answer, result);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments(2, 3, 5),
                Arguments.arguments(1, 4, 5),
                Arguments.arguments(2, 5, 7),
                Arguments.arguments(3, 6, 9),
                Arguments.arguments(4, 7, 11),
                Arguments.arguments(5, 8, 13),
                Arguments.arguments(6, 9, 15)
        );
    }

    @Test
    void test_add_zero_is_zero() {
        System.out.println("TEST: test_add_zero_is_zero");
        var result = Calculator.add(0, 0);

        Assertions.assertEquals(0, result);
    }

}
