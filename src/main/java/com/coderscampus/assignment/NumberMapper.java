package com.coderscampus.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberMapper {
    public Map<Integer, Integer> mapNumbers(List<List<Integer>> numberLists) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (List<Integer> numberList : numberLists) {
            for (Integer number : numberList) {
                resultMap.put(number, resultMap.getOrDefault(number, 0) + 1);
            }
        }
        return resultMap;
    }
}