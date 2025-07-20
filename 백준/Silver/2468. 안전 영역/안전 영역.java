import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int max = 0;
       int min = Integer.MAX_VALUE;
       int countMax =0;

       int[] dx = {1,0, -1, 0};
       int[] dy = {0, -1, 0, 1};
       int size= Integer.parseInt(br.readLine());
       int[][] map = new int[size][size];
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
               if(!a.contains(map[i][j])){
                   a.add(map[i][j]);
               }
            }
        }
        a.add(0);
        for (Integer i : a) {
            boolean[][] visited = new boolean[size][size];
            Queue<int[]> queue = new LinkedList<>();

            int localCount =0;

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {

                    if(map[j][k]>i&&!visited[j][k]){
                        localCount++;
                        queue.add(new int[]{j,k});
                        visited[j][k] = true;

                        while (!queue.isEmpty()) {
                            int[] now = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                if(dx[l]+now[0]>=0&&dy[l]+now[1]>=0&&dx[l]+now[0]<size&&dy[l]+now[1]<size&&!visited[dx[l]+now[0]][dy[l]+now[1]]){
                                    if(map[dx[l]+now[0]][dy[l]+now[1]]>i){
                                        queue.add(new int[]{dx[l]+now[0],dy[l]+now[1]});
                                        visited[dx[l]+now[0]][dy[l]+now[1]] = true;
                                    }
                                }
                            }
                        }
                    }

                }
            }
            if(localCount>countMax){
                countMax=localCount;
            }
        }

        bw.write(String.valueOf(countMax)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}



