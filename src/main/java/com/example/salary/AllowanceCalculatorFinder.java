package com.example.salary;

import com.example.salary.spec.IncludeCalculator;

import java.util.EnumSet;

public class AllowanceCalculatorFinder {

    public static IncludeCalculator findCalculator(AllowanceType type, boolean include){
        EnumSet<? extends IncludeCalculator> enumSet = EnumSet.allOf(type.getEnumClass());
        return enumSet.stream()
                .filter(f -> Boolean.valueOf(f.toString()) == include)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
