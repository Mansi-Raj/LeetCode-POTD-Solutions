public class Feb4 {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (i < n - 1 && nums[i] >= nums[i + 1]) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
