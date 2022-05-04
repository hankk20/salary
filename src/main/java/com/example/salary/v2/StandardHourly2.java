package com.example.salary.v2;

import com.example.salary.Allowance;
import com.example.salary.AllowanceType;
import com.example.salary.v2.allowance.AllowanceCondition;
import com.example.salary.v2.allowance.AllowanceConditions;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 기본급은 처리 했지만
 * 주휴수당은 처리 못함
 */
@Slf4j
public class StandardHourly2 {

    private final Allowance allowance;
    private final AllowanceConditions conditions;
    private final HourlyExpressionFactory factory;

    /**
     *
     * @param conditions AllowanceCondition 정보 List
     * @param value 시급
     */
    public StandardHourly2(AllowanceConditions conditions, double value) {
        this.conditions = conditions;
        this.factory = new HourlyExpressionFactory();

        //기본급은 야간연장에 사용되므로 따로 생성
        CommonHourlyExpression expression = getExpression(conditions.find(AllowanceType.DEFAULT));
        allowance = expression.allowance(value);
    }

    public CommonHourlyExpression getExpression(AllowanceCondition condition){
        return factory.create(condition);
    }

    public Allowance getAllowance(AllowanceType allowanceType){
        return getAllowance(conditions.find(allowanceType));
    }

    public Allowance getAllowance(AllowanceCondition condition){
        return getExpression(condition)
                .allowance(allowance);
    }

    public List<Allowance> getAllowances(){
        return conditions.stream()
                .map(this::getAllowance)
                .collect(Collectors.toList());
    }





}
