import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Feb12 {
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = getSum(num);
            map.putIfAbsent(sum, new PriorityQueue<>(Collections.reverseOrder()));
            map.get(sum).offer(num);
        }

        long maxSum = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() < 2) continue;
            long sum = pq.poll() + pq.poll();
            maxSum = Math.max(maxSum, sum);
        }
        return (int) maxSum;
    }
}
