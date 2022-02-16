package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        boolean[] print = new boolean[nums.length];

        backtrack(nums, print, new ArrayList<>(), answers);

        return answers;
    }

    public void backtrack(int[] nums, boolean[] print, List<Integer> list, List<List<Integer>> answers) {

        if (list.size() == nums.length) {
            answers.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (print[i]) {
                continue;
            }
            list.add(nums[i]);
            print[i] = true;
            backtrack(nums, print, list, answers);
            list.remove(list.size() - 1);
            print[i] = false;
        }

    }
}
