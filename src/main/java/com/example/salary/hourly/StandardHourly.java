package com.example.salary.hourly;

import com.example.salary.Allowance;
import com.example.salary.AllowanceParameter;
import com.example.salary.AllowanceType;
import com.example.salary.hourly.expression.HourlyExpression;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StandardHourly {

    private final AllowanceParameter allowanceCondition;
    private final Allowance allowance;
    private final List<HourlyExpression> list;

    public StandardHourly(List<HourlyExpression> list, AllowanceParameter allowanceCondition, double value) {
        this.list = list;
        this.allowanceCondition = allowanceCondition;

        //기본급은 야간연장에 사용되므로 따로 생성
        HourlyExpression expression = getExpression(AllowanceType.DEFAULT);
        this.allowance = expression.allowance(allowanceCondition, Allowance.createEmptyType(value));
    }

    public HourlyExpression getExpression(AllowanceType type){
        return list.stream().filter(h -> h.is(type))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("수당코드를 찿을수 없습니다. [{}]", type);
                    return new IllegalArgumentException();
                });
    }

    public Allowance getAllowance(AllowanceType type){
        return getExpression(type)
                .allowance(allowanceCondition, allowance);
    }

    public List<Allowance> getAllowances(){
        return list.stream()
                .map(h -> h.allowance(allowanceCondition, allowance))
                .collect(Collectors.toList());
    }





}
