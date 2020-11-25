import java.util.*;

public class Main {
	private static boolean[] visited;
	private static LinkedList<Edge>[] graph;

	public static class Edge implements Comparable<Edge>{ //?
		int vertex; //연결된 정점
		int cost; //정점과의 가중치
		
		Edge(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	//Collections.sort(list, (o1, o2) -> o1.x - o2.x);
	
	public static int prim(int start) {
		int total = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
        
		/*
		Queue<Integer> q = new LinkedList();

		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			
			for(Edge e : graph[now]) {
				if(!visited[e.vertex])
					pq.add(e);
			}
			
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(!visited[e.vertex]) {
					q.add(e.vertex);
					visited[e.vertex] = true;
					total += e.cost;
					break;
				}
			}
		}
		 */
		
		
		visited[start] = true;
		for(Edge x : graph[start])
			pq.add(x);
		
		while(!pq.isEmpty()) {
			int curNode = pq.peek().vertex;
			int curCost = pq.peek().cost;
			pq.remove();
			
			if(!visited[curNode]) {
				visited[curNode] = true;
				total += curCost;
				
				for(Edge x : graph[curNode]) {
					if(!visited[x.vertex]) {
						int vertex = x.vertex;
						int cost = x.cost;
						pq.add(new Edge(vertex, cost));
					}
				}
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int verNum = sc.nextInt();
		int edgeNum = sc.nextInt();
		
		graph = new LinkedList[verNum+1];
		visited = new boolean[verNum+1];
		
		for(int i = 1; i <= verNum; i++) graph[i] = new LinkedList();
		
		for(int i = 1; i <= edgeNum; i++) { //통일성
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cost = sc.nextInt();
			graph[x].add(new Edge(y, cost));
			graph[y].add(new Edge(x, cost));
		}
		
		int start = 1;
		
		System.out.println(prim(start));
	}
}