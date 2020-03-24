package service;

import static data.DataClass.CASHBACK_BOUNDARY;

/**
 * Service for cashback calculation.
 */
public class CashbackHackService {

    /**
     * If amount less or more of boundary
     * service need to calculate how much is not enough to cashback.
     *
     * @param amount needed amount
     * @return how much is not enough
     */
    public int remainSumForCashback(int amount) {
        return CASHBACK_BOUNDARY - amount % CASHBACK_BOUNDARY;
    }
}
