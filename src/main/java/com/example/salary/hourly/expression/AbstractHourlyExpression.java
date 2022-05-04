package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceCalculatorFinder;
import com.example.salary.AllowanceType;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class AbstractHourlyExpression implements HourlyExpression{

    protected AllowanceType allowanceType;

    protected AbstractHourlyExpression(AllowanceType allowanceType){
        this.allowanceType = allowanceType;
    }

    @Override
    public boolean is(AllowanceType allowanceType) {
        return this.allowanceType == allowanceType;
    }

    public Allowance allowance(boolean include, Allowance allowance) {
        HourlyExpressionValidator.validate(allowance);
        double calculate = AllowanceCalculatorFinder
                .findCalculator(allowanceType, include)
                .calculate(allowance.getWage());
        return Allowance.of(allowanceType, calculate);
    }
}
