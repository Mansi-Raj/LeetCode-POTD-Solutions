public class Feb10 {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);

        while (true) {
            int firstDigitIndex = -1;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    firstDigitIndex = i;
                    break;
                }
            }
            if (firstDigitIndex == -1) {
                break;
            }
            int closestNonDigitIndex = -1;
            for (int i = firstDigitIndex - 1; i >= 0; i--) {
                if (!Character.isDigit(sb.charAt(i))) {
                    closestNonDigitIndex = i;
                    break;
                }
            }
            sb.deleteCharAt(firstDigitIndex);
            sb.deleteCharAt(closestNonDigitIndex);
        }

        return sb.toString();
    }
}
