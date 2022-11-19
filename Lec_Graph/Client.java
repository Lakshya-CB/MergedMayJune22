package Lec_Graph;

public class Client {
	public static void main(String[] args) {
		Graph G= new Graph(7);
		G.addEdge(1,4,10);
		G.addEdge(1,2,2);
		G.addEdge(2,3,3);
		G.addEdge(3,4,1);
		G.addEdge(5,4,8);
		G.addEdge(5,6,5);
		G.addEdge(5,7,6);
		G.addEdge(6,7,4);
		System.out.println(G.map);
		System.out.println(G.hasPath(1, 6));
		G.Dijkstra(1);
	}
}
