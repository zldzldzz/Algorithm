import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(computers[i][j] == 1&&!visited[i]) {
					queue.add(i);
					answer++;
					visited[i] = true;
				}
				while(!queue.isEmpty()) {
					int cur = queue.poll();
					for(int k = 0; k < n; k++) {
						if(!visited[k] && computers[cur][k] == 1) {
							queue.add(k);
							visited[k] = true;
						}
					}
				}
			}
		}
        return answer;
    }
}