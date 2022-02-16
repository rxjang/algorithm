package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman12 {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);


        while (num != 0) {
            for (Map.Entry<String, Integer> value : map.entrySet()) {
                if (num >= value.getValue()) {
                    num -= value.getValue();
                    sb.append(value.getKey());
                    break;
                }
            }
        }
        return sb.toString();
    }
}
