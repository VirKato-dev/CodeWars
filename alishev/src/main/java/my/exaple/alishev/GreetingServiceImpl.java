package my.exaple.alishev;

import com.example.alishev.GreetingServiceGrpc;
import com.example.alishev.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;


public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseStreamObserver) {
        System.out.println("Пришло от клиента: " + request);

        for (int j = 0; j < 1000; j++) { // цикл добавлен для проверки отправки потока данных
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }

            GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                    .setGreeting("Привет от сервера, " + request.getName()) // name получили из запроса
                    .build();

            // отправить очередную часть ответа (или один ответ)
            responseStreamObserver.onNext(response);
        }

        // закончили передачу ответа (всех частей)
        responseStreamObserver.onCompleted(); // окончание потока
    }
}
