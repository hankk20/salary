package com.example.salary.v2;

import com.example.salary.Allowance;
import com.example.salary.AllowanceCalculatorFinder;
import com.example.salary.AllowanceType;
import com.example.salary.hourly.expression.HourlyExpressionValidator;

import java.util.Arrays;
import java.util.List;

public class CommonHourlyExpression{

    private final boolean include;
    private final AllowanceType allowanceType;
    private List<AllowanceType> passTypes = Arrays.asList(AllowanceType.DEFAULT, AllowanceType.HOLIDAY);

    public CommonHourlyExpression(AllowanceType allowanceType, boolean include) {
        this.include = include;
        this.allowanceType = allowanceType;
    }

    public Allowance allowance(double value) {
        double calculate = AllowanceCalculatorFinder
                .findCalculator(allowanceType, include)
                .calculate(value);
        return Allowance.of(allowanceType, calculate);
    }

    //기본급인 수당이 들어오면 기본급 처리에서는 그대로 리턴, 주휴일때도 그대로 리턴해야되는데
    public Allowance allowance(Allowance allowance) {

        if(passed(allowanceType)){
            return Allowance.of(allowanceType, allowance.getWage());
        }

        HourlyExpressionValidator.validate(allowance);
        return allowance(allowance.getWage());
    }

    //별로 안좋은데... 억지로 끼워 맞춤...
    public boolean passed(AllowanceType allowanceType){
        return passTypes.contains(allowanceType);
    }

}
