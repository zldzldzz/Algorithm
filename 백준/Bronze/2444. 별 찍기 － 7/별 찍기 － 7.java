import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int length =2*n-1;
        for (int i = 0; i < n; i++) {

            int m=n-i;
            for (int j = 1; j < m; j++) {
                bw.write(" ");
            }
            for (int j = 0; j <= i; j++) {
                bw.write("*");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = 1; i < n; i++) {
            int m=n-i;//4
            for (int j = 0; j < i; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= m; j++) {
                bw.write("*");
            }
            for (int j = 1; j < m; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();

    }

}
