package com.xy1m;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by gzhenpeng on 5/31/18
 */
@JsonIgnoreProperties({"foo", "bar"})
public class MyValue {
    @JsonProperty("name")
    public String name;
    public int age;

    @JsonCreator // constructor can be public, private, whatever
    public MyValue(@JsonProperty("name") String name,
                   @JsonProperty("age") int age) {
        this.name = name;
        this.age = age;
    }

    @JsonCreator
    public static MyValue create(@JsonProperty("name") String name) {
        // construct and return an instance
        return new MyValue(name, 0);
    }

    public String toString() {
        return String.format("{name:%s,age:%d}", name, age);
    }
}
