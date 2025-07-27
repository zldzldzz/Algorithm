import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx={1,0,-1,0,0,0};
        int[] dy= {0,1,0,-1,0,0};
        int[] dz ={0,0,0,0,1,-1};


        while (true) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            String[][][] map = new String[r][c][l];
            boolean[][][] visited = new boolean[r][c][l];

            if(l==0&&r==0&&c==0){
                break;
            }
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String[] line = br.readLine().split("");
                    for (int k = 0; k < c; k++) {
                        map[j][k][i]=line[k];
                        if(map[j][k][i].equals("S")){
                            visited[j][k][i]=true;
                            q.add(new int[]{j,k,i,0});
                        }
                    }
                }
                br.readLine();
            }
            boolean find = false;

            while(!q.isEmpty()){
                int[] now = q.poll();
                if(map[now[0]][now[1]][now[2]].equals("E")){
                    find=true;
                    bw.write("Escaped in "+String.valueOf(now[3])+" minute(s).\n");
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int x = now[0] + dx[i];
                    int y = now[1] + dy[i];
                    int z = now[2] + dz[i];
                    if(x>=0&&y>=0&&z>=0&&x<r&&y<c&&z<l){
                        if (!visited[x][y][z]&&(map[x][y][z].equals(".")||map[x][y][z].equals("E"))){
                            q.add(new int[]{x,y,z,now[3]+1});
                            visited[x][y][z]=true;
                        }
                    }
                }
            }

            if(!find){
                bw.write("Trapped!\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}



