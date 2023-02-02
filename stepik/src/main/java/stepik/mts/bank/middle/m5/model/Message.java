package stepik.mts.bank.middle.m5.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import stepik.mts.bank.middle.m5.type.EnrichmentType;

public class Message {
    private final String content;
    private final EnrichmentType enrichmentType;

    public Message(String content, EnrichmentType enrichmentType) throws RuntimeException {
        JsonParser.parseString(content); // корректный JSON?
        this.content = content;
        this.enrichmentType = enrichmentType;
    }

    public JsonObject getContent() throws RuntimeException {
        return JsonParser.parseString(content).getAsJsonObject();
    }

    public EnrichmentType getEnrichmentType() {
        return enrichmentType;
    }

    public String getEnrichmentTypeFieldName() {
        return getContentField(enrichmentType.name().toLowerCase()).getAsString();
    }

    public JsonElement getContentField(String fieldName) throws RuntimeException {
        return getContent().get(fieldName);
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", enrichmentType=" + enrichmentType +
                '}';
    }
}