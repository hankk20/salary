package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceParameter;
import com.example.salary.AllowanceType;
import org.springframework.stereotype.Component;

@Component
public class NightExpression extends AbstractHourlyExpression{


    protected NightExpression() {
        super(AllowanceType.NIGHT);
    }

    @Override
    public Allowance allowance(AllowanceParameter condition, Allowance allowance) {
        return allowance(condition.isNight(), allowance);
    }

}
