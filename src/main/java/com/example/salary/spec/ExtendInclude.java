package com.example.salary.spec;

import java.util.function.DoubleFunction;

public enum ExtendInclude implements IncludeCalculator {
    TRUE(SalarySpecifications.extendIncludeSpec),
    FALSE((d) -> d);

    private DoubleFunction<Double> calculator;

    ExtendInclude(DoubleFunction<Double> f) {
        this.calculator = f;
    }

    public double calculate(double d) {
        return calculator.apply(d);
    }
}
