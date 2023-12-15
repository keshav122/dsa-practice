package com.dsa.basic_1_1;

import java.util.HashMap;
import java.util.Map;

public class Datatype {

	public static int dataTypes(String type) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Integer", 4);
		map.put("Long", 8);
		map.put("Float", 4);
		map.put("Double", 8);
		map.put("Character", 1);
		return map.get(type);
	}
}
