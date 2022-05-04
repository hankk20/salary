package com.example.salary;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode
public class Allowance {

    private final AllowanceType type;
    private final double wage;

    private Allowance(AllowanceType type, double wage) {
        this.type = type;
        this.wage = wage;
    }

    public boolean isEmpty(){
        return type == null;
    }

    //static factory
    public static Allowance createEmptyType(double value){
        return new Allowance(null, value);
    }

    public static Allowance of(AllowanceType type, double value){
        if(type == null){
            throw new IllegalArgumentException("AllowanceType is null");
        }
        return new Allowance(type, value);
    }
}
