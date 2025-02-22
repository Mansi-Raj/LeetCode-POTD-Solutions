/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Feb22 {
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return backTrack("",traversal);
    }
    private TreeNode backTrack(String s,String traversal){
        if(i>= traversal.length() || i+s.length() >= traversal.length()){
            return null;
        }
        
        if(!traversal.substring(i,i+s.length()).equals(s) && i!=0){
            return null;
        }
        i+=s.length();
        int j=i;
        while(j < traversal.length() && traversal.charAt(j) != '-'){
            j++;
        }
        System.out.println(i+" "+j);
        TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(i,j)));
        i=j;
        root.left = backTrack(s+"-",traversal);
        root.right = backTrack(s+"-",traversal);
        return root;
    }
}