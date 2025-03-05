public class Mar3 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int idx = 0;

        for (int num : nums) {
            if (num < pivot) {
                result[idx++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                result[idx++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                result[idx++] = num;
            }
        }

        return result;
    }
}
