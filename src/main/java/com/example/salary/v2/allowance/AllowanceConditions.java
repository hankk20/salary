package com.example.salary.v2.allowance;

import com.example.salary.AllowanceType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AllowanceConditions {
    private final List<AllowanceCondition> allowanceConditions;

    public AllowanceConditions() {
        this.allowanceConditions = new ArrayList<>();
    }

    public void add(AllowanceType allowanceType, boolean include){
        allowanceConditions.add(AllowanceCondition.of(allowanceType, include));
    }

    /**
     *수당형태에 따른 수당조건 정보 조회
     * 기본급이면서 주휴수당 포함 이면
     * AllowanceCondition에는 allowanceType == AllowanceType.DEFAULT, isInclude == true
     */
    public AllowanceCondition find(AllowanceType allowanceType){
        return allowanceConditions.stream().filter(f -> f.getAllowanceType() == allowanceType)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Stream<AllowanceCondition> stream(){
        return allowanceConditions
                .stream();
    }


}
