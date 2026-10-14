// interface = pure capability, no shared state required
interface Flyable {
    void fly();

    // default method — implementations get it for free
    default void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }
}

class Bird implements Flyable {
    private final String species;
    Bird(String species) { this.species = species; }

    @Override
    public void fly() {
        System.out.println(species + " flaps its wings and flies");
    }
}

class Aeroplane implements Flyable {
    private final String model;
    Aeroplane(String model) { this.model = model; }

    @Override
    public void fly() {
        System.out.println(model + " takes off using engines");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        // EXPLAIN: programming to the interface
        Flyable[] flyingThings = {
            new Bird("Eagle"),
            new Aeroplane("Boeing 747"),
            new Bird("Sparrow")
        };

        for (Flyable f : flyingThings) {
            f.fly();
            f.land(); // inherited default method
            System.out.println("---");
        }
    }
}