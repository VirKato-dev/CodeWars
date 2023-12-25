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
        persons[0] = new Person();
    }
}
