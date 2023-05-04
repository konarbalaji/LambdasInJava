package streams.chp08;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FindFirstEncounterOrder {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(5,1022,23,324,61,2);

        Optional<Integer> elemtnt = numberList.stream()
                                        .filter(n -> n%2 == 0)
                                        .findFirst();

        System.out.println("From list : " + elemtnt.orElseThrow());

        Set<Integer> numberSet = Set.of(5,1022,23,324,61,2);

        elemtnt = numberSet.stream()
                            .sorted()
                            .filter(n -> n%2 == 0)
                            .findFirst();

        System.out.println("From list : " + elemtnt.orElseThrow());
    }
}
