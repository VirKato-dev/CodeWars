package tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class BestStudents {

    static class Student {
        private String name;
        private int age;
        private double avg;

        public Student(String name, int age, double avg) {
            this.name = name;
            this.age = age;
            this.avg = avg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getAvg() {
            return avg;
        }

        public void setAvg(double avg) {
            this.avg = avg;
        }
    }


    private static double getAverageAgeOfTopStudents(List<Student> students, int n) {
        TreeSet<Student> best = new TreeSet<>(Comparator.comparing(Student::getAvg, Comparator.reverseOrder()));
        best.addAll(students);
        return best.stream().limit(n).mapToInt(Student::getAge).average().orElse(0.0);
    }


    private static double getAverageAgeOfTopStudents2(List<Student> students, int n) {
        List<Student> top = students.stream()
                .sorted(Comparator.comparing(Student::getAvg).reversed())
                .limit(n)
                .collect(Collectors.toList());
        return top.stream().limit(n)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иванов", 20, 4.7));
        students.add(new Student("Петров", 19, 4.0));
        students.add(new Student("Сидоров", 21, 4.9));
        students.add(new Student("Козлов", 22, 3.8));
        students.add(new Student("Смирнов", 20, 4.5));

        double avgAgeOfTopStudents = getAverageAgeOfTopStudents(students, 3);
        System.out.println("Средний возраст 3-х лучших студентов: " + avgAgeOfTopStudents);
    }

}
