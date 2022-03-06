package programmers;

public class TargetNumber43165 {
    int answer = 0;
    int[] nums;
    int value;

    public int solution(int[] numbers, int target) {
        nums = numbers;
        value = target;

        dfs(0, 0);

        return answer;
    }

    public void dfs(int depth, int result) {
        if (depth == nums.length) {
            if (result == value) {
                answer++;
            }
            return;
        }

        int add = result + nums[depth];
        int subtract = result - nums[depth];

        dfs(depth + 1, add);
        dfs(depth + 1, subtract);
    }
}
