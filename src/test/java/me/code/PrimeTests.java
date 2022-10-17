package me.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PrimeTests {

    @ParameterizedTest
    @MethodSource("primeNumbers")
    void test_is_prime(int num) {
        var result = Utility.isPrime(num);

        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("nonPrimeNumbers")
    void test_is_not_prime(int num) {
        var result = Utility.isPrime(num);

        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("bigPrimeNumbers")
    void test_big_is_prime(int num) {
        var result = Utility.isPrime(num);

        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("bigNonPrimeNumbers")
    void test_big_is_not_prime(int num) {
        var result = Utility.isPrime(num);

        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("negativeNumbers")
    void test_negative_is_not_prime(int num) {
        var result = Utility.isPrime(num);

        Assertions.assertFalse(result);
    }

    @Test
    void test_zero_is_not_prime() {
        var result = Utility.isPrime(0);
        Assertions.assertFalse(result);
    }

    static Stream<Integer> nonPrimeNumbers() {
        return Stream.of(1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28);
    }

    static Stream<Integer> bigPrimeNumbers() {
        return Stream.of(7727, 7741, 7753, 7757, 7829, 7907);
    }

    static Stream<Integer> bigNonPrimeNumbers() {
        return Stream.of(7728, 7742, 7752, 7756, 7830, 7905);
    }

    static Stream<Integer> primeNumbers() {
        return Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43);
    }

    static Stream<Integer> negativeNumbers() {
        return Stream.of(-1, -2, -3, -10, -45, -478, -234789);
    }
}
