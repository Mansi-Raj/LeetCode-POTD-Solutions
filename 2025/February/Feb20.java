public class Feb20 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<nums.length;i++){
            char ch=(nums[i].charAt(i)=='0'?'1':'0');
            sb.append(ch); 
        }
        return sb.toString(); 
    }
}
