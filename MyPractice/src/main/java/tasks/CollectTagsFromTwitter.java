package tasks;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CollectTagsFromTwitter {

    public static void main(String[] args) {
        Collection<String> messages = List.of(
                "Сегодня в #МОСКВА хорошая погода, а в #Питер опять дождь",
                "В #питер сегодня пробки 10 баллов"
        );
        System.out.println(parse(messages));
    }


    public static Collection<String> parse1(Collection<String> messages) {
        // Создаём TreeSet для хранения хэштегов. TreeSet хранит элементы в отсортированном порядке
        // и обеспечивает регистронезависимость
        TreeSet<String> hashtags = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        // Итерируем по каждому сообщению
        for (String message : messages) {

            // Разбиваем сообщение на слова
            String[] words = message.split(" ");

            // Итерируем по каждому слову
            for (String word : words) {

                // Если слово начинается с '#', то оно считается хэштегом
                if (word.startsWith("#")) {

                    // Добавляем хэштег в TreeSet. TreeSet сам сортирует элементы и обеспечивает их уникальность
                    hashtags.add(word);
                }
            }
        }

        // Возвращаем TreeSet, который уже содержит отсортированные и уникальные хэштэги
        return hashtags;
    }


    public static Collection<String> parse(Collection<String> messages) {
        Set<String> tags = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Pattern pattern = Pattern.compile("#[а-яА-Я]+");
        for (String message : messages) {
            Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {
                tags.add(matcher.group());
            }
        }
        return tags;
    }
}
