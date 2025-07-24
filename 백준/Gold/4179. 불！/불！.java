import java.io.*;
import java.util.*;

public class Main {

    static int r,c;
    static String[][] map;
    static Queue<int[]> fireQ, personQ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        fireQ = new LinkedList<>();
        personQ = new LinkedList<>();
        map = new String[r][c];
        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j < c; j++) {
                map[i][j]=line[j];
                if(map[i][j].equals("J")){
                    personQ.add(new int[] {i,j,0});
                } else if (map[i][j].equals("F")) {
                    fireQ.add(new int[]{i,j});
                }
            }
        }
        int moves = -1;
        while (moves==-1){
            int fSize = fireQ.size();
            for (int i = 0; i < fSize; i++) {
                int[] f = fireQ.poll();
                fireMoving(f[0],f[1]);
            }
            int pSize = personQ.size();
            if (pSize == 0) {
                moves = -1;
                break;
            }

            for (int i = 0; i < pSize; i++) {
                int[] p = personQ.poll();
                moves = personMoving(p[0], p[1], p[2]);
                if (moves != -1) break;
            }
        }
        if (moves==-1){
            bw.write("IMPOSSIBLE\n");
        }else {
            bw.write(String.valueOf(moves));
        }
        bw.flush();
        bw.close();
        br.close();


    }
    static void fireMoving(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx > r-1 || ny > c-1) continue;

            if(map[nx][ny].equals(".")  || map[nx][ny].equals("J")) {
                map[nx][ny] = "F";
                fireQ.add(new int[] {nx, ny});
            }
        }
    }
    static int personMoving(int x, int y,int time) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 ||  nx>r-1 || ny>c-1) {
                return time+1;
            }
            if(map[nx][ny].equals(".") ) {
                map[nx][ny]="J";
                personQ.add(new int[] {nx, ny, time+1});
            }
        }
        return -1;
    }

}