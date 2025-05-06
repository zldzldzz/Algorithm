import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());


        int[] answer= new int[length];

        for (int i = 0; i < length; i++) {
            String[] input = br.readLine().trim().split("\\s+");
            int a= Integer.parseInt(input[0]);
            int b= Integer.parseInt(input[1]);
            answer[i]=a+b;
        }
        for (int i : answer) {
            bw.write(String.valueOf(i));
            bw.write('\n');
        }
        bw.flush();

    }
}
