package a.generics;

public class WithArray {
    public static void main(String[] args) {
        class Person {
        }
        class Employee extends Person {
        }
        class Manager extends Employee {
        }

        Person[] persons = new Person[]{new Person()};
        Manager[] managers = new Manager[]{new Manager()};
        persons = managers;
        // Теперь person указывает на Manager[],
        // поэтому нельзя положить в него Person() являющийся более общим классом.
        // Получить из такого массива Person() можно -- ковариантность
        // Но добавить можем только Manager() -- инвариантность
        persons[0] = new Person();
    }
}
