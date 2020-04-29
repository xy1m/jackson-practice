package com.xy1m.jackson.databind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xy1m.MyValue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by gzhenpeng on 6/8/18
 */
public class Conversions {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String... args) throws IOException {
        // Convert from List<Integer> to int[]
        List<Integer> sourceList = Arrays.asList(1, 2, 3, 4, 5);
        int[] ints = mapper.convertValue(sourceList, int[].class);
        System.out.println(ints.length);
        // Convert a POJO into Map!
        MyValue v1 = new MyValue("george", 29);
        Map<String, Object> propertyMap = mapper.convertValue(v1, Map.class);
        // ... and back
        MyValue pojo = mapper.convertValue(propertyMap, MyValue.class);
        System.out.println(pojo);
        // decode Base64! (default byte[] representation is base64-encoded String)
        String base64 = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz";
        byte[] binary = mapper.convertValue(base64, byte[].class);
        System.out.println(binary.length);
    }

}
