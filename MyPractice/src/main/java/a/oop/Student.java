package a.oop;

public class Student {
    protected final String studying;
    protected Student(String work) {
        this.studying = work;
    }
    public Student() {
        this.studying = "Прохожу тестовое задание.";
    }
    public void study() {
        System.out.println("Я очень занят. " + studying);
    }
}


class JavaStudent extends Student {
    public JavaStudent() {
        super("Прохожу курс по Java.");
    }
}


class LazyStudent extends Student {
    public LazyStudent() {
        super("Мне сегодня лень.");
    }
    public void study() {
        System.out.println(studying);
    }
}


/*
Создай на его основе класс JavaStudent, который будет учиться на направлении Java.
Требования:
1. класс JavaStudent должен быть public static
2. класс JavaStudent должен быть наследников Student.
3. класс JavaStudent должен иметь только один публичный контруктор - конструктор без параметров.
4. класс JavaStudent не должен иметь новых методов или переопределять существующие.
5. Метод study() вызванный у объектов JavaStudent должен выводить в консоль сообщение "Я очень занят. Прохожу курс по Java."
 */