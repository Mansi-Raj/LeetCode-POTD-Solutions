import java.util.*;

public class Feb9 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = i - nums[i];
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        long ans = 0;
        for (int count : mp.values()) {
            ans += (long) count * (count - 1) / 2;
        }
        int n = nums.length;
        long tot = (long) n * (n - 1) / 2;
        return tot - ans;
    }
}