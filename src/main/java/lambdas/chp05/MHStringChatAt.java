package lambdas.chp05;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MHStringChatAt {
    public static void main(String[] args) throws Throwable {
        String input = "lambda";
        System.out.println("Usual Way : " + input.charAt(3)) ;

        MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

        MethodType methodType = MethodType.methodType(char.class, int.class);
        MethodHandle methodHandle = LOOKUP.findVirtual(String.class, "charAt", methodType);

        char output = (char)methodHandle.invokeExact(input,3);
        System.out.println("Using Method Handles : " + output);

    }
}
