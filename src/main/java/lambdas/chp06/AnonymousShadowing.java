package lambdas.chp06;

public class AnonymousShadowing {

    int i=10;

    public void inner() {
        int i=30;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.getClass().getName());
                System.out.println("This is a hello from an inner class : " + i);
                System.out.println("This is a hello from an inner class : " + AnonymousShadowing.this.i);
                System.out.println(this);
                System.out.println(AnonymousShadowing.this.toString());
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    @Override
    public String toString() {
        return "AnonymousShadowing{ i=" + i + '}';
    }

    public static void main(String[] args) {
        AnonymousShadowing outer = new AnonymousShadowing();
        outer.inner();
    }
}