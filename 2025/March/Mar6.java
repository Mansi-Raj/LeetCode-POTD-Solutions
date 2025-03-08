import java.util.HashMap;
import java.util.Map;

public class Mar6 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        Map<Integer, Integer>map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0)+1);
                if(map.get(grid[i][j])==2) result[0]=grid[i][j];
            }
        }

        for(int i=1;i<=n*n;i++){
            if(!map.containsKey(i)){
                result[1]=i;
                break;
            }
        }
        return result;
    }
}
