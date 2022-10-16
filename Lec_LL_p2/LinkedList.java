package Lec_LL_p2;

import java.util.Stack;

public class LinkedList {
	class Node {
		public Node(int ali) {
			// TODO Auto-generated constructor stub
			data = ali;
		}

		int data;
		Node next;

	}

	Node head;

	public void print() {
		Node nn = head;
		while (nn != null) {
			System.out.print(nn.data + "=>");
			nn = nn.next;
		}
		System.out.println("null");
	}

	public int size() {
		int ans = 0;
		Node nn = head;
		while (nn != null) {
//			System.out.println(nn.data);
			ans++;
			nn = nn.next;
		}
		return ans;
	}

	public int getFirst() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		return head.data;
	}

	public int getLast() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		Node nn = head;
		while (nn.next != null) {
//			System.out.println(nn.data);
			nn = nn.next;
		}
		return nn.data;
	}

	public int get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("index galat hein!");
		}
		Node nn = head;
		for (int i = 1; i <= idx; i++) {
			nn = nn.next;
		}
		return nn.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int ali) {
		Node nn = new Node(ali);
		nn.next = head;
		head = nn;
	}

	public void addLast(int ali) {

		Node nn = new Node(ali);
		if (isEmpty()) {
			head = nn;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
//			System.out.println(nn.data);
			temp = temp.next;
		}
		temp.next = nn;
	}

	private Node getNode(int idx) {
		Node nn = head;
		for (int i = 1; i <= idx; i++) {
			nn = nn.next;
		}
		return nn;
	}

	public void addAt(int idx, int ali) {
		if (idx < 0 || idx > size()) {
			throw new RuntimeException("index galat hein!");
		}
		if (idx == 0) {
			addFirst(ali);
			return;
		}
		Node curr = new Node(ali);
		Node prev = getNode(idx - 1);
		Node after = prev.next;

		prev.next = curr;
		curr.next = after;
//		curr.next = prev.next.next;
	}

	public int removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		int ans = head.data;
		head = head.next;
		return ans;
	}

	public int removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("khali hein bhai!");
		}
		if (size() == 1) {
			return removeFirst();
		}
		Node seconsLast = getNode(size() - 2);
		Node Last = seconsLast.next;
		seconsLast.next = null;
		return Last.data;
	}

	public int removeAt(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new RuntimeException("index galat hein!");
		}
		if (idx == 0) {
			return removeFirst();
		}
		if (idx == size() - 1) {
			return removeLast();
		}

		Node prev = getNode(idx - 1);
		Node curr = prev.next;
		Node after = curr.next;

		prev.next = after;
		return curr.data;
	}

	public void rev() {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node after = curr.next;
			curr.next = prev;

			prev = curr;
			curr = after;
		}
		head = prev;

	}

	public void revRec() {
		Node temp = head;
		rev2(head);
		temp.next = null;

	}

	private void rev2(Node prev) {
		if (prev.next == null) {
			head = prev;
			return;
		}
		rev2(prev.next);
		Node curr = prev.next;
		curr.next = prev;

	}

	public void KRev(int k) {
		Stack<Node> S = new Stack<>();
		Node curr = head;

		Node newTail = null;
		Node newHead = null;

		while (curr != null) {
			Node after = curr.next;
			S.push(curr);

			if (S.size() == k) {
				while (!S.isEmpty()) {
					Node temp = S.pop();
//					addLast this node in the new LInkedList
					if (newTail == null) {
						newHead = temp;
						newTail = temp;
					} else {
						newTail.next = temp;
						newTail = temp;
					}
				}

			}
			curr = after;
		}
		// for the remaining nodes in the stack!
		while (!S.isEmpty()) {
			Node temp = S.pop();
//			addLast this node in the new LInkedList
			if (newTail == null) {
				newHead = temp;
				newTail = temp;
			} else {
				newTail.next = temp;
				newTail = temp;
			}
		}
		newTail.next = null;
		head = newHead;
	}

	public void midList() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) { // part 1
//		while (fast.next != null && fast != null) { // part 2 doest work!!

			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.data);

	}

	public void KthLast(int k) {
		Node ahead = head;
		for (int i = 0; i < k; i++) {
			ahead = ahead.next;
		}
		Node behind = head;
		while (ahead != null) {
			ahead = ahead.next;
			behind = behind.next;
		}
		System.out.println(behind.data);
	}

	public void createCycle() {

		Node n1 = new Node(1);
		head = n1;
		Node n2 = new Node(2);
		n1.next = n2;

		Node n3 = new Node(3);
		n2.next = n3;

		Node n4 = new Node(4);
		n3.next = n4;

		Node n5 = new Node(5);
		n4.next = n5;

		Node n6 = new Node(6);
		n5.next = n6;
		n6.next = n3;

	}

	public boolean hasCycle() {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;

	}
	
	public int loopLength() {
		if (!hasCycle()) {
			return -1;
		}
		Node fast = head;
		Node slow = head;
		while (true) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		Node safe = slow;
		Node car = slow.next;
		int ans = 0;
		while (car != safe) {
			car = car.next;
			ans++;
		}
		return ans + 1;
	}
	public void FloydCycleRem() {
		Node fast = head;
		Node slow = head;
		while (true) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		Node c2 = slow;
		Node c1 = head;
		while(c1.next!=c2.next) {
			c1=c1.next;
			c2=c2.next;
		}
		c2.next = null;
	}
//	https://leetcode.com/problems/sliding-window-maximum/
//	https://leetcode.com/problems/reverse-nodes-in-k-group/
	   public ListNode reverseKGroup(ListNode nn, int k) {
	        ListNode curr0 = nn;
	        int cnt =0;
	        while(curr0!=null&&cnt<k){
	            curr0 = curr0.next;
	            cnt++;
	        }
	        if(cnt<k){
	            return nn;
	        }
	        ListNode prev = reverseKGroup(curr0,k);
	        ListNode curr = nn;
	        for(int i=0;i<k;i++){
	            ListNode after = curr.next;
	            curr.next= prev;
	            prev = curr;
	            curr = after;
	        }
	        return prev;
	    }
}
//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode A = headA;
//        ListNode B = headB;
//        while(A!=B){
//            A = A.next;
//            B = B.next;
//            
//            if(A==B){
//                return A;
//            }
//            if(A==null){
//                A = headB;
//            }
//            if(B==null){
//                B = headA;
//            }
//            
//        }
//        return A;
//        
//    }
//}
//
//class Solution {
//    public int scoreOfParentheses(String s) {
//        Stack<String> S = new Stack<>();
//        for(int i=0;i<s.length();i++){
//            char ch = s.charAt(i);
//            if(ch=='('){
//                S.push(ch + "");
//            }else{
//                String prev = S.peek();
//                if(prev.equals("(")){
//                    S.pop();
//                    S.push(1+"");
//                }else{
//                    int curr = Integer.parseInt(S.pop());
//                    while(!S.isEmpty()&&!S.peek().equals("("){
//                    curr = curr +  Integer.parseInt(S.pop());
//                    }
//                    while(!S.isEmpty()&& S.peek().equals("(")){
//                    S.pop();
//                    curr = curr*2;
//                    }
//                    S.push(curr);
//                }
//            }
//        }
//    }
//}
