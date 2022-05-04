package com.example.salary;

import com.example.salary.hourly.StandardHourly;
import com.example.salary.v2.StandardHourly2;
import com.example.salary.hourly.StandardHourlyFactory;
import com.example.salary.hourly.expression.DefaultExpression;
import com.example.salary.hourly.expression.ExtendsExpression;
import com.example.salary.hourly.expression.HolidayExpression;
import com.example.salary.hourly.expression.NightExpression;
import com.example.salary.v2.allowance.AllowanceConditions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {HolidayExpression.class, NightExpression.class, ExtendsExpression.class, DefaultExpression.class , StandardHourlyFactory.class})
public class HourlyTest {

    @Autowired
    private StandardHourlyFactory factory;

    @Test
    @DisplayName("통합")
    void test4(){
        AllowanceParameter allowanceCondition = new AllowanceParameter(true, true);
        double hourly = 12000;
        StandardHourly standardHourly = factory.create(allowanceCondition, hourly);

        Allowance allowance = standardHourly.getAllowance(AllowanceType.DEFAULT);

        assertThat(standardHourly.getAllowance(AllowanceType.DEFAULT))
                .isEqualTo(Allowance.of(AllowanceType.DEFAULT, hourly/1.2));

        assertThat(standardHourly.getAllowance(AllowanceType.HOLIDAY))
                .isEqualTo(Allowance.of(AllowanceType.HOLIDAY, hourly/1.2));

        assertThat(standardHourly.getAllowance(AllowanceType.EXTEND))
                .isEqualTo(Allowance.of(AllowanceType.EXTEND, allowance.getWage()*1.5));

        assertThat(standardHourly.getAllowance(AllowanceType.NIGHT))
                .isEqualTo(Allowance.of(AllowanceType.NIGHT, allowance.getWage()*0.5));

    }

    /**
     * Expression을 CommonHourlyExpression 하나로 대체
     */
    @Test
    @DisplayName("v2")
    void test(){
        //화면에서 넘어오는 값 주휴수당 포함여부, 야간연장 포함여부, 그리고 시급
        AllowanceParameter allowanceCondition = new AllowanceParameter(true, true);
        double hourly = 12000;
        //파라미터로 넘어온 정보를 기준으로 시급처리기에서 사용하는 객체로 변환
        AllowanceConditions allowanceConditions = allowanceCondition.toAllowanceConditions();

        //수당정보묶음 (기본, 주휴, 연장, 야간)과 시급 정보
        StandardHourly2 standardHourly2 = new StandardHourly2(allowanceConditions, hourly);

        //테스트 비교값 기본급 조회
        Allowance allowance = standardHourly2.getAllowance(AllowanceType.DEFAULT);

        //각 수당 테스트 검증
        assertThat(standardHourly2.getAllowance(AllowanceType.DEFAULT))
                .isEqualTo(Allowance.of(AllowanceType.DEFAULT, hourly/1.2));

        assertThat(standardHourly2.getAllowance(AllowanceType.HOLIDAY))
                .isEqualTo(Allowance.of(AllowanceType.HOLIDAY, hourly/1.2));

        assertThat(standardHourly2.getAllowance(AllowanceType.EXTEND))
                .isEqualTo(Allowance.of(AllowanceType.EXTEND, allowance.getWage()*1.5));

        assertThat(standardHourly2.getAllowance(AllowanceType.NIGHT))
                .isEqualTo(Allowance.of(AllowanceType.NIGHT, allowance.getWage()*0.5));

    }


}
