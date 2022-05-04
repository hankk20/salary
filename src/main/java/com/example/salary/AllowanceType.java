package com.example.salary;

import com.example.salary.spec.ExtendInclude;
import com.example.salary.spec.HolidayInclude;
import com.example.salary.spec.NightInclude;
import lombok.EqualsAndHashCode;

public enum AllowanceType {
    DEFAULT(HolidayInclude.class),
    HOLIDAY(HolidayInclude.class),
    EXTEND(ExtendInclude.class),
    NIGHT(NightInclude.class);

    private Class<? extends Enum> enumClass;

    AllowanceType(Class<? extends Enum> enumClass){
        this.enumClass = enumClass;
    }

    public Class<? extends Enum> getEnumClass() {
        return enumClass;
    }
}
