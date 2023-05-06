package streams.chp11;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class InfiniteStreamTest {
    public static void main(String[] args) {

        System.out.println("\nNext 30 days");
        Stream.iterate(LocalDate.now(), d -> d.plusDays(1))
                .limit(30)
                .forEach(System.out::println);

        Stream.iterate(0, i -> i<50, i -> i+5)
                .forEach(System.out::println);

        System.out.println("\n10 random numbers between 0 and 10");
        Stream.generate(() -> new Random().nextInt(10))
                .limit(10)
                .forEach(System.out::println);

        System.out.println("UUID");

        Supplier<UUID> ids = () -> UUID.randomUUID();
        Stream.generate(ids)
                .limit(10)
                .forEach(System.out::println);

    }
}
