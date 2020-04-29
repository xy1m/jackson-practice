package com.xy1m.jackson.databind;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by gzhenpeng on 6/8/18
 */
public class StringParserAndGenerator {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String... args) throws IOException {
        JsonFactory f = mapper.getFactory(); // may alternatively construct directly too

        // First: write simple JSON output
        File jsonFile = new File("test.json");
        JsonGenerator g = f.createGenerator(jsonFile, JsonEncoding.UTF8);
        // write JSON: { "message" : "Hello world!" }
        g.writeStartObject();
        g.writeStringField("message", "Hello world!");
        g.writeEndObject();
        g.close();

        // Second: read file back
        JsonParser p = f.createParser(jsonFile);

        JsonToken t = p.nextToken(); // Should be JsonToken.START_OBJECT
        t = p.nextToken(); // JsonToken.FIELD_NAME
        if ((t != JsonToken.FIELD_NAME) || !"message".equals(p.getCurrentName())) {
            // handle error
        }
        t = p.nextToken();
        if (t != JsonToken.VALUE_STRING) {
            // similarly
        }
        String msg = p.getText();
        System.out.printf("My message to you is: %s!\n", msg);
        p.close();
    }
}
