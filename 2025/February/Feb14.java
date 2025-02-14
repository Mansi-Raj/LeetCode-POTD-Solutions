import java.util.*;

public class Feb14{
    private List<Integer> stack;
    private int zeroIndex;
    private int res;

    public Feb14() {
        stack = new ArrayList<>();
        zeroIndex = -1;
        res = 1;
    }

    public void add(int num) {
        if (num == 0) {
            zeroIndex = stack.size();
            res = 1;
            stack.add(1);
        } else {
            res *= num;
            stack.add(res);
        }
    }

    public int getProduct(int k) {
        int n = stack.size();

        if (n - k <= zeroIndex) {
            return 0;
        } else if (n - k == zeroIndex + 1) {
            return stack.get(n - 1);
        }

        return stack.get(n - 1) / stack.get(n - 1 - k);
    }
}