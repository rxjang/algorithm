package backjoon.basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sugar2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int bags = 0;

        if(sugar == 4 || sugar ==7) {
            bags = -1;
        } else {
            if(sugar % 5 == 0) {
                bags = sugar / 5;
            } else if (sugar < 15 && sugar % 3 == 0) {
                bags = sugar / 3;
            } else {
                while (true) {
                    sugar -=3;
                    bags ++;
                    if(sugar % 5 == 0) {
                        bags += sugar /5;
                        break;
                    }
                }
            }
        }

        System.out.println(bags);

//        if (sugar == 4 || sugar == 7) {
//            System.out.println(-1);
//        }
//        else if (sugar % 5 == 0) {
//            System.out.println(sugar / 5);
//        }
//        else if (sugar % 5 == 1 || sugar % 5 == 3) {
//            System.out.println((sugar / 5) + 1);
//        }
//        else if (sugar % 5 == 2 || sugar % 5 == 4) {
//            System.out.println((sugar / 5) + 2);
//        }
    }
}
