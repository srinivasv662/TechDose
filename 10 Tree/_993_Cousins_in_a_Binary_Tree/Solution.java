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
public class Solution {
    
    public int find_HeightParent(TreeNode curr, int[] parent, int value, int height){
        if(curr == null) return 0;
        else if(curr.val == value) return height;
        
        parent[0] = curr.val;
        int left = find_HeightParent(curr.left, parent, value, height + 1);
        if(left > 0) return left;
        parent[0] = curr.val;
        int right = find_HeightParent(curr.right, parent, value, height + 1);
        return right;
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y){
            return false;
        }
        
        int[] xParent = new int[1];
        xParent[0] = -1;
        int xHeight = find_HeightParent(root, xParent, x, 0);
        
        int[] yParent = new int[1];
        yParent[0] = -1;
        int yHeight = find_HeightParent(root, yParent, y, 0);
        
        if(xParent[0] != yParent[0] && xHeight == yHeight){
            return true;
        }
        return false;
    }
}