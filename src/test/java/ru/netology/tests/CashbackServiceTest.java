package ru.netology.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for cachback service.
 */
public class CashbackServiceTest {

    private CashbackHackService service = new CashbackHackService();

    @Test
    @DisplayName("Check cashback if amount is negative")
    void negativeAmountTest() {
        int amount = - 100;

        assertThrows(IllegalArgumentException.class, () -> service.remainSumForCashback(amount),
                "Service doesn't throws IllegalArgumentException");
    }

    @Test
    @DisplayName("Check cashback if amount is equal zero")
    void zeroAmountTest() {
        int amount = 0;

        assertThrows(IllegalArgumentException.class, () -> service.remainSumForCashback(amount),
                "Service doesn't throws IllegalArgumentException");
    }

    @Test
    @DisplayName("Check cashback with less than cashback boundary")
    void positiveTest() {
        int amount = 990;

        int actual = service.remainSumForCashback(amount);
        int expectedResult = 10;

        assertEquals(expectedResult, actual, "Service return invalid sum");
    }

    @Test
    @DisplayName("Check cashback if amount equal to cashback boundary")
    void shouldReturnZeroIfAmountEqualToBoundary() {
        int amount = 1000;

        int actual = service.remainSumForCashback(amount);
        int expected = 0;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @Test
    @DisplayName("Check cashback if amount more than cashback boundary")
    void amountMoreThanBoundary() {
        int amount = 1100;

        int actual = service.remainSumForCashback(amount);
        int expected = 900;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Parameterized positive tests")
    @CsvFileSource(resources = "/test-data.csv", delimiter = ',', numLinesToSkip = 1)
    void parameterizedTest(String testName, int amount, int expected) {
        int actual = service.remainSumForCashback(amount);

        assertEquals(expected, actual, "Service return invalid sum");
    }
}
