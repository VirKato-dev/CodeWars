package tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OnlyUniqueNames {

    private static class User {
        public String name;
        public String surname;

        public User(String n, String s) {
            name = n;
            surname = s;
        }
    }

    private static final List<User> users = Arrays.asList(
            new User("Анна", "Иванова"),
            new User("Анна", "Смирнова"),
            new User("Михаил", "Тёмин")
    );

    public static void main(String[] args) {
        Set<String> result = users.stream()
                .map(u -> u.name)
                .collect(Collectors.toSet());

        System.out.println(result);
    }

}
