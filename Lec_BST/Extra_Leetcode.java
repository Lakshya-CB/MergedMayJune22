package Lec_BST;

public class Extra_Leetcode {

}

 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
 
 
 
//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 
class Solution {
	public int maxSumBST(TreeNode root) {
		soln_max = 0;
		isBST2(root);

		return soln_max;
	}

	int soln_max = 0;

	class pairBST {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isBST = true;
		int sum = 0;
	}

	private pairBST isBST2(TreeNode nn) {
		if (nn == null) {
			return new pairBST();
		}
		pairBST L = isBST2(nn.left);
		pairBST R = isBST2(nn.right);

		pairBST ans = new pairBST();

		if (L.isBST && R.isBST) {
//			left max <= nn.data < right min
			ans.isBST = L.max <= nn.val && nn.val < R.min;
			ans.sum = L.sum + nn.val + R.sum;
			if (ans.isBST) {
				soln_max = Math.max(ans.sum, soln_max);
			}
		}

		ans.min = Math.min(nn.val, L.min);
		ans.max = Math.max(nn.val, R.max);

		// ans.min = Math.min(nn.val ,Math.min(L.min, R.min));
		// ans.max = Math.max(nn.val ,Math.max(L.max, R.max));

		return ans;
	}
}


//https://leetcode.com/problems/flip-equivalent-binary-trees/
class Solution2 {
    public boolean flipEquiv(TreeNode p, TreeNode q) {
        if( q==null && p==null){
            return true;
        }
        if( q==null || p==null || q.val !=p.val){
            return false;
        }
        boolean noflip = flipEquiv(p.left,q.left)&&flipEquiv(p.right,q.right);
        boolean flip = flipEquiv(p.right,q.left)&&flipEquiv(p.left,q.right);
        
        return flip ||noflip;
        
    }
}

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
class Solution3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p || root==q){
            return root;
        }
        TreeNode L = lowestCommonAncestor(root.left,p,q);
        TreeNode R = lowestCommonAncestor(root.right,p,q);
        if(L!=null && R!=null){
            return root;
        }
        else if(L==null &&  R!=null){
            return R;
        }
        else if(R==null &&  L!=null){
            return L;
        }else {
        	return null;
        }
    }
}