package ru.netology.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for cashback service.
 */
public class CashbackServiceTest {

    private CashbackHackService service = new CashbackHackService();

    @Test
    @DisplayName("Check cashback if amount is negative")
    void negativeAmountTest() {
        int amount = - 100;

        assertThrows(IllegalArgumentException.class, () -> service.remainSumForCashback(amount));
    }

    @Test
    @DisplayName("Check cashback if amount is equal zero")
    void zeroAmountTest() {
        int amount = 0;

        assertThrows(IllegalArgumentException.class, () -> service.remainSumForCashback(amount));
    }

    @Test
    @DisplayName("Check cashback with less than cashback boundary")
    void positiveTest() {
        int amount = 990;

        int actualResult = service.remainSumForCashback(amount);
        int expectedResult = 10;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Check cashback if amount equal to cashback boundary")
    void shouldReturnZeroIfAmountEqualToBoundary() {
        int amount = 1000;

        int actualResult = service.remainSumForCashback(amount);
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Check cashback if amount more than cashback boundary")
    void amountMoreThanBoundary() {
        int amount = 1100;

        int actualResult = service.remainSumForCashback(amount);
        int expectedResult = 900;

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Parameterized positive tests")
    @CsvFileSource(resources = "/cashback-service-data.csv", delimiter = ',', numLinesToSkip = 1)
    void parameterizedTest(String testName, int amount, int expectedResult) {
        int actualResult = service.remainSumForCashback(amount);

        assertEquals(expectedResult, actualResult);
    }
}
