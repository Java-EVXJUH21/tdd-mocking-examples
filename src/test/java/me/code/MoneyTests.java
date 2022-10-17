package me.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MoneyTests {

    @ParameterizedTest
    @MethodSource("inputData")
    void test_equals(int years, double startSum, double percentage, int answer) {
        var result = Utility.calculateMoney(years, startSum, percentage);

        Assertions.assertEquals(answer, Math.round(result));
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.arguments(5, 1000.0, 1.2, 2488),
                Arguments.arguments(2, 5000.0, 2.0, 20000),
                Arguments.arguments(10, 500.0, 1.3, 6893),
                Arguments.arguments(20, 10000.0, 1.5, 33252567)
        );
    }

    @ParameterizedTest
    @MethodSource("unusualData")
    void test_unusual_equals(int years, double startSum, double percentage, int answer) {
        var result = Utility.calculateMoney(years, startSum, percentage);

        Assertions.assertEquals(answer, Math.round(result));
    }

    static Stream<Arguments> unusualData() {
        return Stream.of(
                Arguments.arguments(0, 1000.0, 1.2, 1000),
                Arguments.arguments(2, 0, 2.0, 0),
                Arguments.arguments(10, 500.0, 0.0, 0),
                Arguments.arguments(0, 0.0, 0.0, 0)
        );
    }

}
