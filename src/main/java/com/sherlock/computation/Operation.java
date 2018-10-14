package com.sherlock.computation;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class transforms strings into
 * BigDecimal and provides a division
 * operation with 5 digits precision
 */
public class Operation {

    public static BigDecimal divide(String numerator, String denominator)
    {
        BigDecimal num = new BigDecimal(numerator);
        BigDecimal den = new BigDecimal(denominator);
        return num.divide(den, 5, RoundingMode.HALF_UP);
    }
}
