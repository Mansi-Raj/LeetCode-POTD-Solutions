public class Mar8 {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W')
                count++;
        }
        int result = count;

        for (int i = k; i < n; i++) {
            if (blocks.charAt(i) == 'W')
                count++;
            if (blocks.charAt(i - k) == 'W')
                count--;
            result = Math.min(result, count);
        }

        return result;
    }
}
