package streams.chp09;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BankTransactionTest {

    public static List<BankTransaction> transactions = getTransactions();

    public static void main(String[] args) {

        //find the total transactions done today
        long totalTransactions = getTotalTransactionsToday();
        System.out.println("Total Transactions : " + totalTransactions);

        //find the max individual transaction done today
        LocalDate when = LocalDate.now();
        Optional<BankTransaction> maxTransaction = getBiggestTransaction(when);

        System.out.println(maxTransaction.map(BankTransaction::getAccNumber)
                                                .orElse("No Transaction done on : " + when));

        //Find the minimum individual transaction done today
        Optional<BankTransaction> minTransaction = getSmallestTransaction(when);

        System.out.println(minTransaction.map(BankTransaction::getAccNumber)
                .orElse("No Transaction done on : " + when));

    }

    private static Optional<BankTransaction> getSmallestTransaction(LocalDate when) {
        return transactions.stream()
                            .filter(t -> t.getDate().equals(when))
                            .min(Comparator.comparing(BankTransaction::getAmount));
    }

    private static Optional<BankTransaction> getBiggestTransaction(LocalDate when){
        return  transactions.stream()
                            .filter(t -> t.getDate().equals(when))
                            .max(Comparator.comparing(BankTransaction::getAmount));
    }

    private static long getTotalTransactionsToday() {

        return transactions.stream()
                            .map(t -> 1L)
                            .count();

    }



    private static List<BankTransaction> getTransactions() {
        return Arrays.asList(
                new BankTransaction("123", BigDecimal.valueOf(250.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(1250.00), LocalDate.now().minusDays(1)),
                new BankTransaction("789", BigDecimal.valueOf(2250.00), LocalDate.now()),
                new BankTransaction("987", BigDecimal.valueOf(550.00), LocalDate.now()),
                new BankTransaction("654", BigDecimal.valueOf(750.00), LocalDate.now()),
                new BankTransaction("123", BigDecimal.valueOf(4350.00), LocalDate.now()),
                new BankTransaction("789", BigDecimal.valueOf(150.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(4250.00), LocalDate.now()),
                new BankTransaction("987", BigDecimal.valueOf(50.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(850.00), LocalDate.now().minusDays(2))
        );
    }
}
