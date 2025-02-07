import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Feb7 {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballToColor = new HashMap<>();
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int ballIndex = query[0];
            int newColor = query[1];

            if (ballToColor.containsKey(ballIndex)) {
                int oldColor = ballToColor.get(ballIndex);
                int count = colorCount.get(oldColor);

                if (count == 1) {
                    colorCount.remove(oldColor);
                } else {
                    colorCount.put(oldColor, count - 1);
                }
            }

            ballToColor.put(ballIndex, newColor);
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);

            result.add(colorCount.size());
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
