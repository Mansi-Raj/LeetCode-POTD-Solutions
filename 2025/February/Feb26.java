public class Feb26 {
    public int maxAbsoluteSum(int[] nums) {
        int positiveSum = 0; int negativeSum = 0;
        int maxPositiveSum = 0; int maxNegativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            positiveSum += nums[i];
            negativeSum += -nums[i];
            maxPositiveSum = Math.max(maxPositiveSum, positiveSum);
            maxNegativeSum = Math.max(maxNegativeSum, negativeSum);
            positiveSum = (positiveSum < 0) ? 0 : positiveSum;
            negativeSum = (negativeSum < 0) ? 0 : negativeSum;
        }

        return Math.max(maxPositiveSum, maxNegativeSum);
    }
}
