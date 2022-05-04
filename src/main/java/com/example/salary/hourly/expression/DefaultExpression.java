package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceParameter;
import com.example.salary.AllowanceType;
import org.springframework.stereotype.Component;

@Component
public class DefaultExpression extends AbstractHourlyExpression {

    public DefaultExpression() {
        super(AllowanceType.DEFAULT);
    }

    @Override
    public Allowance allowance(AllowanceParameter condition, Allowance allowance) {
        if(allowance.isEmpty()){
            return super.allowance(condition.isHoliday(), Allowance.of(super.allowanceType, allowance.getWage()));
        }
        return allowance;
    }

}
