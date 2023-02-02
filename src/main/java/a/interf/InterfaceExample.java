package a.interf;

public class InterfaceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Mouse mouse = new Mouse();

        System.out.println(mouse.catchThe(cat) ? "мышка поймала кошку" : "мышка не поймала кошку");
        System.out.println(dog.say());
        System.out.println(dog.catchThe(cat) ? "собака поймала кошку" : "собака не поймала кошку");
        System.out.println(cat.say());
        System.out.println(cat.catchThe(mouse) ? "кошка поймала мышку" : "кошка не поймала мышку");
        System.out.println(mouse.say());
    }
}


interface Animal {
    /***
     * обязывает предоставить состояние из объекта
     * @return голос
     */
    String say();

    /***
     * обязывает предоставить состояние из объекта
     * @return сила атаки животного
     */
    int getAttackForce();

    /***
     * обязывает хранить состояние в объекте
     * @return пойманное животное
     */
    default Animal getCaught() {
        return null;
    }

    /***
     * сравнение состояний объектов
     * @param other атакуемое животное
     * @return true - слабее атакуемого
     */
    default boolean isWeakerThan(Animal other) {
        return getAttackForce() < other.getAttackForce();
    }

    /***
     * иной результат сравнения состояний
     * @param other атакуемое животное
     * @return true - сильнее атакуемого
     */
    default boolean catchThe(Animal other) {
        return !isWeakerThan(other);
    }
}


class Dog implements Animal {
    /***
     * пойманное животное
     */
    private Animal caught;

    @Override
    public String say() {
        return "Гав-гав";
    }

    @Override
    public int getAttackForce() {
        return 5;
    }

    /***
     * изменение состояния по результатам сравнения
     * @param other атакуемое животное
     * @return true - животное поймано
     */
    @Override
    public boolean catchThe(Animal other) {
        if (Animal.super.catchThe(other)) {
            caught = other;
            return true;
        }
        return false;
    }

    @Override
    public Animal getCaught() {
        return caught;
    }
}


class Cat implements Animal {
    private Animal caught;

    @Override
    public String say() {
        return "Мяу-мяу";
    }

    @Override
    public int getAttackForce() {
        return 3;
    }

    @Override
    public boolean catchThe(Animal other) {
        if (Animal.super.catchThe(other)) {
            caught = other;
            return true;
        }
        return false;
    }

    @Override
    public Animal getCaught() {
        return caught;
    }
}


class Mouse implements Animal {

    @Override
    public String say() {
        return "Пи-пи";
    }

    @Override
    public int getAttackForce() {
        return 1;
    }

    @Override
    public boolean catchThe(Animal other) {
        // other съеден, поэтому getCaught ничего не вернёт ))
        return Animal.super.catchThe(other);
    }
}


class Insect implements Animal {

    @Override
    public String say() {
        return "";
    }

    @Override
    public int getAttackForce() {
        return 0;
    }
}


