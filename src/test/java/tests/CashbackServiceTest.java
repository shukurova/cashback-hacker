package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CashbackHackService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashbackServiceTest {

    private CashbackHackService service;

    @BeforeEach
    void setEnv() {
        service = new CashbackHackService();
    }

    @Test
    void negativeAmountTest() {
        int amount = - 100;

        assertThrows(IllegalArgumentException.class, () -> service.remain(amount),
                "Service doesn't throws IllegalArgumentException");
    }

    @Test
    void zeroAmountTest() {
        int amount = 0;

        int actual = service.remain(amount);
        int expected = 1000;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @Test
    void positiveTest() {
        int amount = 900;

        int actual = service.remain(amount);
        int expected = 100;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @Test
    void shouldReturnZeroIfAmount1000() {
        int amount = 1000;

        int actual = service.remain(amount);
        int expected = 0;

        assertEquals(expected, actual, "Service return invalid sum");
    }

    @Test
    void amountMoreThan1000() {
        int amount = 1100;

        int actual = service.remain(amount);
        int expected = 900;

        assertEquals(expected, actual, "Service return invalid sum");
    }
}
