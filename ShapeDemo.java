abstract class Shape {
    private final String name;

    protected Shape(String name) { this.name = name; }

    public String getName() { return name; }

    // Abstract methods — every concrete subclass MUST implement both
    public abstract double area();
    public abstract double perimeter();

    // Concrete method shared by all shapes
    public void describe() {
        System.out.printf("%-10s area=%.2f perimeter=%.2f%n",
                name, area(), perimeter());
    }
}

class Circle extends Shape {
    private final double r;
    Circle(double r) { super("Circle"); this.r = r; }
    @Override public double area() { return Math.PI * r * r; }
    @Override public double perimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    private final double w, h;
    Rectangle(double w, double h) { super("Rectangle"); this.w = w; this.h = h; }
    @Override public double area() { return w * h; }
    @Override public double perimeter() { return 2 * (w + h); }
}

class Square extends Shape {
    private final double side;
    Square(double side) { super("Square"); this.side = side; }
    @Override public double area() { return side * side; }
    @Override public double perimeter() { return 4 * side; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        // Shape s = new Shape("x"); // COMPILE ERROR: Shape is abstract

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Square(3)
        };

        for (Shape s : shapes) {
            s.describe(); // polymorphic dispatch to area()/perimeter()
        }
    }
}