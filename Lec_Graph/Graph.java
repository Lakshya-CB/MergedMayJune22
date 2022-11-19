package Lec_Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
//HashMap<V1,Nbr>
//	HashMap<V1,HashMap<V2,Wt>> 
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public Graph(int V) {
		for (int i = 1; i <= V; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public Graph() {
		this(5);
	}

	public void addEdge(int V1, int V2, int Wt) {
		HashMap<Integer, Integer> V1_nbr = map.get(V1);
		V1_nbr.put(V2, Wt);
		HashMap<Integer, Integer> V2_nbr = map.get(V2);
		V2_nbr.put(V1, Wt);

	}

	public boolean containsEdge(int V1, int V2) {
		return map.get(V1).containsKey(V2);
	}

	public int getEdge(int V1, int V2) {
		return map.get(V1).get(V2);
	}

	public void removeEdge(int V1, int V2) {
		HashMap<Integer, Integer> V1_nbr = map.get(V1);
		V1_nbr.remove(V2);
		HashMap<Integer, Integer> V2_nbr = map.get(V2);
		V2_nbr.remove(V1);
	}

	public int numberOfEdges() {
		int ans = 0;
		for (int V1 : map.keySet()) {
			HashMap<Integer, Integer> V1_nbr = map.get(V1);
			ans = ans + V1_nbr.size();
		}
		return ans / 2;
	}

	public boolean hasPath(int src, int dest) {

		return hasPath(src, dest, new HashSet<>(), "");
	}

	private boolean hasPath(int src, int dest, HashSet<Integer> Visited, String str) {
		if (src == dest) {
			System.out.println(str + " " + src);
			return true;

		}
		if (Visited.contains(src)) {
			return false;
		}

		boolean ans = false;
		Visited.add(src);
		for (int nbr : map.get(src).keySet()) {
			boolean sp = hasPath(nbr, dest, Visited, str + " " + src);
			ans = ans || sp;
		}
		Visited.remove(src);
		return ans;
	}

	public boolean hasPath2(int src, int dest) {
		boolean ans = false;
		HashSet<Integer> Visited = new HashSet<>();
		Queue<Integer> Q = new LinkedList<>();
		Q.add(src);
		while (!Q.isEmpty()) {
			int curr = Q.poll();
			if (curr == dest) {
				ans = true;
			}
			if (Visited.contains(curr)) {
				System.out.println("Cycle exist");
				continue;
			}
			Visited.add(curr);
			for (int nbr : map.get(curr).keySet()) {
				if (!Visited.contains(nbr)) {
					Q.add(nbr);
				}
			}
		}
		return ans;
	}

	public void BFT() {
		HashSet<Integer> Visited = new HashSet<>();
		for (int src : map.keySet()) {
			if (Visited.contains(src)) {
				continue;
			}
			Queue<Integer> Q = new LinkedList<>();

			Q.add(src);

			while (!Q.isEmpty()) {
				int curr = Q.poll();
				if (Visited.contains(curr)) {
					System.out.println("Cycle exist");
					continue;
				}
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
		}
	}

	class pair implements Comparable<pair>{
		public pair(int src, int i) {
			// TODO Auto-generated constructor stub
			V = src;
			Wt = i;
		}

		int V;
		int Wt;
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.Wt - o.Wt;
		}
	}

	public void Dijkstra(int src) {
		PriorityQueue<pair> PQ = new PriorityQueue<>();
		HashSet<Integer> Visited = new HashSet<>();

		PQ.add(new pair(src, 0));
		while (!PQ.isEmpty()) {
			pair curr = PQ.poll();
			if (Visited.contains(curr.V)) {
				continue;
			}
			Visited.add(curr.V);
			System.out.println(src +" to "+curr.V+" at cost "+curr.Wt);
			for (int nbr : map.get(curr.V).keySet()) {
				if (!Visited.contains(nbr)) {
					int E = getEdge(nbr, curr.V);
					PQ.add(new pair(nbr, curr.Wt + E));
				}
			}

		}

	}
}
