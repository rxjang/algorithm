package backjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Hash1764 {

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int listenNum = Integer.parseInt(st.nextToken());
        int watchNum = Integer.parseInt(st.nextToken());

        HashSet<String> listen = new HashSet<>();
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < listenNum; i++) {
            listen.add(br.readLine());
        }

        for (int i = 0; i < watchNum; i++) {
            String watch = br.readLine();
            if (listen.contains(watch)) {
                answers.add(watch);
            }
        }

        Collections.sort(answers);
        StringBuilder answer = new StringBuilder();
        answer.append(answers.size()).append("\n");
        for (String s : answers) {
            answer.append(s).append("\n");
        }
        System.out.println(answer);

    }
}
