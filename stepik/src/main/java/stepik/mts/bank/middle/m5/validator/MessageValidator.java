package stepik.mts.bank.middle.m5.validator;

import stepik.mts.bank.middle.m5.model.Message;

public interface MessageValidator {
    /**
     * content должен быть JSON;
     * content должен содержать поле соответствующего EnrichmentType типа;
     * поле соответствующего EnrichmentType должно содержать значение.
     * @param message сообщение
     * @return true - content корректный
     */
    boolean validate(Message message);
}
