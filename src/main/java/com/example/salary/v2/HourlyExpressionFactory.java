package com.example.salary.v2;

import com.example.salary.v2.allowance.AllowanceCondition;
import com.example.salary.hourly.expression.HourlyExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class HourlyExpressionFactory {

    private ArrayList<HourlyExpression> expressions = new ArrayList<>();

    public CommonHourlyExpression create(AllowanceCondition condition2){
        return new CommonHourlyExpression(condition2.getAllowanceType(), condition2.isInclude());
    }
}
