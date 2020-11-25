import java.util.*;

public class Main {
	static int V;
	static int E;
	static int[] parent;
	
	public static int FindParent(int x) {
		if(parent[x] == x) return x;
		parent[x] = FindParent(parent[x]);
		return parent[x];
	}
	
	public static void Union(int a, int b) {
		a = FindParent(a);
		b = FindParent(b);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static class Edge {
		int a;
		int b;
		int cost;
		
		Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		LinkedList<Edge> edges = new LinkedList<Edge>();
		//PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 1; i <= E; i++) {
			edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(edges, (o1, o2) -> o1.cost - o2.cost);
		
		parent = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		int total = 0;
		
		for(Edge e : edges) {
			int a = e.a;
			int b = e.b;
			
			if(FindParent(a) == FindParent(b)) {
				continue;
			}
			else {
				total += e.cost;
				Union(a, b);
			}
		}
		
		System.out.println(total);
	}
}