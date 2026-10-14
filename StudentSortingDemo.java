import java.util.*;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }

    // Natural ordering: by name (alphabetical)
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + "(" + marks + ")";
    }
}

public class StudentSortingDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Kuda", 72),
            new Student("Ada", 88),
            new Student("Lynn", 65),
            new Student("Ben", 91)
        ));

        // Natural order: by name (uses compareTo)
        Collections.sort(students);
        System.out.println("By name (natural):  " + students);

        // Comparator: by marks, ascending
        students.sort(Comparator.comparingInt(Student::getMarks));
        System.out.println("By marks ascending: " + students);

        // Comparator: by marks, descending
        students.sort(Comparator.comparingInt(Student::getMarks).reversed());
        System.out.println("By marks descending:" + students);

        // Comparator: by name, descending
        students.sort(Comparator.comparing(Student::getName).reversed());
        System.out.println("By name descending: " + students);
    }
}