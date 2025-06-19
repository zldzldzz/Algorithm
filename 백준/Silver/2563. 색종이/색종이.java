import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[][] array = new int[100][100];

        for (int i = 0; i <length ; i++) {
             String str = br.readLine();
             String[] xAndy = str.split(" ");

            for (int j = Integer.parseInt(xAndy[0]); j < Integer.parseInt(xAndy[0])+10; j++) {
                for (int k = Integer.parseInt(xAndy[1]); k < Integer.parseInt(xAndy[1])+10; k++) {
                    array[j][k]=1;
                }
            }

        }
        int all=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                all+=array[i][j];
            }

        }
        bw.write(all+"\n");
        bw.close();

    }
}
