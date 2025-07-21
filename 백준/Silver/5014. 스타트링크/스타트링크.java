import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int F = Integer.parseInt(input[0]); // Total number of floors
        int S = Integer.parseInt(input[1]); // Starting floor
        int G = Integer.parseInt(input[2]); // Goal floor
        int U = Integer.parseInt(input[3]); // Up button
        int D = Integer.parseInt(input[4]);
        
        boolean[] visited = new boolean[F+1];
        int[] arr = new int[F+1];
        Queue<Integer> q = new LinkedList<>();
        boolean find = false;

        q.add(S);
        visited[S] = true;
        while (!q.isEmpty()) {
            int now = (int) q.poll();
            if (now == G) {
                bw.write(String.valueOf(arr[now]));
                find = true;
                break;
            }
            int up = now + U;
            int down = now - D;
            if(up<=F&&!visited[up]){
                q.add(up);
                arr[up]=arr[now]+1;
                visited[up] = true;
            }
            if(down>0&&down<=F&&!visited[down]){
                q.add(down);
                arr[down]=arr[now]+1;
                visited[down] = true;
            }
        }
        
        if(!find){
            bw.write("use the stairs");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}