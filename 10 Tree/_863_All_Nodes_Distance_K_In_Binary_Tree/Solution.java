/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> list = new ArrayList<>();
    
    public ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data){
        
        if(node == null){
            return new ArrayList<>();
        }
        
        if(node.val == data){
            ArrayList<TreeNode> temp = new ArrayList<>();
            temp.add(node);
            return temp;
        }
        
        ArrayList<TreeNode> n2lcp = nodeToRootPath(node.left, data);
        
        if(n2lcp.size() > 0){
            n2lcp.add(node);
            return n2lcp;
        }
        
        ArrayList<TreeNode> n2rcp = nodeToRootPath(node.right, data);
        
        if(n2rcp.size() > 0){
            n2rcp.add(node);
            return n2rcp; 
        }
        
        return new ArrayList<>();
        
    }
    
    public void printKLevelsDown(TreeNode node, int k, TreeNode prhbt){
        if(node == null || node == prhbt){
            return;
        }
        
        if(k == 0){
            list.add(node.val);
            return;
        }
        
        printKLevelsDown(node.left, k - 1, prhbt);
        printKLevelsDown(node.right, k - 1, prhbt);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> n2rp = nodeToRootPath(root, target.val);
        TreeNode prhbt = null;
        
        for(int i = 0; i < n2rp.size(); i++){
            TreeNode node = n2rp.get(i);
            printKLevelsDown(node, k - i, prhbt);
            prhbt = node;
        }
        
        return list;
    }
}