public class Feb15 {
    public int punishmentNumber(int n) {
        int punish = 0;
        for(int i=1;i<=n;i++){
            if(isValid(Integer.toString(i*i),i,0,0)){
                punish += i*i;
            }
        }
        return punish;
    }

    public boolean isValid(String str, int target, int index, int sum){
        if(index == str.length()) return sum == target;
        int num = 0;
        for(int i=index;i<str.length();i++){
            num = num * 10 + (str.charAt(i) - '0');
            if(sum + num > target) break;
            if(isValid(str, target, i+1, sum+num)) return true;
        }
        return false;
    }
}
