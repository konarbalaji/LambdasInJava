package lambdas.chp04;

import java.math.BigDecimal;
import java.util.function.Function;

public class FunctionAndThenComposeTest {

    public static void main(String[] args) {
        System.out.println("\n Difference between anThen and Compose : ");
        BigDecimal profit = BigDecimal.valueOf(20_000.0);

        //10% Hike
        Function<BigDecimal, BigDecimal> tenPercentHike = (s) -> s.add(s.multiply(BigDecimal.valueOf(0.1)));

        //Fixed Component
        Function<BigDecimal, BigDecimal> unitPerformance = (t) -> t.add(BigDecimal.valueOf(1000));

                                            // ------------------->
        BigDecimal totalMoney = tenPercentHike.andThen(unitPerformance).apply(profit);
        System.out.println("Total Money : " + totalMoney);

                                            //<---------------------
        BigDecimal totalMoney1 = tenPercentHike.compose(unitPerformance).apply(profit);
        System.out.println("Total Money : " + totalMoney1);
    }
}