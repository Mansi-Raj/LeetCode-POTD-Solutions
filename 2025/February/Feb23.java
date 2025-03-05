import java.util.Arrays;

public class Feb23 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
     int l=preorder.length;
        if(l==0)
            return null;
        if(l==1){
            TreeNode root=new TreeNode(preorder[0]);
            return root;
        }
        TreeNode root=new TreeNode(preorder[0]);
        int j,a=preorder[1];
        for(j=0;j<l;j++){
            if(postorder[j]==a)
            break;
        }
        root.left=constructFromPrePost(Arrays.copyOfRange(preorder,1,2+j),Arrays.copyOfRange(postorder,0,j+1));
        root.right=constructFromPrePost(Arrays.copyOfRange(preorder,2+j,l),Arrays.copyOfRange(postorder,j+1,l-1));
        return root;
    }
}
