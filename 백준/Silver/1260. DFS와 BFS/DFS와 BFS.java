import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m, v;
	static int[][] map;
	static boolean[] dfsVisited, bfsVisited;

	public static void dfs(int v){
		System.out.print(String.valueOf(v)+" ");

		dfsVisited[v] = true;

		for(int i=1;i<=n;i++){
			if(1 == map[v][i]&&!dfsVisited[i]){
				dfs(i);
			}
		}
	}

	public static void bfs(int v){
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		bfsVisited[v] = true;
		while(!q.isEmpty()){
			int u = q.poll();
			System.out.print(String.valueOf(u)+" ");
			for(int i=1;i<=n;i++){
				if(1 == map[u][i]&&!bfsVisited[i]){
					bfsVisited[i] = true;
					q.add(i);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nmv = br.readLine().split(" ");
		n = Integer.parseInt(nmv[0]);
		m = Integer.parseInt(nmv[1]);
		v  = Integer.parseInt(nmv[2]);
		map = new int[n+1][n+1];

		for (int i = 0; i < m; i++) {
			String[] line = br.readLine().split(" ");
			map[Integer.parseInt(line[0])][Integer.parseInt(line[1])]=1;
			map[Integer.parseInt(line[1])][Integer.parseInt(line[0])]=1;
		}
		dfsVisited = new boolean[n+1];
		bfsVisited = new boolean[n+1];

		dfs(v);
		System.out.println();
		bfs(v);


		br.close();
	}
}