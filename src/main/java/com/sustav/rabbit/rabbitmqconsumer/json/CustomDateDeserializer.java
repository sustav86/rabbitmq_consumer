package com.sustav.rabbit.rabbitmqconsumer.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDateDeserializer extends StdDeserializer<LocalDate> {

    private DateTimeFormatter gg = DateTimeFormatter.ofPattern("dd-MMM-yy");

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String text = p.getText();

        return LocalDate.parse(text, gg);
    }

    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomDateDeserializer() {
        this(null);
    }
}
