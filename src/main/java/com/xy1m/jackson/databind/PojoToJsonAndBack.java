package com.xy1m.jackson.databind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xy1m.MyValue;

import java.io.File;
import java.io.IOException;

/**
 * Created by gzhenpeng on 6/8/18
 */
public class PojoToJsonAndBack {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String... args) throws IOException {
        MyValue v1 = new MyValue("george", 29);

        // write to
        File tmpFile = new File("result.json");
        mapper.writeValue(tmpFile, v1);
        String pojo2json = mapper.writeValueAsString(v1);
        byte[] pojo2jsonBytes = mapper.writeValueAsBytes(v1);

        System.out.println("Write to string" + pojo2json);
        System.out.println("Write to bytes" + pojo2jsonBytes);

        // read back
        MyValue file2pojo = mapper.readValue(tmpFile, MyValue.class);
        System.out.println("Read from file:" + file2pojo);
        //MyValue value1 = mapper.readValue(new URL("http://xxx.json"), MyValue.class);
        MyValue json2pojo = mapper.readValue(pojo2json, MyValue.class);
        System.out.println("Read from string:" + json2pojo);

    }
}
