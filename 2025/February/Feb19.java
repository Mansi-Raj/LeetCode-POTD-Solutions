public class Feb19 {
    private int count = 0;
    private String result = "";

    public String getHappyString(int n, int k) {
        char[] chars = {'a', 'b', 'c'};
        backtrack(n, k, chars, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int k, char[] chars, StringBuilder current) {
        if (result.length() > 0) return;

        if (current.length() == n) {
            count++;
            if (count == k) {
                result = current.toString();
            }
            return;
        }

        for (char c : chars) {
            if (current.length() > 0 && current.charAt(current.length() - 1) == c) continue; 
            current.append(c);              
            backtrack(n, k, chars, current);
            current.deleteCharAt(current.length() - 1);  
        }
    }
}
