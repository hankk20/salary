package com.example.salary.spec;

import java.util.function.DoubleFunction;

public enum NightInclude implements IncludeCalculator {
    TRUE(SalarySpecifications.nightIncludeSpec),
    FALSE((d) -> 0d);

    private DoubleFunction<Double> calculator;

    NightInclude(DoubleFunction<Double> f) {
        this.calculator = f;
    }

    public double calculate(double d) {
        return calculator.apply(d);
    }
}
