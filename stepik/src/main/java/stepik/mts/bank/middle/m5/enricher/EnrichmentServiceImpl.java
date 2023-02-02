package stepik.mts.bank.middle.m5.enricher;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import stepik.mts.bank.middle.m5.model.Message;
import stepik.mts.bank.middle.m5.model.User;
import stepik.mts.bank.middle.m5.repository.UserRepository;
import stepik.mts.bank.middle.m5.type.EnrichmentType;
import stepik.mts.bank.middle.m5.validator.MessageValidator;

import java.util.NoSuchElementException;


public class EnrichmentServiceImpl implements EnrichmentService {
    private final UserRepository userRepository;
    private final MessageValidator validator;

    public EnrichmentServiceImpl(UserRepository userRepository, MessageValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public synchronized String enrich(Message message) throws NoSuchElementException {
        JsonObject content = message.getContent();
        if (validator.validate(message)) {
            if (message.getEnrichmentType() == EnrichmentType.MSISDN) {
                User user = userRepository.findByMsisdn(Long.parseLong(message.getEnrichmentTypeFieldName()));
                JsonObject jo = new JsonObject();
                jo.add("firstName", new JsonPrimitive(user.getFirstname()));
                jo.add("lastName", new JsonPrimitive(user.getLastname()));
                content.add("enrichment", jo);
            }
        }
        return content.toString();
    }
}
