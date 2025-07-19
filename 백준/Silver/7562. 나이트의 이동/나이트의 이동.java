import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       String str = br.readLine();


       int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
       int[] dy = {2, 1, -1, -2, 2, 1, -1, -2};

       int caseNum =Integer.parseInt(str);
        for (int i = 0; i < caseNum; i++) {
            int size= Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[size][size];

            String[] startString = br.readLine().split(" ");
            String[] endString = br.readLine().split(" ");

            int[] start =new int[startString.length];
            start[0]= Integer.parseInt(startString[0]);
            start[1]= Integer.parseInt(startString[1]);

            int[] end =new int[endString.length];
            end[0]= Integer.parseInt(endString[0]);
            end[1]= Integer.parseInt(endString[1]);

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1], 0});
            visited[start[0]][start[1]] = true;
            
            while (!queue.isEmpty()){
                int[] now= queue.poll();
                if (now[0] == end[0] && now[1] == end[1]) {
                    bw.write(String.valueOf(now[2])+ "\n");
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx >= 0 && nx < size && ny >= 0 && ny < size && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, now[2] + 1});
                    }
                }

            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}



