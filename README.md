# salary
일용직 시급 계산
### 분석 시작점
  [테스트코드](/src/test/java/com/example/salary/HourlyTest.java) 보고 분석 시작
### Package
  v2 로 시작하는 패키지는 한번 리팩토링
    - HourlyExpression 구현체를 전부 없애고 CommonHourlyExpression 하나로 대체 함
    
      => 문제점
        1. 각 수당별 처리가 힘듬
        2. 그래서 passType을 정의해서 해당 Type은 계산처리를 하지 않도록 함 => 억지로 맞춤 느낌이라 안좋음
