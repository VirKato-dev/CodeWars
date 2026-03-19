package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupToMap {

    private static class Entity {
        public String name;
        public long id;

        public Entity(String name, long id) {
            this.name = name;
            this.id = id;
        }
        public String toString() {
            return "{" + id + ":" + name + "}";
        }
    }

    private static List<Entity> entities;

    static {
        entities = new ArrayList<>();
        entities.add(new Entity("abc", 1));
        entities.add(new Entity("def", 2));
        entities.add(new Entity("ghi", 3));
        entities.add(new Entity("jkl", 4));
        entities.add(new Entity("mno", 5));
    }

    public static void main(String[] args) {
        Map<Long, Entity> entitiesMap = entities.stream()
                .collect(
                        Collectors.toMap(
                                e -> e.id,
                                e -> e
                        )
                );

        System.out.println(entitiesMap);
    }
}
