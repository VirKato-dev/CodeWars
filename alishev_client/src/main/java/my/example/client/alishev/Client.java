package my.example.client.alishev;

import my.exaple.alishev.GreetingServiceGrpc;
import my.exaple.alishev.GreetingServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;


public class Client {

    public static void main(String[] args) {
        // создать канал связи
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        // создать Stub, который свяжет удалённые методы с нашим клиентом
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder()
                .setName("VirKato")
                .build();

//        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request); // принять единичный пакет данных
//        System.out.println(response.getGreeting());

        // для получения потока данных от сервера
        Iterator<GreetingServiceOuterClass.HelloResponse> response = stub.greeting(request); // принять единичный пакет данных
        while (response.hasNext()) {
            System.out.println(response.next().getGreeting());
        }

        // закрыть канал связи
        channel.shutdownNow();
    }
}
