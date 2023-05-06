package streams.chp12;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ParallelPoolTest {

    public static void main(String[] args) {

        //no of processors.
        System.out.println("Processors : " + Runtime.getRuntime().availableProcessors());

        //get Current degree of parallelism
        System.out.println("getParallelism : " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("getPoolSize : " + ForkJoinPool.commonPool().getPoolSize());

        System.out.println("Sequential...");

        Instant start = Instant.now();

        long ans = LongStream.rangeClosed(1, 100_000_000)
                            .sum();

        Instant end = Instant.now();

        System.out.println("Time taken in sequential : " + Duration.between(start, end).toMillis() + " ms ");
        System.out.println("Sum is : " + ans);

        System.out.println("Parallel...");

        start = Instant.now();

        LongStream.rangeClosed(1,100_000_000)
                .sum();

        end = Instant.now();

        System.out.println("Time taken in parallel : " + Duration.between(start, end).toMillis() + " ms");



    }
}
