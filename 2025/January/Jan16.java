public class Jan16 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m % 2 == 0 && n % 2 == 0)
            return 0;
        int xor1 = 0;
        for (int num : nums1) {
            xor1 ^= num;
        }
        int xor2 = 0;
        for (int num : nums2) {
            xor2 ^= num;
        }
        return m % 2 == 1 && n % 2 == 1 ? xor1 ^ xor2 : (m % 2 != 0 ? xor2 : xor1);
    }
}