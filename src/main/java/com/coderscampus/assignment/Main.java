package com.coderscampus.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
	    Assignment8 assignment8 = new Assignment8();
	    DataCollector dataCollector = new DataCollector(1000);
	    List<List<Integer>> numberLists = new ArrayList<>();
	    dataCollector.collectData(assignment8, numberLists);
	    dataCollector.shutdown();
	    
	    NumberMapper numberMapper = new NumberMapper();
	    Map<Integer, Integer> resultMap = numberMapper.mapNumbers(numberLists);

	    resultMap.forEach((number, count) -> System.out.println(number + ": " + count));
	}


}
