package lambdas.chp03;

public class ThreadLambdas {

    public static void main(String[] args) {


        Runnable r = () -> {
            System.out.println("This is a long running operationj");
        };

        new Thread(r).start();

        Runnable r1 = () -> performLongRunningOperation();
        Thread t1 = new Thread(r1);
        t1.start();

    }

    private static void performLongRunningOperation() {
        System.out.println("Inside long running opetration");
    }
}
