package programmers;

import java.util.HashMap;
import java.util.Map;

public class Camouflage42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                int num = map.get(cloth[1]) + 1;
                map.replace(cloth[1], num);
            } else {
                map.put(cloth[1], 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1);
        }

        return answer - 1;
    }
}
