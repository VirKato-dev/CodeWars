package stepik.mts.bank.middle.m5;

import stepik.mts.bank.middle.m5.model.Message;
import stepik.mts.bank.middle.m5.model.User;
import stepik.mts.bank.middle.m5.enricher.EnrichmentService;
import stepik.mts.bank.middle.m5.enricher.EnrichmentServiceImpl;
import stepik.mts.bank.middle.m5.repository.UserRepository;
import stepik.mts.bank.middle.m5.repository.UserRepositoryImpl;
import stepik.mts.bank.middle.m5.type.EnrichmentType;
import stepik.mts.bank.middle.m5.validator.MessageValidator;
import stepik.mts.bank.middle.m5.validator.EnrichmentTypeMessageValidator;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static UserRepository userRepository;
    private static List<Message> messages;

    public static void main(String[] args) {
        initUserRepository();
        initMessages();
        MessageValidator messageValidator = new EnrichmentTypeMessageValidator();
        EnrichmentService enrichmentService = new EnrichmentServiceImpl(userRepository, messageValidator);

        System.out.println(enrichmentService.enrich(messages.get(0)));
    }


    private static void initUserRepository() {
        List<User> users = new ArrayList<>();
        users.add(new User(123456, "Иван", "Иванов"));
        users.add(new User(234567, "Степан", "Степанов"));
        users.add(new User(345678, "Роман", "Романов"));
        userRepository = new UserRepositoryImpl(users);
    }

    private static void initMessages() {
        List<Message> list = new ArrayList<>();
        list.add(new Message("{\"action\": \"button_click\",\"page\": \"book_card\",\"msisdn\": \"234567\"}", EnrichmentType.MSISDN));
        messages = list;
    }
}
