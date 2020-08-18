package com.kalhari.onlinegym.spring.date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.kalhari.onlinegym.spring.date.Date;

import java.io.IOException;

public class CustomSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        //add your custom date parser
        gen.writeString(value.toString());
    }
}