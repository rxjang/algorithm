package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum42579 {

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        int[] arr = solution(genres, plays);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] solution(String[] genres, int[] plays) {

        List<Map<Integer, Integer>> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (map.containsKey(genre)) {
                Map<Integer, Integer> music = list.get(map.get(genre));
                music.put(i, plays[i]);
            } else {
                map.put(genre, length++);
                Map<Integer, Integer> music = new HashMap<>();
                music.put(i, plays[i]);
                list.add(music);
            }
        }

        list.sort(Comparator.comparing(r -> r.values().stream().mapToInt(Integer::intValue).sum(), Comparator.reverseOrder()));
        List<Integer> answerList = new ArrayList<>();

        for (Map<Integer, Integer> musics: list) {
            List<Map.Entry<Integer, Integer>> sortedMusics = new ArrayList<>(musics.entrySet());
            sortedMusics.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            answerList.add(sortedMusics.get(0).getKey());
            if (sortedMusics.size() > 1) {
                answerList.add(sortedMusics.get(1).getKey());
            }
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}
