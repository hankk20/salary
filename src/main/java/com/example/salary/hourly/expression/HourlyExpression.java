package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceParameter;
import com.example.salary.AllowanceType;

public interface HourlyExpression {

    boolean is(AllowanceType allowanceType);
    Allowance allowance(AllowanceParameter condition, Allowance allowance);
}
