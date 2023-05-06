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

        //set the size of common pool
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","20");

        System.out.println("Sequential...");

        Instant start = Instant.now();

        long ans = LongStream.rangeClosed(1, 10)
                            .peek(num -> System.out.println(Thread.currentThread().getName()))
                            .map(num -> delay(num))
                            .sum();

        Instant end = Instant.now();

        System.out.println("Time taken in sequential : " + Duration.between(start, end).toMillis() + " ms ");
        System.out.println("Sum is : " + ans);

        System.out.println("Parallel...");

        start = Instant.now();

        ans = LongStream.rangeClosed(1,20)
                        .parallel()
                        .peek(num -> System.out.println(Thread.currentThread().getName()))
                        .map(num -> delay(num))
                        .sum();

        end = Instant.now();

        System.out.println("Time taken in parallel : " + Duration.between(start, end).toMillis() + " ms");
        System.out.println("ans : " + ans);

    }

    private static long delay(long num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return num*2;
    }
}
