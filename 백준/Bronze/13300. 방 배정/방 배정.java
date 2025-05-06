import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int[][] student = new int[2][6];


        String[] input = br.readLine().trim().split("\\s+");

        int totalStudnt= Integer.parseInt(input[0]);
        int maxRoomSize= Integer.parseInt(input[1]);

        for (int i = 0; i < totalStudnt; i++) {
            input = br.readLine().trim().split("\\s+");
            int S= Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1])-1;

            student[S][Y]++;

        }


        //방 개수 구하기
        int room=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {

                int S=student[i][j];

                if (S>0&&S<=maxRoomSize){
                    room++;
                } else if (S>maxRoomSize) {
                    room+=S/maxRoomSize;

                    if (S%maxRoomSize!=0){
                        room++;
                    }

                }
            }
        }
        bw.write(String.valueOf(room));
        bw.flush();
    }
}
