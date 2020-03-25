package ru.netology.service;

/**
 * Service for cashback calculation.
 */
public class CashbackHackService {

    private final int cashbackBoundary = 1000;

    /**
     * If amount less or more of boundary
     * service need to calculate how much is not enough to cashback.
     *
     * @param amount needed amount
     * @return how much is not enough
     */
    public int remainSumForCashback(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        boolean isNeedMore = amount % cashbackBoundary != 0;
        if (!isNeedMore) {
            return 0;
        }

        return cashbackBoundary - amount % cashbackBoundary;
    }
}
