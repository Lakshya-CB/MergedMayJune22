package Lec_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class QPS_graph {
//	https://leetcode.com/problems/word-ladder/
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dic = new HashSet<>(wordList);
		// System.out.println(dic);
//         
		StringBuilder putin = new StringBuilder(endWord);
		for (int i = 0; i < putin.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch = (char) (ch + 1)) {
				putin.setCharAt(i, ch);
				if (dic.contains(putin.toString())) {
					System.out.println(putin);
				}
			}
			putin.setCharAt(i, endWord.charAt(i));

		}

		return 0;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
//	https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
	
	class Solution {
		public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
			HashMap<TreeNode, HashSet<TreeNode>> map = new HashMap<>();
			make(map, root);
			// System.out.println(map);
			for (TreeNode V : map.keySet()) {
				System.out.print(V.val + " => ");
				for (TreeNode nbr : map.get(V)) {
					System.out.print(nbr.val + " ");
				}
				System.out.println();
			}
			return null;
		}

		public void make(HashMap<TreeNode, HashSet<TreeNode>> map, TreeNode nn) {
			if (nn == null) {
				return;
			}

			HashSet<TreeNode> nbr = new HashSet<>();
			map.put(nn, nbr);

			make(map, nn.left);
			make(map, nn.right);

			if (nn.left != null) {
				nbr.add(nn.left);
				map.get(nn.left).add(nn);
			}
			if (nn.right != null) {
				nbr.add(nn.right);
				map.get(nn.right).add(nn);
			}

		}
	}
}
