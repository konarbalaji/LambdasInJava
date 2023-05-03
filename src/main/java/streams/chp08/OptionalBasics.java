package streams.chp08;

import java.util.Optional;

public class OptionalBasics {
    public static void main(String[] args) {
        Optional<String> str = Optional.of("Hello Streams");

        System.out.println(str.isPresent());
        System.out.println(str.isEmpty());

        //orElse
        Optional<String> canBeEmpty = Optional.empty();
        System.out.println(canBeEmpty.orElse("Lambdas"));

        //convenience method - uses empty & of togetehr
        Optional<String> object = Optional.ofNullable(getObject());
        System.out.println(object.orElse("Streams"));
    }

    public static String getObject(){return null;}
}
