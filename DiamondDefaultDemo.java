interface Greeter {
    default void hello() {
        System.out.println("Hello from Greeter");
    }
}

interface Welcomer {
    default void hello() {
        System.out.println("Hello from Welcomer");
    }
}

// EXPLAIN: both interfaces declare default void hello(), so the class
// MUST override it to resolve the conflict.
class Receptionist implements Greeter, Welcomer {
    @Override
    public void hello() {
        Greeter.super.hello();   // explicitly call Greeter's version
        Welcomer.super.hello();  // then Welcomer's
        System.out.println("Hello from Receptionist");
    }
}

public class DiamondDefaultDemo {
    public static void main(String[] args) {
        new Receptionist().hello();
    }
}