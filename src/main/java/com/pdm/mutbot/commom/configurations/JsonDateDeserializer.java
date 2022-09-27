package com.pdm.mutbot.commom.configurations;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class JsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (jsonparser.getText() != null) {
            String date = jsonparser.getText();
            try {
                return format.parse(date);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } else
            return null;
    }
}
