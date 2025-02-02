package POTD;

public class Jan15 {
    public int minimizeXor(int num1, int num2) {
        int count2 = Integer.bitCount(num2);
        int result = 0;
        for (int i = 31; i >= 0 && count2 > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                count2--;
            }
        }
        for (int i = 0; i <= 31 && count2 > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                count2--;
            }
        }
        return result;
    }
}
