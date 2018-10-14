package com.sherlock.computation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation {

    public static BigDecimal divide(String numerator, String denominator)
    {
        BigDecimal num = new BigDecimal(numerator);
        BigDecimal den = new BigDecimal(denominator);
        return num.divide(den, 5, RoundingMode.HALF_UP);
    }
}
