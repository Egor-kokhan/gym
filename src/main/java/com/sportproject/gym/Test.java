package com.sportproject.gym;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        System.out.println("Ну Егоооор");
        HashMap<String, String> map = new HashMap<>();
        map.put("11", "1");
        map.put("2", "2");
        map.put("3", "3");

        map.keySet().removeIf(value -> value.equals("2"));

//        HashMap<String, String> cloneMap = new HashMap<>(map);
//
//        for (String key : cloneMap.keySet()) {
//            if (key.equals("2")) {
//                map.remove(key);
//            }
//        }

        System.out.println(map);

    }
}
