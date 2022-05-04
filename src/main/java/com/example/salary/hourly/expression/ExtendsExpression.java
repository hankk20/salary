package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceParameter;
import com.example.salary.AllowanceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExtendsExpression extends AbstractHourlyExpression{

    protected ExtendsExpression() {
        super(AllowanceType.EXTEND);
    }

    @Override
    public Allowance allowance(AllowanceParameter condition, Allowance allowance) {
        return allowance(condition.isExtend(), allowance);
    }
}
