package http.client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        var url = new URL("file:/C:/Users/VirKato/IdeaProjects/CodeWars/dmdev/src/main/java/http/client/UrlExample.java");
        var urlConnection = url.openConnection();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }


    public static void checkGoogle(String[] args) throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();

        // GET
        var content = urlConnection.getContent();

        // POST
        urlConnection.setDoOutput(true);
        try (var os = urlConnection.getOutputStream()) {
            os.write("POST request".getBytes());
        }
    }

}
