import java.util.HashMap;
import java.util.Map;

public class Feb5 {
    public boolean areAlmostEqual(String s1, String s2) {
        // Map to store the frequency of each character in s1
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        // Map to store the frequency of each character in s2
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // Check if both strings have the same number of unique characters
        if (map1.size() != map2.size())
            return false;

        // Verify if both maps have the same characters with the same frequencies
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            char c = entry.getKey();
            int v = entry.getValue();

            if (!map2.containsKey(c)) { // Character in s1 not present in s2
                return false;
            } else {
                int v2 = map2.get(c);
                if (v != v2)
                    return false; // Mismatch in character frequencies
            }
        }

        // Count the number of positions where characters differ
        int misplaceCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                misplaceCount++;
                // If more than 2 characters are misplaced, return false
                if (misplaceCount > 2)
                    return false;
            }
        }

        // If 0 or 2 characters are misplaced, strings are almost equal
        return true;
    }
}