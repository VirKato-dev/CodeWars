package a.clone;

/***
 * Глубокое клонирование
 */
public class CloneExample {
    public static void main(String[] args) {
        Cat cat = new Cat("Вася", 2);
        Cat cat1 = new Cat("Мурка", 2);

        cat1.setPair(cat.clone()); // Мурка в паре с Васей
        cat.setPair(cat1); // Вася в паре с Муркой

        Cat cat2 = cat.clone(); // копия Васи

        cat.incAge(); // оригинал Васи постарел
        cat.getPair().incAge(); // у оригинала Васи пара постарела
        cat.getPair().clear(); // у оригинала Васи пара не говорит, что принадлежит Васе

        System.out.println(cat); // оригинал Васи
        System.out.println(cat2); // копия Васи

        StringBuilder sb = new StringBuilder("test");
        StringBuilder sbClone = new StringBuilder(sb); // клонирование через конструктор
        sb.append('!');
        System.out.println(sb);
        System.out.println(sbClone);
    }
}


class Cat implements Cloneable {
    private final String name; // неизменяемый
    private Integer age; // неизменяемый
    private Cat pair; // изменяемый

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void incAge() {
        age++;
    }

    public void setPair(Cat cat) {
        pair = cat;
    }

    public Cat getPair() {
        return pair;
    }

    public void clear() {
        pair = null;
    }

    @Override
    public Cat clone() {
        try {
            Cat clone = (Cat) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            if (pair != null) clone.pair = pair.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pair=" + pair +
                '}';
    }
}
