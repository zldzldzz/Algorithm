import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);


        int[] dx={1,0,-1,0};
        int[] dy= {0,1,0,-1};


        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q= new LinkedList<>();

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            int sx=Integer.parseInt(line[0]);
            int sy=Integer.parseInt(line[1]);
            int ex=Integer.parseInt(line[2]);
            int ey=Integer.parseInt(line[3]);
            for (int j = sx; j < ex; j++) {
                for (int l = sy; l <ey; l++) {
                    map[j][l]=1;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]&&map[i][j]==0){
                    visited[i][j]=true;
                    q.add(new int[]{i,j});
                    int size =1;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        for (int l = 0; l < 4; l++) {
                            int x= now[0]+dx[l];
                            int y= now[1]+dy[l];
                            if(x>=0&&y>=0&&x<m&&y<n){
                                if(map[x][y]==0&&!visited[x][y]){
                                    q.add(new int[]{x,y});
                                    visited[x][y]=true;
                                    size++;
                                }
                            }

                        }
                    }
                    list.add(size);
                }
            }
        }
        bw.write(String.valueOf(list.size())+"\n");
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            bw.write(list.get(i)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}