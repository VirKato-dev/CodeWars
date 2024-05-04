package reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

public class React {

    public static void main(String[] args) {
        Flux<Integer> flow = Flux.fromStream(Stream.generate(() -> new Random().nextInt(999)))
                .cache(1)    // reuse stream source from last element
//                .delaySubscription(Duration.ofMillis(400))
                .delayElements(Duration.ofMillis(200));

        flow
                .subscribe(
                        number -> System.out.println("Subscriber 1: " + number),
                        exception -> System.out.println("1 Error: " + exception.getMessage()),
                        () -> System.out.println("Done"),
                        subscription -> subscription.request(5)
                );

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        flow
                .doOnNext(number -> System.out.println("Subscriber 3: " + number))
                .doOnTerminate(() -> System.out.println("3 Terminated"))
                .doOnError(exception -> System.out.println("3 Error: " + exception.getMessage()))
                .onErrorComplete()
                .takeWhile(number -> number > 100)  // брать пока > 100
                .take(10)   // либо взял меньше 10 элементов
                .subscribe();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
