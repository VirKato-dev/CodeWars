package stepik.mts.bank.middle.m5.validator;

import stepik.mts.bank.middle.m5.model.Message;

/**
 * Проверить наличие поля соответствующего названию типа обогащения
 */
public class EnrichmentTypeMessageValidator implements MessageValidator {
    @Override
    public boolean validate(Message message) {
        try {
            return !message.getContentField(message.getEnrichmentType().name().toLowerCase()).isJsonNull();
        } catch (Exception e) {
            return false;
        }
    }
}
