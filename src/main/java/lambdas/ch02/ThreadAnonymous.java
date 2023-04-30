package lambdas.ch02;

public class ThreadAnonymous {
    public static void main(String[] args) {

        //With anonymous class
        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                performLongRunningOperation();
            }
        });

        t1.start();

        Thread t2 = new Thread(new MyThread());
        t2.start();
    }


    public static void performLongRunningOperation(){
        System.out.println("This is a long running operation...");
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("This is another long running operation...");
    }
}
