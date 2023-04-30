package streams.chp08;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> str = Optional.of("Hello Streams");

        System.out.println(str.isPresent());
        System.out.println(str.isEmpty());

        //orElse
        Optional<String> canBeEmpty = Optional.empty();
        System.out.println(canBeEmpty.orElse("Lambdas"));

        //Convenience Method - uses 'empty' and 'of' together
        Optional<String> object = Optional.ofNullable(getObject());
        System.out.println(object.orElse("Streams"));
    }

    private static String getObject() {
        return "Learning";
    }
}
