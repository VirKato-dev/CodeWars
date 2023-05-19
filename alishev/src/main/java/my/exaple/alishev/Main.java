package my.exaple.alishev;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Protobuf gRPC Server");

        // на сервер можно добавить несколько сервисов
        Server server = ServerBuilder.forPort(8080)
                .addService(new GreetingServiceImpl())
                .build();

        server.start();

        System.out.println("Сервер запущен");

        // сервер будет работать пока мы его не прервём
        server.awaitTermination();
    }
}
