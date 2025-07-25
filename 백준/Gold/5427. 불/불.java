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
        
        int length = Integer.parseInt(br.readLine());
        for (int i = 0; i < length; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            r=m;
            c=n;

            int count=-1;
            map = new String[m][n];
            fireQ = new LinkedList<>();
            personQ = new LinkedList<>();

            for (int j = 0; j < m; j++) {
                String[] line = br.readLine().split("");
                for (int k = 0; k < n; k++) {
                    map[j][k] = line[k];
                    if(map[j][k].equals("@")){
                        personQ.add(new int[] {j,k,1});
                    } else if (map[j][k].equals("*")) {
                        fireQ.add(new int[] {j,k});
                    }
                }
            }
            while (count==-1){
                int fireSize=fireQ.size();
                for (int j = 0; j < fireSize; j++) {
                    int[] fire = fireQ.poll();
                    fireMoving(fire[0],fire[1]);
                }
                int personSize=personQ.size();
                for (int j = 0; j < personSize; j++) {
                    int[] person = personQ.poll();
                    count=personMoving(person[0], person[1], person[2]);
                    if (count!=-1){
                        break;
                    }
                }
                if (count!=-1){
                    break;
                }
                if(personQ.isEmpty()){
                    count=-1;
                    break;
                }
            }
            if(count==-1){
                bw.write("IMPOSSIBLE\n");

            }else {
                bw.write(String.valueOf(count)+"\n");
            }
        }


        bw.flush();
        bw.close();
        br.close();


    }
    static void fireMoving(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx>=0 && ny>=0 && nx<r && ny<c){
                if(map[nx][ny].equals("@")||map[nx][ny].equals(".")){
                    map[nx][ny]="*";
                    fireQ.add(new int[] {nx,ny});
                }
            }
        }
    }
    static int personMoving(int x, int y,int time) {
        for (int i = 0; i < 4; i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(x==0||y==0||x==r-1||y==c-1){
                return time;
            }
            if (nx>=0 && ny>=0 && nx<r && ny<c){
                if(map[nx][ny].equals(".")){
                    map[nx][ny]="@";
                    personQ.add(new int[] {nx,ny,time+1});
                }
            }
        }
        return -1;
    }

}