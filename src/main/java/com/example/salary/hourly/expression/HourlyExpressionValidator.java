package com.example.salary.hourly.expression;

import com.example.salary.Allowance;
import com.example.salary.AllowanceType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HourlyExpressionValidator {

    public static void validate(Allowance allowance){
        if(allowance.getType() != AllowanceType.DEFAULT){
            log.error("시급 계산에서는 기본급 정보만 받을 수 있습니다. [{}]", allowance.getType());
            throw new IllegalArgumentException();
        }
    }
}
