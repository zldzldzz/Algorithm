import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[][] arr = new String[n][m];
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split(" ");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int boxWidth = 0;
                if (arr[i][j].equals("1")&& !visited[i][j]) {
                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    boxWidth++;
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        if(x-1>=0 && arr[x-1][y].equals("1") && !visited[x-1][y]) {
                            queue.add(new int[]{x-1, y});
                            boxWidth++;
                            visited[x-1][y] = true;
                        }
                        if (x+1 < n && arr[x+1][y].equals("1") && !visited[x+1][y]) {
                            queue.add(new int[]{x+1, y});
                            boxWidth++;
                            visited[x+1][y] = true;
                        }
                        if (y-1>=0 && arr[x][y-1].equals("1") && !visited[x][y-1]) {
                            queue.add(new int[]{x, y-1});
                            boxWidth++;
                            visited[x][y-1] = true;
                        }
                        if (y+1 < m && arr[x][y+1].equals("1") && !visited[x][y+1]) {
                            queue.add(new int[]{x, y+1});
                            boxWidth++;
                            visited[x][y+1] = true;
                        }

                    }
                    if(boxWidth>0){
                        count++;
                        if (min<boxWidth){
                            min = boxWidth;
                        }
                    }
                }
            }

        }
       bw.write(count+"\n");
         bw.write(min+"\n");
          bw.flush();
          bw.close();
          br.close();

    }
}