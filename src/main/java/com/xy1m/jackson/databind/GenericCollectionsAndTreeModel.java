package com.xy1m.jackson.databind;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xy1m.MyValue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by gzhenpeng on 6/8/18
 */
public class GenericCollectionsAndTreeModel {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String... args) throws IOException {
        Map<String, Integer> scoreByName = mapper.readValue("{\"name\":\"george\",\"age\":29}", Map.class);
        System.out.println("Json to map:" + scoreByName);
        List<String> names = mapper.readValue("[\"george\",\"bell\"]", List.class);
        System.out.println("Json to array:" + names);
        // and can obviously write out as well
        mapper.writeValue(new File("names.json"), names);

        Map<String, MyValue> results = mapper.readValue("{\"record\":{\"name\":\"george\",\"age\":29}}",
                new TypeReference<Map<String, MyValue>>() {});

        System.out.println("TypeReference:" + results);

        // can be read as generic JsonNode, if it can be Object or Array; or,
        // if known to be Object, as ObjectNode, if array, ArrayNode etc:
        ObjectNode root = (ObjectNode) mapper.readTree(new File("result.json"));
        String name = root.get("name").asText();
        int age = root.get("age").asInt();

        // can modify as well: this adds child Object as property 'other', set property 'type'
        root.with("other").put("type", "student");
        String json = mapper.writeValueAsString(root);
        System.out.println(json);
        // with above, we end up with something like as 'json' String:
        // {
        //   "name" : "Bob", "age" : 13,
        //   "other" : {
        //      "type" : "student"
        //   }
        // }
    }
}
