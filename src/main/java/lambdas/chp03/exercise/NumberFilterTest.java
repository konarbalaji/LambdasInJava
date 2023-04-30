package lambdas.chp03.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberFilterTest {

    private static List<Integer> nums = Arrays.asList(1,2,43,5,-234,23,6,7,19);

    public static void main(String[] args) {

        List<Integer> evenNums = filterTheNumber(num -> {
            return num%2==0;
        });

        System.out.println("Even Numbers : " + evenNums);

        List<Integer> oddNums = filterTheNumber(num -> {
            return num%2!=0;
        });

        System.out.println("Odd Numbers : " + oddNums);

        List<Integer> positiveNums = filterTheNumber(num -> {
            return num>0;
        });

        System.out.println("+ve Numbers : " + positiveNums);

        List<Integer> negativeNums = filterTheNumber(num -> {
            return num<0;
        });

        System.out.println("-ve Numbers : " + negativeNums);

    }

    public static List<Integer> filterTheNumber(NumberFilter filter){
        List<Integer> res = new ArrayList<>();

        for(Integer num : nums){
            if(filter.filterNumber(num))
                res.add(num);
        }
        return res;
    }
}