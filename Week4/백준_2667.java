import java.util.*;

public class Main {
	private static int[][] map;
	private static boolean[][] visited;
	private static int size;
	
	static int Search(int i, int j, int count) {
		while(i >= 0 && i < size && j >=0 && j < size && !visited[i][j] && (map[i][j] == 1)) {
			count++;
			visited[i][j] = true;

			count = Search(i, ++j, count);
			j--;
			count = Search(++i, j, count);
			i--;
			count = Search(i, --j, count);
			j++;
			count = Search(--i, j, count);
			i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();

		map = new int[size][size];
		visited = new boolean[size][size];
		
		String[] line = new String[size];
		for(int i = 0; i < size; i++) {
			line[i] = sc.next();
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				map[i][j] = line[i].charAt(j) - '0';
			}
		}
		
		LinkedList<Integer> numList = new LinkedList();
		int num = 0;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(!visited[i][j] && (map[i][j] == 1)) {
					int count = 0;
					numList.add(Search(i, j, count));
					num++;
				}
			}
		}
		
		Collections.sort(numList);
		Iterator<Integer> i = numList.listIterator();
		System.out.println(num);
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}