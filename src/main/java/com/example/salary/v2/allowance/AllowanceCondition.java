package com.example.salary.v2.allowance;

import com.example.salary.AllowanceType;
import lombok.Getter;

@Getter
public class AllowanceCondition {
    private final AllowanceType allowanceType;
    private final boolean include;

    private AllowanceCondition(AllowanceType allowanceType, boolean include) {
        this.allowanceType = allowanceType;
        this.include = include;
    }

    public static AllowanceCondition of(AllowanceType allowanceType, boolean include){
        return new AllowanceCondition(allowanceType, include);
    }
}
