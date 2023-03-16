package parse.habr.post710330;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


public class ParseSite {

    private static class SchoolItem {
        public String name;
        public int votes;

        @Override
        public String toString() {
            return String.format("%40s - %5d", name, votes);
        }
    }


    private static class RefreshService extends Thread {

        interface OnComplete {
            void done(List<SchoolItem> schools);
        }

        private final OnComplete listener;

        private boolean isBusy = false;


        public RefreshService(OnComplete listener) {
            this.listener = listener;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                if (isBusy) continue;
                refreshList();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
            System.out.println("RefreshService stopped");
        }

        private void refreshList() {
            CompletableFuture
                    // совершить асинхронный запрос
                    .supplyAsync(() -> {
                        isBusy = true;
                        try {
                            return getList();
                        } catch (IOException ignored) {
                            return new LinkedList<SchoolItem>();
                        }
                    })
                    // когда запрос готов вернуть результат, передаём ответ через интерфейс
                    .thenAccept(list -> {
                        if (listener != null) {
                            listener.done(list);
                        }
                        isBusy = false;
                    });
        }
    }


    public static void main(String[] args) throws IOException {
        RefreshService.OnComplete onComplete = schools -> {
            System.out.println("\033[H\033[J"); // переместить курсор влево вверх и очистить экран консоли
            schools.sort(Comparator.comparingInt((SchoolItem o) -> o.votes).reversed().thenComparing(o -> o.name));
            schools.forEach(System.out::println);
        };

        RefreshService rs = new RefreshService(onComplete);
        rs.start();

//        List<SchoolItem> list = getList();
//        list.sort(Comparator.comparingInt((SchoolItem o) -> o.votes).reversed().thenComparing(o -> o.name));
//        list.forEach(System.out::println);
    }


    private static List<SchoolItem> getList() throws IOException {
        List<SchoolItem> list = new LinkedList<>();
//        String url = "https://habr.com/ru/post/710330/";
//        Document doc = Jsoup.connect(url).get();
//        Element body = doc.body();
//        Elements schools = body.select("div .tm-article-poll__answer .tm-article-poll__answer-data");
//        for (Element el : schools) {
//            SchoolItem item = new SchoolItem();
//            item.name = el.child(1).text();
//            item.votes = Integer.parseInt(el.child(2).text());
//            list.add(item);
//        }
        return list;
    }
}
