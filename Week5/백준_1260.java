import java.util.*;

public class sMain {
	private LinkedList<Integer>	adj[]; //LinkedList를 담는 배열
	private boolean[] visited;
	
	Main(int v) {
		adj = new LinkedList[v];
		visited = new boolean[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int a, int b) {
		adj[a-1].add(b-1);
		adj[b-1].add(a-1);
		Collections.sort(adj[a-1]);
		Collections.sort(adj[b-1]);
	}
	
	void BFS(int s) {
		Queue<Integer> queue = new LinkedList<>();
		visited[s-1] = true;
		queue.add(s-1);
		
		while(queue.size() != 0) {
			s = queue.poll();
			System.out.print(s+1 + " ");
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int next = i.next();
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}
	
	void DFS(int s) {
		System.out.print(s + " ");
		visited[s-1] = true;
		
		Iterator<Integer> i = adj[s-1].listIterator();
		while(i.hasNext()) {
			int next = i.next();
			if(!visited[next]) {
				DFS(next+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vertexNum = sc.nextInt();
		int edgeNum = sc.nextInt();
		int startNode = sc.nextInt();
		
		Main g =  new Main(vertexNum);
		Main s =  new Main(vertexNum);
		
		for(int i = 0; i < edgeNum; i++) { 
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.addEdge(a, b);
			s.addEdge(a, b);
		}
		
		g.DFS(startNode);
		System.out.println();
		s.BFS(startNode);
		
		return;
	}
}