package lambdas.chp06;

public class LambdasLexical {

    int i=10;

    public void inner(){

        int i =30;

        Runnable r = () -> {
            System.out.println(this.getClass().getName());
            System.out.println("Accessing i directly inside lambda : " + i);
            System.out.println("Accessing i using 'this' inside lambda : " + this.i);
            System.out.println("This call is from inside lambda : " + this);
            System.out.println(toString());
        };

        Thread t = new Thread(r);
        t.start();

    }

    @Override
    public String toString() {
        return "LambdasLexical{ i=" + i + '}';
    }

    public static void main(String[] args) {
        LambdasLexical lex = new LambdasLexical();
        lex.inner();
    }
}
