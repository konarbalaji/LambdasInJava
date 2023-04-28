package chp04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerChainingTest {

    public static void main(String[] args) {

        Response res = getResponse();

        Consumer<Response> kafka = (r) -> sendMessage(r);
        Consumer<Response> db = (r) -> storeInDb(r);
        Consumer<Response> email = (r) -> sendEmail(r);

        Consumer<Response> r = kafka.andThen(db).andThen(email);
        r.accept(res);

        List<String> str = new ArrayList<>();
        str.add("a");


    }

    private static void sendEmail(Response res){
        System.out.println("Sending Email ..."  + res.toString());
    }

    private static void processResponse(Consumer<Response> processResponse, Response resp){
        processResponse.accept(resp);
    }

    private static void sendMessage(Response res){
        System.out.println("Sending Response to Kafka..."  + res.toString());
    }

    private static void storeInDb(Response res){
        System.out.println("Storing Response in DB ..."  + res.toString());
    }

    private static Response getResponse() {
        return new Response(404,"Resource not found");
    }
}