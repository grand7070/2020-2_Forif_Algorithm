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
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;
		
		Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			return e.cost >= this.cost ? -1 : 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 1; i <= E; i++) {
			pq.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		parent = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		int total = 0;
		
		for(int i = 0; i < E; i++) {
			Edge e = pq.poll();
			int a = e.a;
			int b = e.b;
			if(FindParent(a) == FindParent(b)) continue;
			
			Union(a, b);
			total += e.cost;
		}
		
		System.out.println(total);
	}
}