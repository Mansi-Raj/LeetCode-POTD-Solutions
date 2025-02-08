import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Feb8 {
    Map<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> indexMap;

    public Feb8() {
        map = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int prevNumber = indexMap.get(index);
            if (map.containsKey(prevNumber)) {
                map.get(prevNumber).remove(index);
                if (map.get(prevNumber).isEmpty()) {
                    map.remove(prevNumber);
                }
            }
        }
        indexMap.put(index, number);
        map.putIfAbsent(number, new TreeSet<>());
        map.get(number).add(index);
    }

    public int find(int number) {
        return map.containsKey(number) && !map.get(number).isEmpty() ? map.get(number).first() : -1;
    }
}