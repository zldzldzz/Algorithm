import java.io.*;
import java.sql.Array;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(String.valueOf(a*b*c));
        int[] answer=new int[10];
        for (int i = 0; i < sb.length(); i++) {
                answer[Integer.parseInt(String.valueOf(sb.charAt(i)))]++;
        }
        for (int i : answer) {
            System.out.println(i);

        }
    }
}
