package streams.chp08;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnyAllNoneMatchTest {
    public static void main(String[] args) {

        //has customer placed any order in last 6 months
        List<Order> orders = getOrders();
        LocalDate sixMonthsAGo = LocalDate.now().minusMonths(6);
        boolean anyOrdersInLastSixMonths = orders.stream()
                                                .anyMatch(o -> o.getPlaced().isAfter(sixMonthsAGo));

        if(anyOrdersInLastSixMonths)
            System.out.println("Yes......Orders are placed in last six months");

        //List all transaction worth more than 1 million
        List<Transaction> transactions = getTransactions();
        BigDecimal oneMillion = BigDecimal.valueOf(1000000);

        Predicate<Transaction> highValue = (tr) -> tr.getValue().compareTo(oneMillion)>0;
        boolean taxAnalysis = transactions.stream().allMatch(highValue);

        System.out.println("TaxAnalysis : " + taxAnalysis);

        //Process list of names where none are blank
        List<String> validNames = Arrays.asList("amit","ben","clark"," ","emily");
        boolean allValidNames = validNames.stream().noneMatch(String::isBlank);
        boolean allValidNamesAgain = !validNames.stream().anyMatch(String::isBlank);
        System.out.println("allValidNames : " + allValidNames);
        System.out.println("allValidNamesAgain : " + allValidNamesAgain);

    }

    private static List<Order> getOrders() {

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1,LocalDate.now().minusMonths(7)));
        orders.add(new Order(1,LocalDate.now().minusMonths(3)));
        orders.add(new Order(1,LocalDate.now().minusMonths(9)));
        orders.add(new Order(1,LocalDate.now().minusMonths(8)));
        orders.add(new Order(1,LocalDate.now().minusMonths(10)));
        return orders;
    }


    public static List<Transaction> getTransactions(){

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1,BigDecimal.valueOf(9000000)));
        transactions.add(new Transaction(1,BigDecimal.valueOf(1600000)));
        transactions.add(new Transaction(1,BigDecimal.valueOf(1900000)));
        transactions.add(new Transaction(1,BigDecimal.valueOf(1200000)));
        transactions.add(new Transaction(1,BigDecimal.valueOf(1500000)));
        return transactions;

    }
}

class Transaction{

    private int id;
    private BigDecimal value;

    public Transaction(int id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }
}

class Order{

    private int id;
    private LocalDate placed;

    public Order(int id, LocalDate placed) {
        this.id = id;
        this.placed = placed;
    }

    public int getId() {
        return id;
    }

    public LocalDate getPlaced() {
        return placed;
    }
}