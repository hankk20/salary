package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceParameter;
import com.example.salary.AllowanceType;
import org.springframework.stereotype.Component;

@Component
public class HolidayExpression extends AbstractHourlyExpression{

    protected HolidayExpression() {
        super(AllowanceType.HOLIDAY);
    }

    @Override
    public Allowance allowance(AllowanceParameter condition, Allowance allowance) {
        return Allowance.of(super.allowanceType, allowance.getWage());
    }
}
