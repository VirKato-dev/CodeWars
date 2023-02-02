package stepik.mts.bank.middle.m5.enricher;

import stepik.mts.bank.middle.m5.model.Message;

public interface EnrichmentService {
    /**
     * @param message с необогащённым content
     * @return по возможности, обогащённый content
     */
    default String enrich(Message message) {
        return message.getContent().getAsString();
    };
}
