package leetCode.graph;

public class DeleteAndEarn740 {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }

    public static int deleteAndEarn(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return 0;
        }

        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        int[] val = new int[max + 1];
        for (int num : nums) {
            val[num] ++;
        }

        int[] dp = new int[max + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], ( i > 1 ? dp[i - 2] : 0) + (i * val[i]));
            System.out.println(dp[i]);
        }
        return dp[max];
    }

}
