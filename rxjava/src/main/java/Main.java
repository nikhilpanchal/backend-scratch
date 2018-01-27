import com.nikhil.examples.Hello;

public class Main {

    public static void main(String... args) {
        String[] names = {"Nikhil", "Erica", "Aiden"};

        Hello greeter = new Hello();
        greeter.hello(names);
    }
}
