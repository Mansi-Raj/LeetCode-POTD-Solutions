class Feb3 {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int n = nums.length;
        int maxLen = 1;
        int i = 0;

        while (i < n - 1) {
            int len = 1;
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                len++;
                i++;
            }
            maxLen = Math.max(maxLen, len);

            len = 1;
            while (i < n - 1 && nums[i] > nums[i + 1]) {
                len++;
                i++;
            }
            maxLen = Math.max(maxLen, len);

            if (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return maxLen;
    }
}