public class Feb25 {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1000000007;
        long result = 0;
        int oddCount = 0, evenCount = 1;
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum = (prefixSum + num) % 2;
            if (prefixSum == 1) {
                result = (result + evenCount) % MOD;
                oddCount++;
            } else {
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }

        return (int) result;
    }
}
