package rec;

public class RecordExample {

    record Person(String name, int age) {}

    public static void main(String[] args) {
        Person person = new Person("John", 25);
        System.out.println(person);
    }
}
