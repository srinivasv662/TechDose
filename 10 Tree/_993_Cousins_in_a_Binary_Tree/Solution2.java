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
// BFS
public class Solution2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y) return false;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean doesXExist = false;
            boolean doesYExist = false;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.removeFirst();
                if(cur.val == x) doesXExist = true;
                if(cur.val == y) doesYExist = true;
                if(cur.left != null && cur.right != null){
                    if(cur.left.val == x && cur.right.val == y){
                        return false;
                    }
                    if(cur.left.val == y && cur.right.val == x){
                        return false;
                    }
                }
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
            
            if(doesXExist == true && doesYExist == true) return true;
        }
        return false;
    }
}