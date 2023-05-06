package streams.chp12;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class AddMillionNumbers {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        sequentialSum();
        long end = System.currentTimeMillis();
        System.out.println("Time took for 1 : " + (end - start) + " ms");

        start = System.currentTimeMillis();
        streamAtomicLongSum();
        end = System.currentTimeMillis();
        System.out.println("Time took for 1 : " + (end - start) + " ms");

        start = System.currentTimeMillis();
        streamReduceSum();
        end = System.currentTimeMillis();
        System.out.println("Time took for 1 : " + (end - start) + " ms");

    }

    private static void sequentialSum() {

        //accumulator variable
        long sum =0L;

        //sequencing
        for(long i=0; i<100_000_000; i++){
            sum += i;
        }
        System.out.println("1.Sequential Sum is : " + sum);
    }

    private static void streamAtomicLongSum() {

        //Thread safe but lot of memory access
        AtomicLong sum = new AtomicLong(0L);

        LongStream.range(1, 100_000_000)
                    .parallel()
                    .forEach(val -> sum.addAndGet(val));

        System.out.println("2.parlelized Sum is : " + sum);
    }

    private static void streamReduceSum() {

        long sum = LongStream.rangeClosed(1, 100_000_000)
                            .parallel()
                            .reduce(0, Long::sum);

        System.out.println("3.Streams sumreduce : " + sum);

        int noOfProc = Runtime.getRuntime().availableProcessors();
        System.out.println("noOfProc : "  + noOfProc);

    }


}
