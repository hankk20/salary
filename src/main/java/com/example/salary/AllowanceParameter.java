package com.example.salary;

import com.example.salary.v2.allowance.AllowanceConditions;
import lombok.Getter;

@Getter
public class AllowanceParameter {
    private boolean holiday;
    private boolean extend;
    private boolean night;

    public AllowanceParameter(boolean holiday, boolean extendsNight) {
        this.holiday = holiday;
        this.extend = extendsNight;
        this.night = extendsNight;
    }

    public AllowanceConditions toAllowanceConditions(){
        AllowanceConditions allowanceConditions = new AllowanceConditions();
        allowanceConditions.add(AllowanceType.DEFAULT, isHoliday());
        allowanceConditions.add(AllowanceType.HOLIDAY, isHoliday());
        allowanceConditions.add(AllowanceType.EXTEND, isExtend());
        allowanceConditions.add(AllowanceType.NIGHT, isExtend());
        return allowanceConditions;
    }

}
