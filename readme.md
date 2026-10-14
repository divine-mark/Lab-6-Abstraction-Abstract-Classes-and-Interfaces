# Object-Oriented Programming in Java — Lab 6: Abstraction, Abstract Classes and Interfaces

**Author:** Divine Mark Makhomeya  
**Registration Number:** H250333E  
**Course:** Object Oriented Programming  

This repository contains my solutions for **Lab 6** of the OOP in Java lab manual.
The lab covers abstract classes, abstract methods, interfaces, default and static
interface methods, multiple interface implementation, choosing between abstract
classes and interfaces, and using standard interfaces like `Comparable`.

## Lab Objectives
- Define abstract classes and abstract methods, and explain why they cannot be instantiated.
- Define and implement interfaces, including default and static methods.
- Choose correctly between an abstract class and an interface.
- Program to an interface, not to an implementation.
- Use standard interfaces such as `Comparable`.

## Exercises

### Exercise 1: Abstract `Shape`
- Abstract class with abstract `area()` and `perimeter()`, plus a concrete `describe()`.
- Subclasses: `Circle`, `Rectangle`, `Square`.
- Loop over a `Shape[]` and dispatch polymorphically.

**Expected Output:**
Circle area=78.54 perimeter=31.42
Rectangle area=24.00 perimeter=20.00
Square area=9.00 perimeter=12.00

### Exercise 2: `Flyable` Interface
- Interface with `fly()` and a `default land()`.
- Implemented by `Bird` and `Aeroplane` — two classes with no common superclass.
- Demonstrates a capability shared by unrelated classes.

**Expected Output:**
Eagle flaps its wings and flies
Bird is landing

Boeing 747 takes off using engines
Aeroplane is landing

Sparrow flaps its wings and flies
Bird is landing


### Exercise 3: Abstract `Account`
- Abstract class with a concrete `deposit()` and abstract `monthlyFee()`.
- Subclasses: `SavingsAccount`, `CurrentAccount`.
- Shared state (`accountNumber`, `balance`) lives in the abstract class.

**Expected Output:**
Deposited 500.00, new balance 1500.00
SavingsAccount [SAV-001] balance=1500.00 monthlyFee=10.00

Deposited 500.00, new balance 2500.00
CurrentAccount [CUR-001] balance=2500.00 monthlyFee=25.00


### Exercise 4: `Student implements Comparable<Student>`
- `Comparable` defines the natural ordering (by name).
- `Comparator` provides alternative orderings (by marks asc/desc, by name desc).

**Expected Output:**
By name (natural): [Ada(88), Ben(91), Kuda(72), Lynn(65)]
By marks ascending: [Lynn(65), Kuda(72), Ada(88), Ben(91)]
By marks descending:[Ben(91), Ada(88), Kuda(72), Lynn(65)]
By name descending: [Lynn(65), Kuda(72), Ben(91), Ada(88)]


### Exercise 5: Diamond Default Method Conflict
- Two interfaces both declare `default void hello()`.
- The implementing class must override it and choose which parent to call.
- Uses `InterfaceName.super.methodName()` syntax.

**Expected Output:**
Hello from Greeter
Hello from Welcomer
Hello from Receptionist

## Files
- `ShapeDemo.java` — Exercise 1
- `FlyableDemo.java` — Exercise 2
- `AccountDemo.java` — Exercise 3
- `StudentSortingDemo.java` — Exercise 4
- `DiamondDefaultDemo.java` — Exercise 5

