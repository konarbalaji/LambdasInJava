package streams.chp12.exercise;

import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimeNumbersParallel {

    public static void main(String[] args) {

        Instant start = Instant.now();
        long totalPrimes = LongStream.rangeClosed(1, 10_000_000)
                .filter(n -> isPrime(n))
                .count();

        System.out.println(totalPrimes);
    }

    private static boolean isPrime(long n) {
        boolean res = n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                                        .noneMatch(i -> n % i == 0);
        return res;
    }
}
