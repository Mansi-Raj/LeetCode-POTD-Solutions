import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Mar2 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) { 
        Map<Integer, Integer>map = new HashMap<>();
        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }
        for (int[] num : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        TreeMap<Integer, Integer>sortedMap = new TreeMap<>(map);
        int[][] result = new int[sortedMap.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        return result;
    }
}
