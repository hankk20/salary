package com.example.salary.spec;

import java.util.function.DoubleFunction;

public enum HolidayInclude implements IncludeCalculator {
    TRUE(SalarySpecifications.hourlyIncludeSpec),
    FALSE((d) -> d);

    private DoubleFunction<Double> calculator;

    HolidayInclude(DoubleFunction<Double> f) {
        this.calculator = f;
    }

    public double calculate(double d) {
        return calculator.apply(d);
    }
}
