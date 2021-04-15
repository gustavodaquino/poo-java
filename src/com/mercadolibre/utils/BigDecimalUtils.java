package com.mercadolibre.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalUtils {

    public static String currencyFormat(BigDecimal number) {
        return NumberFormat.getCurrencyInstance().format(number);
    }
}
