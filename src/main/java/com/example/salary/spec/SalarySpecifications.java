package com.example.salary.spec;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.DoubleFunction;

public class SalarySpecifications {

    private static final BigDecimal HOURLY_INCLUDE_DIVIDE = new BigDecimal(String.valueOf(1.2));
    private static final BigDecimal HOURLY_TIME_INCLUDE_DIVIDE = new BigDecimal(String.valueOf(0.2));
    private static final BigDecimal EXTEND_INCLUDE_MULTIPLY = new BigDecimal(String.valueOf(1.5));
    private static final BigDecimal NIGHT_INCLUDE_MULTIPLY = new BigDecimal(String.valueOf(0.5));

    public static DoubleFunction<Double> hourlyIncludeSpec = (d) -> new BigDecimal(String.valueOf(d))
            .divide(HOURLY_INCLUDE_DIVIDE, MathContext.DECIMAL128)
            .doubleValue();

    public static DoubleFunction<Double> hourlyTimeIncludeSpec = (d) -> new BigDecimal(String.valueOf(d))
            .multiply(HOURLY_TIME_INCLUDE_DIVIDE, MathContext.DECIMAL128)
            .doubleValue();

    public static DoubleFunction<Double> extendIncludeSpec = (d) -> new BigDecimal(String.valueOf(d))
            .multiply(EXTEND_INCLUDE_MULTIPLY)
            .doubleValue();

    public static DoubleFunction<Double> nightIncludeSpec = (d) -> new BigDecimal(String.valueOf(d))
            .multiply(NIGHT_INCLUDE_MULTIPLY)
            .doubleValue();

}
