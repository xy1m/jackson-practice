package com.xy1m;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by gzhenpeng on 5/31/18
 */
public class TestCore {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String... args) throws IOException {

        Map<String, String> map = mapper.readValue(new File("/Users/gzhenpeng/sample.json"), Map.class);
        System.out.println("===" + map);
        List<String> names = mapper.readValue("[\"a\",\"b\",\"c\"]", List.class);
        System.out.println(names);

        JsonNode root = mapper.readTree("{\"name\":\"Bob\",\"age\":12}");

        System.out.println(root.get("name").asText());
        System.out.println(root.get("age").asInt());
        root.with("other");

        System.out.println(mapper.writeValueAsString(root));


        JsonFactory f = mapper.getFactory();

        JsonGenerator g = f.createGenerator(new FileOutputStream("/Users/gzhenpeng/sample.json"));
        g.writeStartObject();
        g.writeStringField("message", "HelloWorld!");
        g.writeStringField("code", "200");
        g.writeEndObject();
        g.close();

        JsonParser p = f.createParser(new FileInputStream("/Users/gzhenpeng/sample.json"));
        JsonToken t = p.nextToken();
        if ((t != JsonToken.FIELD_NAME) || !"message".equals(p.getCurrentName())) {
            //
            System.out.println(p.getText());
        }
        t = p.nextToken();
        if (t != JsonToken.VALUE_STRING) {
            System.out.println(p.getText());
        }
        String msg = p.getText();
        System.out.println("Message to you:" + msg);
        p.close();

    }
}
