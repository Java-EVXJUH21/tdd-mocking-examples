package me.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class AverageTests {

    @ParameterizedTest
    @MethodSource("normalData")
    void test_normal_values(List<Double> numbers, double answer) {
        var result = Utility.calculateAverage(numbers);

        Assertions.assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("negativeNumbers")
    void test_negative_values(List<Double> numbers, double answer) {
        var result = Utility.calculateAverage(numbers);

        Assertions.assertEquals(answer, result);
    }

    @ParameterizedTest
    @MethodSource("incorrectNumbers")
    void test_incorrect_values(List<Double> numbers, double answer) {
        var result = Utility.calculateAverage(numbers);

        Assertions.assertNotEquals(answer, result);
    }

    @Test
    void test_zero_values() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Utility.calculateAverage(List.of());
        });
    }

    static Stream<Arguments> normalData() {
        return Stream.of(
                Arguments.arguments(List.of(10.0, 10.0, 10.0), 10.0),
                Arguments.arguments(List.of(20.0, 10.0, 10.0), (20.0 + 10.0 + 10.0) / 3.0),
                Arguments.arguments(List.of(10.0, 30.0, 20.0), (10.0 + 30.0 + 20.0) / 3.0),
                Arguments.arguments(List.of(40.0, 50.0, 100.0), (40.0 + 50.0 + 100.0) / 3.0),
                Arguments.arguments(List.of(40.0, 40.0), 40.0),
                Arguments.arguments(List.of(40.0, 50.0, 100.0, 60.0, 50.0), (40.0 + 50.0 + 100.0 + 60.0 + 50.0) / 5.0),
                Arguments.arguments(List.of(40.0), 40.0)
        );
    }

    static Stream<Arguments> negativeNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(-10.0, -10.0, -10.0), -10.0),
                Arguments.arguments(List.of(-20.0, 10.0, -10.0), (-20.0 + 10.0 + -10.0) / 3.0),
                Arguments.arguments(List.of(-10.0, -30.0, -20.0), (-10.0 + -30.0 + -20.0) / 3.0),
                Arguments.arguments(List.of(-40.0, -50.0, -100.0), (-40.0 + -50.0 + -100.0) / 3.0),
                Arguments.arguments(List.of(-40.0, 40.0), 0.0),
                Arguments.arguments(List.of(-40.0, -50.0, -100.0, -60.0, -50.0), (-40.0 + -50.0 + -100.0 + -60.0 + -50.0) / 5.0),
                Arguments.arguments(List.of(-40.0), -40.0)
        );
    }

    static Stream<Arguments> incorrectNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(10.0, 10.0, 1.0), 890.0),
                Arguments.arguments(List.of(100.0, 10.0, 10.0), 45.0),
                Arguments.arguments(List.of(10.0, 70.0, 990.0), 90.3),
                Arguments.arguments(List.of(60.0, 650.0, 10.0), 120.3),
                Arguments.arguments(List.of(17.0, 10.0, 10.0), 7897.0),
                Arguments.arguments(List.of(10.0, 10.0, 89700.0), 4980.3),
                Arguments.arguments(List.of(1789.0, 897.0, 10.0), 32.2)
        );
    }
}
