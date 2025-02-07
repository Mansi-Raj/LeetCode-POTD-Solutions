import java.util.HashSet;
import java.util.Set;

public class Jan14 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        C[n - 1] = n;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == B[i]) {
                count++;
                C[i] = count;
            } else {
                if (set.contains(A[i]) && set.contains(B[i])) {
                    count += 2;
                    C[i] = count;
                } else if (set.contains(A[i]) || set.contains(B[i])) {
                    count++;
                    C[i] = count;
                } else {
                    C[i] = count;
                }
            }
            set.add(A[i]);
            set.add(B[i]);
        }
        return C;
    }
}
