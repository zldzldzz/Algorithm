import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int N = Integer.parseInt(input);

        int[] dx={1, 0, -1, 0};
        int[] dy={0,-1, 0, 1};

        String[][] map = new String[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(map[i][j].equals("1")&&!visited[i][j]) {
                    Queue<Integer[]> q = new LinkedList<>();
                    q.add(new Integer[]{i, j});
                    visited[i][j] = true;

                    int count = 1;

                    while (!q.isEmpty()) {
                        Integer[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            if( now[0]+dx[k]>=0 && now[1]+dy[k]>=0 && now[0]+dx[k] <N && now[1]+dy[k]<N ) {
                                if(map[now[0]+dx[k]][now[1]+dy[k]].equals("1")&&!visited[now[0]+dx[k]][now[1]+dy[k]]){
                                    q.add(new Integer[]{now[0]+dx[k], now[1]+dy[k]});
                                    visited[now[0]+dx[k]][now[1]+dy[k]]=true;
                                    count++;
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }

        Collections.sort(list);;

        bw.write(list.size()+"\n");
        for (Integer i : list) {
            bw.write(String.valueOf(i)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}