package com.example.salary.hourly;

import com.example.salary.AllowanceParameter;
import com.example.salary.hourly.expression.HourlyExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StandardHourlyFactory {

    private final List<HourlyExpression> hourlyExpressions;

    public StandardHourly create(AllowanceParameter allowanceCondition, double value){
        return new StandardHourly(hourlyExpressions, allowanceCondition, value);
    }
}
