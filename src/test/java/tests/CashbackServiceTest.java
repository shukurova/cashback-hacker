package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.CashbackHackService;

import static data.DataClass.CASHBACK_BOUNDARY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for cachback service.
 */
public class CashbackServiceTest {

    private CashbackHackService service;

    @BeforeEach
    void setEnv() {
        service = new CashbackHackService();
    }

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
        int amount = CASHBACK_BOUNDARY - 10;

        int actual = service.remainSumForCashback(amount);
        int expected = CASHBACK_BOUNDARY - amount;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @Test
    @DisplayName("Check cashback if amount equal to cashback boundary")
    void shouldReturnZeroIfAmountEqualToBoundary() {
        int actual = service.remainSumForCashback(CASHBACK_BOUNDARY);
        int expected = 0;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @Test
    @DisplayName("Check cashback if amount more than cashback boundary")
    void amountMoreThanBoundary() {
        int additionalAmount = 100;
        int amount = CASHBACK_BOUNDARY + additionalAmount;

        int actual = service.remainSumForCashback(amount);
        int expected = CASHBACK_BOUNDARY - additionalAmount;

        assertEquals(expected, actual, "Service return invalid sum");
    }
}
